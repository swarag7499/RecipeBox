package com.example.juhileenazare.recipebox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

public class Lunch4 extends AppCompatActivity {

    ArrayList<String> selected_ingredients=new ArrayList<>();
    ArrayList<String> r_names=new ArrayList<>();
    ArrayList<String> sub=new ArrayList<>();
    ArrayList<String> additional=new ArrayList<>();
    ArrayList<String> f_list=new ArrayList<>();
    ListView list;
    public static String selectedFromList;
    public static String s1,s2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunch4);
        this.selected_ingredients=Lunch_1.selected_ingredients;

        list=findViewById(R.id.recipes);



        AssetManager assetManager=getAssets();


        try{

            String[] files=assetManager.list("Lunch");
            String s5="$";
            String s=null;
            for (int i = 0; i < selected_ingredients.size(); i++) {

                s = (String.valueOf(selected_ingredients.get(i)) + "_");
                sub.add(String.valueOf(selected_ingredients.get(i))+ "_");
                s5=s5+s;


            }

            // t1.append("\n");
            // t1.append(""+s5);





            for(int i=0;i<files.length;i++){
                int flag=0;

                if ((files[i].contains(s5) || files[i].contains(s5.substring(1))) && files[i].endsWith(".txt")) {
                    r_names.add(files[i].substring(0, files[i].indexOf('$')));

                } else flag++;


            }

            for(int i=0;i< files.length;i++) {
                for (int j = 0; j < sub.size(); j++) {
                    int flag1 = 0;
                    if (files[i].contains(sub.get(j))) {
                        if(!additional.contains(files[i].substring(0, files[i].indexOf('$'))))
                            additional.add(files[i].substring(0, files[i].indexOf('$')));
                    } else flag1++;
                }
            }

            for(String obj : additional) {      // iterate through the second list
                if (!r_names.contains(obj)) {   // if first list doesn't contain current element
                    r_names.add(obj);          // add it to the first list
                }
            }







            ArrayAdapter<String> adapter=new ArrayAdapter<String>(Lunch4.this,R.layout.r_list,R.id.label,r_names);
            list.setAdapter(adapter);


            list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    selectedFromList =(String) list.getItemAtPosition(position).toString();
                    s1=selectedFromList.toLowerCase();
                    s2=s1.replaceAll(" ","");
                    Toast.makeText(getApplicationContext(),selectedFromList,Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(Lunch4.this,Lunch5.class);
                    startActivity(intent);

                }});

        }catch(IOException e1){
            e1.printStackTrace();
        }




    }
    public void onBackPressed() {
        startActivity(new Intent(this, Lunch_1.class));
        selected_ingredients.clear();
        finish();
        return;
    }


}
