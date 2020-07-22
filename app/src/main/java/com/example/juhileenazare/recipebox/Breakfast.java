package com.example.juhileenazare.recipebox;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.juhileenazare.recipebox.R;

import java.util.ArrayList;

public class Breakfast extends Activity {
    public static ArrayList<String> selected_ingredients=new ArrayList();
    GridView gridview;

    public static String[] osNameList = {
            "Rice",
            "Urad Daal",
            "Chana daal",
            "Rice Flour",
            "Semolina",
            "Bread",
            "Mayonnaise",
            "Cheese",
            "Butter",
            "Tofu",
            "Poha",
            "Sago",
            "Pepper",
            "Tomato",
            "Onion",
            "Ghee",
            "Potato",
            "Carrot",
            "Wheat Flour",
            "Fenugreek",
            "Spinach",
            "Capsicum"
    };
    public static int[] osImages = {
            R.mipmap.rice,
            R.mipmap.uraddal,
            R.mipmap.chanadal,
            R.mipmap.riceflour,
            R.mipmap.semonila,
            R.mipmap.bread,
            R.mipmap.mayonnaise,
            R.mipmap.cheese,
            R.mipmap.butter,
            R.mipmap.tofu,
            R.mipmap.poha,
            R.mipmap.sago,
            R.mipmap.pepper,
            R.mipmap.tomatoes,
            R.mipmap.onion,
            R.mipmap.ghee,
            R.mipmap.potatoes,
            R.mipmap.carrot,
            R.mipmap.wheatflour,
            R.mipmap.fenugreek,
            R.mipmap.spinach,
            R.mipmap.capsicum
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breakfast);
        gridview = (GridView) findViewById(R.id.customgrid);
        gridview.setAdapter(new CustomAdapter(this, osNameList, osImages));
    }





    public class CustomAdapter extends BaseAdapter {

        String [] result;
        Context context;
        int [] imageId;
        private  LayoutInflater inflater=null;
        public CustomAdapter(Breakfast breakfast, String[] osNameList, int[] osImages) {
            // TODO Auto-generated constructor stub
            result=osNameList;
            context=breakfast;
            imageId=osImages;
            inflater = ( LayoutInflater )context.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return result.length;
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        public class Holder
        {
            TextView os_text;
            ImageView os_img;
        }
        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub
            Holder holder=new Holder();
            View rowView;

            rowView = inflater.inflate(R.layout.sample_gridlayout, null);
            holder.os_text =(TextView) rowView.findViewById(R.id.os_texts);
            holder.os_img =(ImageView) rowView.findViewById(R.id.os_images);
            //  holder.os_img.setCropToPadding(true);
            holder.os_img.setAdjustViewBounds(true);
            holder.os_img.setBackgroundColor(1);
            holder.os_text.setText(result[position]);
            holder.os_img.setImageResource(imageId[position]);



            rowView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    Toast.makeText(context, "You Clicked "+result[position], Toast.LENGTH_SHORT).show();
                    v.setBackgroundResource(R.drawable.rounded_corner);
                    selected_ingredients.add(""+result[position].toLowerCase().replaceAll(" ",""));

                }
            });

            return rowView;
        }

    }


    public void nextBtn(View view){
        Intent intent=new Intent(Breakfast.this,Breakfast1.class);
        startActivity(intent);
    }

    public void onBackPressed() {
        startActivity(new Intent(this, MainActivity.class));
        selected_ingredients.clear();
        finish();
        return;
    }
}
