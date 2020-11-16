package com.example.projectmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class register extends AppCompatActivity {
   // private Session session ;
   // DB_sqlite db = new DB_sqlite(register.this);
    TextView t;
    EditText user,pass1,pass2;
    Button valide;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        user = (EditText)findViewById(R.id.inputUserSingup);
        pass1 = (EditText)findViewById(R.id.inputPassSingup);
        pass2 = (EditText)findViewById(R.id.inputPassConfiSingup);
        valide = (Button) findViewById(R.id.btnLogin);
        t = (TextView)findViewById(R.id.linkSingup);
        //session = new Session(this);

        valide.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                String ps1 = pass1.getText().toString();
                String ps2 = pass2.getText().toString();
                String userN = user.getText().toString();
                if(userN.equals("") || ps1.equals("") || ps2.equals("")){
                    Toast.makeText(register.this,"Username or/and Password or/and Password Conf is Empty",Toast.LENGTH_SHORT).show();
                }else {
                    if(ps1.equals(ps2)){
                        //String b = db.InsertUser(userN,ps1);
                        Intent t = new Intent(register.this,login.class);
                        startActivity(t);
                       /* if(b.equals("true")){
                            session.setUsername(userN);
                            Intent t = new Intent(register.this,login.class);
                            startActivity(t);
                        }else if(b.equals("false")){
                            Toast.makeText(register.this,"field registration ",Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(register.this,"Account Exists ",Toast.LENGTH_SHORT).show();
                        }*/
                    }else{
                        Toast.makeText(register.this,"Password Is not Matching",Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent t = new Intent(register.this,login.class);
                startActivity(t);
            }
        });
    }
}
