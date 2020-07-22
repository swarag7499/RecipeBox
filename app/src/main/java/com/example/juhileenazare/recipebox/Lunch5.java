package com.example.juhileenazare.recipebox;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lunch5 extends AppCompatActivity {
    TextView tv1,tv2;
    ImageView imgview;
    String s1,s2;
    String selectedFromList;
    String file_to_be_opened;
    String filename;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunch5);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        this.selectedFromList= Lunch4.selectedFromList;
        setTitle(""+selectedFromList);
        this.s2=Lunch4.s2;
        tv2=findViewById(R.id.textView);
        StringBuilder text = new StringBuilder();
        BufferedReader reader = null;
        try {
            AssetManager assetManager=getAssets();
            String files[]=assetManager.list("Lunch");
            for(int i=0;i<files.length;i++){
                int flag=0;
                if(files[i].contains(selectedFromList) && files[i].endsWith(".txt")){
                    filename="Lunch/"+files[i];
                }
                else flag++;
            }

            reader = new BufferedReader(
                    new InputStreamReader(getAssets().open(filename)));


            String mLine;
            while ((mLine = reader.readLine()) != null) {
                text.append(mLine);
                text.append('\n');
            }
        } catch (IOException e) {
            Toast.makeText(getApplicationContext(), "Error reading file!", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    //log the exception
                }
            }

            //   TextView output= (TextView) findViewById(R.id.textView2);
            tv2.setText((CharSequence) text);

        }


        imgview=findViewById(R.id.imageView);
        int imgId=getResourseId(this,s2,"drawable",getPackageName());
        //  imgview.setLayoutParams(new ViewGroup.LayoutParams(450, 450));
        imgview.setImageResource(imgId);

    }

    public static int getResourseId(Context context, String pVariablename, String pResourceName, String pPackageName){

        try{
            return context.getResources().getIdentifier(pVariablename,pResourceName,pPackageName);
        }
        catch(Exception e){
            throw new RuntimeException("Error getting resource id",e);
        }
    }
}
