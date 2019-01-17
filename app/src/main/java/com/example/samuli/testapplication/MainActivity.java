package com.example.samuli.testapplication;

import android.os.Bundle;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;

import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.Spinner;
import android.widget.TextView;


import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    TextView textView;
    Spinner spinner;
    Spinner elokuvaSP;
    Spinner pvmSP;
    Spinner kloSP;
    String paikkakunta = "";
    String elokuva="";


    public ArrayList<String> päivämäärä_array;
    public ArrayList<String> kellonaika_array;
    public ArrayList<String> paikka_array;
    Elokuvateatterit et = new Elokuvateatterit();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        super.onCreate(savedInstanceState);
        et.readXML();
        setContentView(R.layout.activity_main);
        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter=new ArrayAdapter(this,android.R.layout.simple_spinner_item, et.paikkakunta_array);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        elokuvaSP = (Spinner) findViewById(R.id.elokuva);
        ArrayAdapter<String> adapter2 =new ArrayAdapter(this,android.R.layout.simple_spinner_item, et.elokuva_array);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        elokuvaSP.setAdapter(adapter2);
        /*
        pvmSP = (Spinner) findViewById(R.id.pvm);
        ArrayAdapter<String> adapter3 =new ArrayAdapter(this,android.R.layout.simple_spinner_item, päivämäärä_array);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        pvmSP.setAdapter(adapter3);
        kloSP = (Spinner) findViewById(R.id.klo);
        ArrayAdapter<String> adapter4 =new ArrayAdapter(this,android.R.layout.simple_spinner_item, kellonaika_array);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

*/




       spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                paikkakunta = parent.getItemAtPosition(position).toString();
                if (paikkakunta=="Tennispalatsi, Helsinki") {
                    et.elokuva_array = et.Tennispalatsi_elokuvat;
               /* } if (){
                        if(paikkakunta.equals()){

                        }
                    }*/

                    System.out.println("-----Paikkakunta valittu------");

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                System.out.println("Nothing selected");
            }
        });
elokuvaSP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        elokuva=parent.getItemAtPosition(position).toString();

        System.out.println("-----Elokuva valittu------");
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
});

    }
}


