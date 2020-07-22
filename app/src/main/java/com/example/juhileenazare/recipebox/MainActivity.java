package com.example.juhileenazare.recipebox;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.util.Calendar;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawerlayout;
    private ActionBarDrawerToggle mToggle;
    NavigationView navigationView;



    private static final String TAG = "WELCOME";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView textView7 = (TextView) findViewById(R.id.textView7);
        //     Date date = new Date();
        Calendar cal = Calendar.getInstance();
        //   cal.setTime(date);
        int hour = cal.get(Calendar.HOUR_OF_DAY);

        String greeting = null;
        if (hour>=0 && hour<6){
            greeting = "Dreams";
        }
        else if(hour>=6 && hour<12){
            greeting = "BreakFast";
        } else if(hour>= 12 && hour < 17){
            greeting = "Lunch";
        } else if(hour >= 17 && hour < 21){
            greeting = "Snacks";
        } else if(hour >= 21 && hour <=24){
            greeting = "Dinner";
        }

        textView7.setText( greeting + " " + "!");
        Log.d(TAG,"onCreate:Starting.");


        navigationView = findViewById (R.id.navView);
        navigationView.setNavigationItemSelectedListener (new NavigationView.OnNavigationItemSelectedListener () {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId ()) {
                    case R.id.home:
                        Toast.makeText (getApplicationContext (), "Home", Toast.LENGTH_SHORT).show ();
                        startActivity (new Intent (MainActivity.this, MainActivity.class));
                        return true;
                    case R.id.bf:
                        Toast.makeText (getApplicationContext (), "BreakFast", Toast.LENGTH_SHORT).show ();
                        startActivity (new Intent (MainActivity.this, Breakfast.class));
                        return true;
                    case R.id.lunch:
                        Toast.makeText (getApplicationContext (), "lunch", Toast.LENGTH_SHORT).show ();
                        startActivity (new Intent (MainActivity.this, Lunch_1.class));
                        return true;
                    case R.id.snacks:
                        Toast.makeText (getApplicationContext (), "Snacks", Toast.LENGTH_SHORT).show ();
                        startActivity (new Intent (MainActivity.this, Snacks.class));
                        return true;
                    case R.id.dinner:
                        Toast.makeText (getApplicationContext (), "Dinner", Toast.LENGTH_SHORT).show ();
                        startActivity (new Intent (MainActivity.this, Lunch_1.class));
                        return true;
                    case R.id.list:
                        Toast.makeText (getApplicationContext (), "List", Toast.LENGTH_SHORT).show ();
                        startActivity (new Intent (MainActivity.this, ToDoList.class));
                        return true;
                    case R.id.logout:
                        Toast.makeText (getApplicationContext (), "Logout", Toast.LENGTH_SHORT).show ();
                        startActivity (new Intent (MainActivity.this, Login.class));
                        return true;
                }
                // mDrawerlayout.closeDrawers();
                return false;
            }
        });




        // mDrawerlayout = (DrawerLayout) findViewById (R.id.drawer);
        //mToggle = new ActionBarDrawerToggle (this,mDrawerlayout,R.string.open,R.string.close);
        //mDrawerlayout.addDrawerListener (mToggle);
        //mToggle.syncState ();
        //getSupportActionBar () .setDisplayHomeAsUpEnabled (true);

    }

    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected (item)){
            return true;
        }

        return super.onOptionsItemSelected (item);
    }*/

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.drawermenu, menu);
        return true;
    }*/

public void proceed(View v){
    Calendar cal1 = Calendar.getInstance();
    int hour = cal1.get(Calendar.HOUR_OF_DAY);


  /*  if (hour>=1 && hour<6){
       Intent intent=new Intent(MainActivity.this,Breakfast.class);
       startActivity(intent);
    }*/
     if(hour>=6 && hour<12){
        Intent intent=new Intent(MainActivity.this,Breakfast.class);
        startActivity(intent);
    } else if(hour>= 12 && hour < 17){
         Intent intent=new Intent(MainActivity.this,Lunch_1.class);
         startActivity(intent);
    } else if(hour >= 17 && hour < 21){
         Intent intent=new Intent(MainActivity.this,Snacks.class);
         startActivity(intent);
    }
     else if(hour >= 21 && hour <=24){
         Intent intent=new Intent(MainActivity.this,Lunch_1.class);
         startActivity(intent);
     }

     else if(hour >=0 && hour < 6){
         Toast.makeText (getApplicationContext (), "GOOD NIGHT!", Toast.LENGTH_SHORT).show ();
     }
}

}