package com.example.projectmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.AdapterView.*;

public class change extends AppCompatActivity {
    private static int nomber=1;
    Button btn;
    Spinner spDe,spEn;
    EditText tx;
    TextView affich;
    int posSpDe,posSpEn ;
    String showMsg="Selected an Items";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change);
        btn = (Button)findViewById(R.id.btnConvertir);
        spDe = (Spinner)findViewById(R.id.spDe);
        spEn = (Spinner)findViewById(R.id.spEn);
        tx = (EditText)findViewById(R.id.txtnomberchange);
        affich = (TextView)findViewById(R.id.txtAfficherMontant);

        //remplire spinner De
        final String[] DeC = new String[]{"MAD","CAD","EUR","GBP","USD"};
        ArrayAdapter<String> sp1 = new ArrayAdapter<String>(
                this,
                R.layout.support_simple_spinner_dropdown_item,
                DeC
        );
        spDe.setAdapter(sp1);
        //remplire spinner En
        final String[] EnC = new String[]{"MAD","CAD","EUR","GBP","USD"};
        ArrayAdapter<String> sp2 = new ArrayAdapter<String>(
                this,
                R.layout.support_simple_spinner_dropdown_item,
                EnC
        );
        spEn.setAdapter(sp2);
        //avent on click Button Convert
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tx.getText().toString().equals("")){
                    Toast.makeText(change.this,"Input Nomber is empty !!",Toast.LENGTH_SHORT).show();
                }else{
                    posSpDe = (int) spDe.getSelectedItemId();
                    posSpEn = (int) spEn.getSelectedItemId();

                    switch (posSpDe){
                        case 0 : switch (posSpEn){
                            case 0 : showMsg = "choose another currency in the second Drop-Down Menu ";
                                break;
                            case 1 : showMsg = String.valueOf(String.format("%.3f", 0.14 * Integer.parseInt(tx.getText().toString())))+" CAD";
                                break;
                            case 2 : showMsg = String.valueOf( String.format("%.3f",0.092 * Integer.parseInt(tx.getText().toString())))+" EUR";
                                break;
                            case 3 : showMsg = String.valueOf(String.format("%.3f", 0.083 * Integer.parseInt(tx.getText().toString())))+" GBP";
                                break;
                            default: showMsg = String.valueOf(String.format("%.3f", 0.10 * Integer.parseInt(tx.getText().toString())))+" USD";
                                break;
                        }
                            break;
                        case 1 : switch (posSpEn){
                            case 0 : showMsg = String.valueOf(String.format("%.3f", 6.595 * Integer.parseInt(tx.getText().toString())))+" MAD";
                                break;
                            case 1 : showMsg = "choose another currency in the second Drop-Down Menu ";
                                break;
                            case 2 : showMsg = String.valueOf(String.format("%.3f", 0.66 * Integer.parseInt(tx.getText().toString())))+" EUR";
                                break;
                            case 3 : showMsg = String.valueOf(String.format("%.3f", 0.59 * Integer.parseInt(tx.getText().toString())))+" GBP";
                                break;
                            default: showMsg = String.valueOf(String.format("%.3f", 0.74 * Integer.parseInt(tx.getText().toString())))+" USD";
                                break;
                        }
                            break;
                        case 2 : switch (posSpEn){
                            case 0 : showMsg = String.valueOf(String.format("%.3f", 11.043 * Integer.parseInt(tx.getText().toString())))+" MAD";
                                break;
                            case 1 : showMsg = String.valueOf(String.format("%.3f", 1.53 * Integer.parseInt(tx.getText().toString())))+" CAD";
                                break;
                            case 2 : showMsg = "choose another currency in the second Drop-Down Menu ";
                                break;
                            case 3 : showMsg = String.valueOf(String.format("%.3f", 0.90 * Integer.parseInt(tx.getText().toString())))+" GBP";
                                break;
                            default: showMsg = String.valueOf(String.format("%.3f", 1.12 * Integer.parseInt(tx.getText().toString())))+" USD";
                                break;
                        }
                            break;
                        case 3 : switch (posSpEn){
                            case 0 : showMsg = String.valueOf(String.format("%.3f", 11.615 * Integer.parseInt(tx.getText().toString())))+" MAD";
                                break;
                            case 1 : showMsg = String.valueOf(String.format("%.3f", 1.70 * Integer.parseInt(tx.getText().toString())))+" CAD";
                                break;
                            case 2 : showMsg = String.valueOf(String.format("%.3f", 1.11 * Integer.parseInt(tx.getText().toString())))+" EUR";
                                break;
                            case 3 : showMsg = "choose another currency in the second Drop-Down Menu ";
                                break;
                            default: showMsg = String.valueOf(String.format("%.3f", 1.25 * Integer.parseInt(tx.getText().toString())))+" USD";
                                break;
                        }
                            break;
                        case 4 : switch (posSpEn){
                            case 0 : showMsg = String.valueOf(String.format("%.3f", 9.692 * Integer.parseInt(tx.getText().toString())))+" MAD";
                                break;
                            case 1 : showMsg = String.valueOf(String.format("%.3f", 1.36 * Integer.parseInt(tx.getText().toString())))+" CAD";
                                break;
                            case 2 : showMsg = String.valueOf(String.format("%.3f", 0.89 * Integer.parseInt(tx.getText().toString())))+" EUR";
                                break;
                            case 3 : showMsg = String.valueOf(String.format("%.3f", 0.80 * Integer.parseInt(tx.getText().toString())))+" GBP";
                                break;
                            default: showMsg = "choose another currency in the second Drop-Down Menu ";
                                break;
                        }
                            break;

                    }

                    //test input Nomber is numeric
                    try{
                        nomber = Integer.parseInt(tx.getText().toString());

                        affich.setTextColor(Color.BLACK);
                        affich.setTextSize(24);
                        affich.setText(showMsg);
                    }catch (Exception e){
                        Toast.makeText(change.this,"Nomber is not Numeric !! ",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });




    }
}

