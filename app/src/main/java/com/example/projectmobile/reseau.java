package com.example.projectmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.ListView;
import android.widget.TextView;

public class reseau extends AppCompatActivity {
    TextView f,l,y;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reseau);
        f = (TextView)findViewById(R.id.linkfb);
        l = (TextView)findViewById(R.id.linklinke);
        y = (TextView)findViewById(R.id.linkyoutube);
        f.setMovementMethod(LinkMovementMethod.getInstance());
        l.setMovementMethod(LinkMovementMethod.getInstance());
        y.setMovementMethod(LinkMovementMethod.getInstance());
    }
}

