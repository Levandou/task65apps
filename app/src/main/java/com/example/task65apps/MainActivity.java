package com.example.task65apps;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutionException;


public class MainActivity<se> extends AppCompatActivity
{

    private String url = "https://gitlab.65apps.com/65gb/static/raw/master/testTask.json";
    private Calendar ccalendar=new GregorianCalendar(2017,0,25);
    private SimpleDateFormat date=new SimpleDateFormat();
    private String s="05.09.2020";
    private ArrayList<String> setA=new ArrayList<>();
    private ArrayList<String> allList=new ArrayList<>();
    private Bundle bundle = new Bundle();
    private Fragment fragment;
    private FragmentTransaction ft;
    private ListView listView;
    private SQLite sqLite;
    private String fname;


    @RequiresApi(api = Build.VERSION_CODES.O)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        listView =(ListView) findViewById(R.id.LIstView1);
        DownloadJSON task = new DownloadJSON();
        task.execute("https://gitlab.65apps.com/65gb/static/raw/master/testTask.json");
        all.largeLetter();                                                               //largeLetter не только работает с f_name и l_name а также приводит дату к "нормальному виду" и определяет возраст

        /*Чтобы не было повторяющихся элементов*/
        for(int i=0;i<all.size();i++)
        {
        setA.add(i,all.getAllNames(i));
        }
        Set<String> set=new HashSet<>(setA);
        setA.clear();
        setA.addAll(set);
        int j=0;

        /*переместим из классов в arrayList*/
        for (int i=0;i<all.size();i++)
        {
            allList.add(j,all.getAllF_name(i));
            j++;
            allList.add(j,all.getAllL_name(i));
            j++;
            allList.add(j,all.getAllBirthday(i));
            j++;
            allList.add(j,all.getAllAge(i));
            j++;
            allList.add(j,all.getAllAvatr_url(i));
            j++;
            allList.add(j,all.getAllNames(i));
            j++;
            allList.add(j,all.getAllSpecialty_id(i));
            j++;
        }
        fragment=new FragmentOfPeople();

        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,setA);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
             String selected=setA.get(position);
                ft=getSupportFragmentManager().beginTransaction();
                ft.add(R.id.fcontainer, fragment);
                bundle.putString("selected",selected);
                bundle.putStringArrayList("allList",allList);
                fragment.setArguments(bundle);
                ft.commit();
                listView.setVisibility(View.INVISIBLE);
            }
        });


        sqLite=new SQLite(this);
        SQLiteDatabase database=sqLite.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        for (int i=0;i<allList.size();i++) {
            contentValues.put(Contract.SQL.KEY_FNAME, allList.get(i));          i++;
            contentValues.put(Contract.SQL.KEY_LNAME, allList.get(i));          i++;
            contentValues.put(Contract.SQL.KEY_BIRTHDAY, allList.get(i));       i++;
            contentValues.put(Contract.SQL.KEY_AGE, allList.get(i));            i++;
            contentValues.put(Contract.SQL.KEY_URL, allList.get(i));            i++;
            contentValues.put(Contract.SQL.KEY_SPECIALTY, allList.get(i));      i++;
            contentValues.put(Contract.SQL.KEY_SPECIALTYID, allList.get(i));
        }
        database.insert(Contract.SQL.TABLE_CONTACTS, null,contentValues);
        Cursor cursor=database.query(Contract.SQL.TABLE_CONTACTS,null,null,null,null,null,null);
    }


    private static class DownloadJSON extends AsyncTask<String, Void, String>
    {

        @Override
        protected String doInBackground(String... strings)
        {
            URL url = null;
            HttpURLConnection urlConnection = null;
            StringBuilder result = new StringBuilder();

            try
            {
                url = new URL(strings[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = urlConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader reader = new BufferedReader(inputStreamReader);
                String line = reader.readLine();

                while (line != null)
                {
                    result.append(line);
                    line = reader.readLine();
                }

            }
            catch (MalformedURLException e)
            {
                e.printStackTrace();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
            finally
            {
                if (urlConnection != null)
                {
                    urlConnection.disconnect();
                }
            }
            return result.toString();
        }


        @Override
        protected void onPostExecute(String s)
        {
            super.onPostExecute(s);
            Log.i("JSON", s);
        }


    }


    DownloadJSON downloadJSON = new DownloadJSON();
    String jsonText;
    {
        try
        {
            jsonText = downloadJSON.execute(url).get();
        }

        catch (ExecutionException e)
        {
            e.printStackTrace();
        }

        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    Gson gson = new Gson();
    All all = gson.fromJson(jsonText, All.class);

    public ArrayList<String> getAll(){
        return setA;
}

public void Visible(){
        listView.setVisibility(View.VISIBLE);
fragment=new FragmentOfPeople();
}
}