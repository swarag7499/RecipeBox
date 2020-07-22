package com.example.juhileenazare.recipebox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.R.string;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText first,last,email,mobile,pass,confpass;
    Button save,cancel;
    DataBaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        first= (EditText)findViewById(R.id.editfirstname);
        last =(EditText)findViewById(R.id.editlastname);
        email=(EditText)findViewById(R.id.editemail);
        mobile =(EditText)findViewById(R.id.editmobileno);
        pass=(EditText)findViewById(R.id.editpassword);
        confpass=(EditText)findViewById(R.id.editconformpassword);
        save=(Button)findViewById(R.id.btnsave);
        //  cancel=(Button)findViewById(R.id.btncancel);


        save.setOnClickListener(new OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                if (validate()) {
                    String edfirst = first.getText().toString();
                    String edlast = last.getText().toString();
                    String edemail = email.getText().toString();
                    String edmobile = mobile.getText().toString();
                    String edpass = pass.getText().toString();
                    String edConf = confpass.getText().toString();

                    if (edConf.equals(edpass)) {
                        db = new DataBaseHandler(RegisterActivity.this, null, null, 2);
                        RegisterData reg = new RegisterData();
                        reg.setfirstName(edfirst);
                        reg.setlastName(edlast);
                        reg.setEmailId(edemail);
                        reg.setMobNo(edmobile);
                        reg.setPassword(edpass);
                        db.addregister(reg);
                        if (!db.isemailExists(edemail)) {
                            db = new DataBaseHandler(RegisterActivity.this, null, null, 2);
                            RegisterData reg1 = new RegisterData();
                            reg1.setfirstName(edfirst);
                            reg1.setlastName(edlast);
                            reg1.setEmailId(edemail);
                            reg1.setMobNo(edmobile);
                            reg1.setPassword(edpass);
                            db.addregister(reg1);
                            Toast.makeText(RegisterActivity.this, "User created successfully! Please Login ", Toast.LENGTH_LONG).show();
                            Intent i = new Intent(RegisterActivity.this, Login.class);
                            startActivity(i);
                            finish();
                        } else {
                            Toast.makeText(RegisterActivity.this, "Sorry..User exists with same email", Toast.LENGTH_LONG).show();
                            first.setText("");
                            last.setText("");
                            email.setText("");
                            mobile.setText("");
                            pass.setText("");
                            confpass.setText("");
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Password doesn't match", Toast.LENGTH_LONG).show();
                        pass.setText("");
                        confpass.setText("");
                    }

                }
            }
            @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
            public boolean validate() {
                boolean valid=false;
                String LName = last.getText().toString();
                String FName=first.getText().toString();
                String EName=email.getText().toString();
                String MName=mobile.getText().toString();
                String PName=pass.getText().toString();
                if (LName.isEmpty() || FName.isEmpty() || EName.isEmpty() || MName.isEmpty() || PName.isEmpty()) {
                    valid = false;
                    Toast.makeText(getApplicationContext(), "Enter missing fields", Toast.LENGTH_LONG).show();
                }
                else{
                    valid =true;
                }

                return valid;
            }
        });
    }
}
