package com.example.task65apps;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;

public class All extends People {
    private ArrayList<People> response;


    public void all(ArrayList<People> response){
        this.response=response;
    }


    public ArrayList<People> getPeople() {
        return response;
    }



    public void setPeople(ArrayList<People> people) {
        this.response = people;
    }


     public int size()
    {
    return response.size();
    }



    /*Начало получения данных работников*/
    public String getAllF_name(int i){
        return response.get(i).getF_name();
    }

    public String getAllL_name(int i){
        return response.get(i).getL_name();
    }

    public String getAllBirthday(int i){
        return response.get(i).getBirthday();
    }

    public String getAllAge(int i){
        return String.valueOf(response.get(i).getAge());
    }

    public String getAllAvatr_url(int i){
            return response.get(i).getAvatr_url();
    }

    public String getAllSpecialty_id(int i){
        return response.get(i).getSpecialty_idFromSpecialty();
    }

    public String getAllNames(int i) {
        return response.get(i).getNamesFromSpecialty();
    }
    /*Конец получения данных работников */


    @RequiresApi(api = Build.VERSION_CODES.O)
    public void largeLetter()
    {
    int size = response.size();
        for (int i = 0; i < size;i++)
        {
            People people=new People();
            people=response.get(i);
            people.name_change();
            response.set(i,people);
        }
    }

    @Override
    public String toString() {
        return "all{" +
                "people=" + response +
                '}';
    }
}
