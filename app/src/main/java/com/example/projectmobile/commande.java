package com.example.projectmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class commande extends AppCompatActivity {
    EditText tn,tp,tc,tr;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commande);
        tn = (EditText)findViewById(R.id.txtlname);
        tp = (EditText)findViewById(R.id.txtfname);
        tc = (EditText)findViewById(R.id.txtcin);
        tr = (EditText)findViewById(R.id.txtfname4);
        btn = (Button) findViewById(R.id.btncomV);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tn.getText().toString().equals("") || tp.getText().toString().equals("") || tc.getText().toString().equals("") || tr.getText().toString().equals("") ){
                    Toast.makeText(commande.this, "Input is empty !! ", Toast.LENGTH_SHORT).show();
                }else{
                    try{
                        Integer a  = Integer.parseInt(tr.getText().toString());
                        Toast.makeText(commande.this, "Your Command Saved ", Toast.LENGTH_SHORT).show();
                        tn.setText("");
                        tp.setText("");
                        tc.setText("");
                        tr.setText("");
                    }catch(Exception e){
                        Toast.makeText(commande.this, "Enter Number in Input RIB ", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}

