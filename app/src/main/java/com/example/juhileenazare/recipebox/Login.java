package com.example.juhileenazare.recipebox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText user, pass;
    Button login, not_reg;
    DataBaseHandler db;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user = (EditText) findViewById(R.id.eduser);
        pass = (EditText) findViewById(R.id.edpass);
        login = (Button) findViewById(R.id.login);
        not_reg = (Button) findViewById(R.id.not_reg);

        login.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                if (validate()) {
                    db = new DataBaseHandler(Login.this, null, null, 2);
                    String username = user.getText().toString();
                    String password = pass.getText().toString();

                    String StoredPassword = db.getregister(username);
                    if (password.equals(StoredPassword)) {

                        Toast.makeText(getApplicationContext(),  " Login Successful", Toast.LENGTH_LONG).show();
                        Intent i = new Intent(Login.this, MainActivity.class);
                        startActivity(i);
                        finish();

                    } else {
                        Toast.makeText(getApplicationContext(), "Username/Password incorrect", Toast.LENGTH_LONG).show();
                        user.setText("");
                        pass.setText("");
                    }
                }
            }
            public boolean validate() {
                boolean valid = false;
                String Username = user.getText().toString();
                String Pass = pass.getText().toString();
                if(Username.isEmpty() || Pass.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Enter missing fields",Toast.LENGTH_LONG).show();
                    valid=false;
                }
                else
                {
                    valid=true;
                }
                return valid;
            }
        });
        not_reg.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
            }
        });
    }
}
