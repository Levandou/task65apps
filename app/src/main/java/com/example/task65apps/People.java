package com.example.task65apps;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class People extends Specialty {


        private String f_name;
        private String l_name;
        private String birthday;
        private int age;
        private String avatr_url;
        private ArrayList<Specialty> specialty=new ArrayList<>();


    public ArrayList<Specialty> getSpecialty() {
        return specialty;
    }

   public void setSpecialty(ArrayList<Specialty> specialty) {
        this.specialty = specialty;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void people(String f_name, String l_name)
        {
            this.f_name=f_name;
            this.l_name=l_name;
        }


        /*Начало получения названия должности */

        public String getNamesFromSpecialty()
        {
            return specialty.get(0).getName() ;
        }

        public String getSpecialty_idFromSpecialty(){
            return specialty.get(0).getSpecialty_id() ;
        }

        /*Конец получения названия должности*/



         @RequiresApi(api = Build.VERSION_CODES.O)
         public void name_change()
         {
            /*Начало изменения отображения даты рождения */

                    String date=null;
                    String month=null;

                    if (birthday!=null ) {

                        if (birthday.equals(""))
                        {
                            setBirthday("-");
                        }
                        else
                            {
                                    Calendar cal = Calendar.getInstance();


                                    int firstDashIndex=birthday.indexOf("-");

                                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

                                    if (firstDashIndex>3)
                                     {
                                         sdf = new SimpleDateFormat("yyyy-MM-dd");
                                     }


                                    try {
                                        cal.setTime(sdf.parse(birthday));
                                    } catch (ParseException e) {
                                        e.printStackTrace();
                                    }


                                    String data=null;
                                    if(cal.get(Calendar.DATE)<10 || cal.get(Calendar.MONTH)<9)
                                    {

                                        if (cal.get(Calendar.DATE) < 10 && cal.get(Calendar.MONTH) < 9)
                                        {
                                            data = "0" + String.valueOf(cal.get(Calendar.DATE)) + ".0" + String.valueOf(cal.get(Calendar.MONTH) + 1) + "." + String.valueOf(cal.get(Calendar.YEAR));
                                        }

                                        if (cal.get(Calendar.DATE) < 10 && cal.get(Calendar.MONTH) > 9)
                                        {
                                            data = "0" + String.valueOf(cal.get(Calendar.DATE)) + "." + String.valueOf(cal.get(Calendar.MONTH) + 1) + "." + String.valueOf(cal.get(Calendar.YEAR));
                                        }

                                        if (cal.get(Calendar.DATE) > 10 && cal.get(Calendar.MONTH) < 9)
                                        {
                                            data = String.valueOf(cal.get(Calendar.DATE)) + ".0" + String.valueOf(cal.get(Calendar.MONTH) + 1) + "." + String.valueOf(cal.get(Calendar.YEAR));
                                        }
                                    }
                                     else
                                      {
                                         data = String.valueOf(cal.get(Calendar.DATE)) + "." + String.valueOf(cal.get(Calendar.MONTH)+1) + "." + String.valueOf(cal.get(Calendar.YEAR));
                                      }
                                    setBirthday(data);

                            }
                       }
                      else {
                           setBirthday("-");
                       }

             /*Конец изменения отображения даты рождения */



              /*Начало поиска возраста работник*/

                      if(birthday==null||birthday.equals("-")) {
                          setAge(0);}

                      else

                          {
                              DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                              LocalDate startDate = LocalDate.parse(birthday, formatter);
                              Calendar nowDate = Calendar.getInstance();
                              LocalDate now = LocalDate.of(nowDate.get(Calendar.YEAR), nowDate.get(Calendar.MONTH) + 1, nowDate.get(Calendar.DATE));
                              Period period = Period.between(startDate, now);
                              setAge(period.getYears());

                         }
              /*Конец поиска возраста работник*/




                /* Начало изменения букв имени */

                        String modifiedName="";
                        modifiedName=f_name.toLowerCase();
                        setF_name(modifiedName.substring(0, 1).toUpperCase() + modifiedName.substring(1));
                        modifiedName=l_name.toLowerCase();
                        setL_name(modifiedName.substring(0, 1).toUpperCase() + modifiedName.substring(1));

                /* Конец изменения букв имени */

        }




        public String getAvatr_url() {
            return avatr_url;
        }



        public String getL_name() {
            return l_name;
        }

        public String getF_name() {
            return f_name;
        }

        public String getBirthday() {
            return birthday;
        }




        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public void setF_name(String f_name) {
            this.f_name = f_name;
        }

        public void setAvatr_url(String avatr_url) {
            this.avatr_url = avatr_url;
        }

        public void setL_name(String l_name) {
            this.l_name = l_name;
        }



    @Override
    public String toString() {
        return "People{" +
                "f_name=" + f_name + '\n' +
                " l_name=" + l_name + '\n' +
                " birthday=" + birthday + '\n' +
                " age="+age+'\n'+
                " avatr_url=" + avatr_url + '\n' +
                " specialty=" + specialty +
                '}';
    }
}
