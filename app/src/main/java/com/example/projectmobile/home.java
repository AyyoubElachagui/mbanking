package com.example.projectmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Hashtable;

public class home extends AppCompatActivity {
    Session session ;
    TextView t;
    ListView ls;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        session = new Session(this);
        t = (TextView)findViewById(R.id.textHome);
        String user = session.getUsername();
        t.setText("Welcome "+user);
        ls = (ListView) findViewById(R.id.listCours);
        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i){
                    case 0 :
                        Intent cours = new Intent(home.this,cours.class);
                        startActivity(cours);
                        break;
                    case 1 :
                        Intent change = new Intent(home.this,change.class);
                        startActivity(change);
                        break;
                    case 2 :
                        Intent command = new Intent(home.this,commande.class);
                        startActivity(command);
                        break;
                    case 3 :
                        Intent reseau = new Intent(home.this,reseau.class);
                        startActivity(reseau);
                        break;
                    case 4 :
                        Intent contact = new Intent(home.this,contact.class);
                        startActivity(contact);
                        break;
                }
            }
        });

        ArrayList<Hashtable<String ,String >> menu = new ArrayList<Hashtable<String,String>>();
        Hashtable<String,String> elt;

        elt = new Hashtable<String,String>();
        elt.put("service","Cours devises");
        elt.put("icons",String.valueOf(R.drawable.a));
        menu.add(elt);

        elt = new Hashtable<String,String>();
        elt.put("service","Change devise");
        elt.put("icons",String.valueOf(R.drawable.b));
        menu.add(elt);

        elt = new Hashtable<String,String>();
        elt.put("service","Commande chéquier");
        elt.put("icons",String.valueOf(R.drawable.c));
        menu.add(elt);

        elt = new Hashtable<String,String>();
        elt.put("service","Réseau agences");
        elt.put("icons",String.valueOf(R.drawable.d));
        menu.add(elt);

        elt = new Hashtable<String,String>();
        elt.put("service","Contact");
        elt.put("icons",String.valueOf(R.drawable.e));
        menu.add(elt);

        SimpleAdapter ada = new SimpleAdapter(
                this,
                menu,
                R.layout.customlayout,
                new String []{"icons","service"},
                new int[]{R.id.imageView,R.id.textViewL}
        );
        ls.setAdapter(ada);
    }



}

