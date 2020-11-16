package com.example.projectmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {
    //Session session;
   // DB_sqlite db = new DB_sqlite(login.this);
    EditText tuser,tpass;
    TextView t;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //session = new Session(login.this);
        tuser =(EditText) findViewById(R.id.inputUserLogin);
        tpass =(EditText) findViewById(R.id.inputPassLogin);
        login =(Button) findViewById(R.id.btnLogin);
        t = (TextView)findViewById(R.id.linkLogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = tuser.getText().toString();
                String pass = tpass.getText().toString();
                String Verify;
                if(user.equals("") || pass.equals("")){
                    Toast.makeText(login.this,"Username or/and Password is Empty",Toast.LENGTH_SHORT).show();
                }else{
                    //Verify = db.LoginUser(user,pass);
                   /* if(Verify.equals("true")){
                        //session.setUsername(user);
                        Intent t = new Intent(login.this,home.class);
                        startActivity(t);
                    }else{
                        Toast.makeText(login.this,"Please Create An Account ",Toast.LENGTH_SHORT).show();
                    }*/

                       Intent t = new Intent(login.this,home.class);
                       startActivity(t);

                }
            }
        });
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent t = new Intent(login.this,register.class);
                startActivity(t);
            }
        });
    }
}
