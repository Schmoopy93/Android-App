package com.example.admin.laptopshopapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONObject;

public class singleComp extends AppCompatActivity {

    TextView naziv, brand, cena;
    ImageView computerSlike;
    Button addcart,buttonBack;

    int cid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_comp);

        naziv = (TextView) findViewById(R.id.naziv);
        brand = (TextView) findViewById(R.id.brand);
        computerSlike = (ImageView) findViewById(R.id.computerSlika);
        cena = (TextView) findViewById(R.id.cena);
        addcart =(Button)findViewById(R.id.addcart);
        buttonBack =(Button) findViewById(R.id.buttonBack);


        int id = getIntent().getIntExtra("compID",0);

        initComponents(id);
    }


    @SuppressLint("HandlerLeak")
    private void initComponents(int id){
        Api.getJSON("http://192.168.110.102:5000/computers/"+String.valueOf(id), new ReadDataHandler(){
            @Override
            public void handleMessage(Message msg) {
                String response = getJson();

                try {
                    JSONObject object = new JSONObject(response);
                    final computer c = com.example.admin.laptopshopapp.computer.parseJSON(object);

                    naziv =(TextView) findViewById(R.id.naziv);
                    brand = (TextView) findViewById(R.id.brand);
                    computerSlike  = (ImageView) findViewById(R.id.computerSlika);
                    cena = (TextView)findViewById(R.id.cena);

                    naziv.setText(c.getNaziv());
                    brand.setText(c.getBrand());
                    cena.setText("The price is : " + String.valueOf(c.getCena() + "$"));

                    cid = c.getId();

                    switch (c.getTip()) {
                        case "Laptop":
                            computerSlike.setImageResource(R.drawable.laptop);
                            break;
                        case "Desktop":
                            computerSlike.setImageResource(R.drawable.desktop);
                            break;
                        case "Tablet":
                            computerSlike.setImageResource(R.drawable.tablet);
                            break;
                    }


                } catch (Exception e) {
                    ((TextView)findViewById(R.id.naziv)).setText(response);
                }
                //((TextView)findViewById(R.id.labelJson)).setText(odgovor);

            }

        }); Api.getJSON("http://192.168.0.12:5000/computers/"+String.valueOf(id), new ReadDataHandler(){
            @Override
            public void handleMessage(Message msg) {
                String response = getJson();

                try {
                    JSONObject object = new JSONObject(response);
                    final computer c = com.example.admin.laptopshopapp.computer.parseJSON(object);

                    naziv =(TextView) findViewById(R.id.naziv);
                    brand = (TextView) findViewById(R.id.brand);
                    computerSlike  = (ImageView) findViewById(R.id.computerSlika);
                    cena = (TextView)findViewById(R.id.cena);

                    naziv.setText(c.getNaziv());
                    brand.setText(c.getBrand());
                    cena.setText("The price is : " + String.valueOf(c.getCena() + "$"));

                    cid = c.getId();

                    switch (c.getTip()) {
                        case "Laptop":
                            computerSlike.setImageResource(R.drawable.laptop);
                            break;
                        case "Desktop":
                            computerSlike.setImageResource(R.drawable.desktop);
                            break;
                        case "Tablet":
                            computerSlike.setImageResource(R.drawable.tablet);
                            break;
                    }


                } catch (Exception e) {
                    ((TextView)findViewById(R.id.naziv)).setText(response);
                }
                //((TextView)findViewById(R.id.labelJson)).setText(odgovor);

            }

        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // Start NewActivity.class
                Intent myIntent = new Intent(singleComp.this,
                        Computers.class);
                startActivity(myIntent);
            }
        });

        addcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(singleComp.this,Buy.class);
                Bundle b = new Bundle();
                b.putInt("id", cid);
                myIntent.putExtras(b);

                startActivity(myIntent);
            }
        });



    }




}
