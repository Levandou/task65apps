package com.example.task65apps;


import android.os.Bundle;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;



public class Fragment_employee extends Fragment {
    Bundle bundle=new Bundle();
    ArrayList<String> allList=new ArrayList<>();
    int number;
    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    TextView textView5;
    ImageView imageView;
    String selected;
    String url;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        ActionBar actionBar = ((MainActivity)getActivity()).getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        View view=inflater.inflate(R.layout.fragment_employee,container,false);
        imageView=view.findViewById(R.id.imageView);
        textView1=view.findViewById(R.id.textView1);
        textView2=view.findViewById(R.id.textView2);
        textView3=view.findViewById(R.id.textView3);
        textView4=view.findViewById(R.id.textView4);
        textView5=view.findViewById(R.id.textView5);

        Bundle bundle=this.getArguments();
        if (bundle!=null){
            allList=bundle.getStringArrayList("qa");
            number=bundle.getInt("number");
            selected=bundle.getString("selected");
        }
        url=allList.get(number+4);
        Log.i("qwertyui", String.valueOf(number+4));
      if(url==null || url.equals(""))
      {  }
      else
      {  Picasso.get().load(url).into(imageView);}
        textView1.setText(allList.get(number)+" "+allList.get(number+1));
        textView2.setText(allList.get(number+2));
        textView3.setText(allList.get(number+3)+" лет");
        textView4.setText(allList.get(number+5));
        textView5.setText("id:"+allList.get(number+6));
   return view;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            Bundle bundle=new Bundle();
            bundle.putStringArrayList("allList",allList);
            bundle.putString("selected",selected);
            Fragment fragment;
            FragmentTransaction ft;
            fragment=new FragmentOfPeople();
            ft=getActivity().getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fcontainer,fragment);
            fragment.setArguments(bundle);
            ft.commit();
        }
        return super.onOptionsItemSelected(item);
    }
}