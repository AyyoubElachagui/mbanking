package com.example.projectmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Hashtable;

public class cours extends AppCompatActivity {
    Button a,v;
    ListView ls;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cours);
        a = (Button)findViewById(R.id.btnachat);
        v = (Button)findViewById(R.id.btnavente);
        ls = (ListView) findViewById(R.id.listCours);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a.setBackgroundColor(Color.GRAY);
                v.setBackgroundColor(Color.WHITE);
                listCours("6.595","11.043","11.615","9.692");
            }
        });

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a.setBackgroundColor(Color.WHITE);
                v.setBackgroundColor(Color.GRAY);
                listCours("0.150","0.906","0.086","0.103");
            }
        });


        a.setBackgroundColor(Color.GRAY);
        v.setBackgroundColor(Color.WHITE);
        listCours("6.595","11.043","11.615","9.692");
    }
    public void listCours(String cad,String eur,String gbp,String usd){
        ArrayList<Hashtable<String,String>> cours = new ArrayList<Hashtable<String,String>>();
        Hashtable<String,String> elt;

        elt = new Hashtable<String,String>();
        elt.put("coins","CAD");
        elt.put("prix",cad);
        elt.put("pays",String.valueOf(R.drawable.canada));
        cours.add(elt);

        elt = new Hashtable<String,String>();
        elt.put("coins","EUR");
        elt.put("prix",eur);
        elt.put("pays",String.valueOf(R.drawable.europe));
        cours.add(elt);

        elt = new Hashtable<String,String>();
        elt.put("coins","GBP");
        elt.put("prix",gbp);
        elt.put("pays",String.valueOf(R.drawable.gbp));
        cours.add(elt);

        elt = new Hashtable<String,String>();
        elt.put("coins","USD");
        elt.put("prix",usd);
        elt.put("pays",String.valueOf(R.drawable.usd));
        cours.add(elt);

        SimpleAdapter ada = new SimpleAdapter(
                this,
                cours,
                R.layout.resourcecours,
                new String[]{"pays","coins","prix"},
                new int[]{R.id.imagepays,R.id.textpays,R.id.textprix}
        );
        ls.setAdapter(ada);
    }
}
