package com.example.admin.laptopshopapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONObject;

import java.util.ArrayList;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class Confirmed_Order extends AppCompatActivity {

    TextView label1, label2, label3;
    Button home;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_confirmation_order);

        initComponents();

    }

    public void initComponents() {

        int cid = getIntent().getIntExtra("id", 0);

        final String Text1 = getIntent().getStringExtra("name");
        final String Text2 = getIntent().getStringExtra("surname");
        final String Text3 = getIntent().getStringExtra("еmail");
        final String Text4 = getIntent().getStringExtra("adress");
        final String Text6 = getIntent().getStringExtra("payment");



        label1 = (TextView) findViewById(R.id.Text1);
        label2 = (TextView) findViewById(R.id.Text2);
        label3 = (TextView) findViewById(R.id.Text3);
        home =(Button)findViewById(R.id.back_menu);



        label1.setText("Računar je kupljen od strane korisnika \n" + Text1 +" "+ Text2);
        label2.setText("Pošiljka se šalje na adresu: \n" + Text4 + " .");
        label3.setText("Korisnik je izvršio transakciju preko " + Text6 + " platne kartice."+"\nSve detalje oko isporuke možete pronaći na: " + Text3 + "\nHvala Vam na ukazanom poverenju! \nVaš Computer Shop ! :) ");

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Confirmed_Order.this,UserPage.class);
                startActivity(i);
            }
        });


    }




}