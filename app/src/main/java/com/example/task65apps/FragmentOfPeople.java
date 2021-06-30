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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;



public class FragmentOfPeople extends Fragment {

    TextView textView;
    ListView listView;
    ListView listView1;
    String[] strings={"qwerty","qwes"};
    ArrayList<String>allList=new ArrayList<>();
    ArrayList<String>names=new ArrayList<>();
    ArrayList<Integer>number=new ArrayList<>();
    String selected;
    int j=0;
    Bundle bundle = new Bundle();
    Fragment fragment;
    FragmentTransaction ft;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        ActionBar actionBar = ((MainActivity)getActivity()).getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
       View view=inflater.inflate(R.layout.fragment_of_people,container,false);
       View view1=inflater.inflate(R.layout.activity_main,container,false);
       // setHasOptionsMenu(true);
        listView1=view1.findViewById(R.id.LIstView1);
         listView= view.findViewById(R.id.list);

        Bundle bundle=this.getArguments();
        if (bundle!=null){
            allList=bundle.getStringArrayList("allList");
            selected=bundle.getString("selected");
        }

        Log.i("selected", String.valueOf(allList));
        for(int i=5;i<allList.size();i=i+7){
            if(selected.equals(allList.get(i))){
                if (allList.get(i-2).equals("0")) {
                    names.add(j, allList.get(i - 5) + " " + allList.get(i - 4) + ", " + "возраст не указан");

                }
                else {  names.add(j, allList.get(i - 5) + " " + allList.get(i - 4) + ", " + allList.get(i - 2) + " лет");}
                number.add(j,i-5);
                j++;
            }
        }



        ArrayAdapter<String> adapter= new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1,names);
      //   getActivity().getApplicationContext(), android.R.layout.simple_list_item_1 ,getActivity().
           listView.setAdapter(adapter);
           fragment=new Fragment_employee();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ft=getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.fcontainer,fragment);
                bundle.putStringArrayList("qa",allList);
                bundle.putInt("number",number.get(position));
                bundle.putString("selected",selected);
                fragment.setArguments(bundle);
                ft.commit();
            }
        });
                return view;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();
          //  listView1.setVisibility(View.VISIBLE);
            ((MainActivity)getActivity()).Visible();
        }
        return super.onOptionsItemSelected(item);
    }
}