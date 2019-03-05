package com.example.admin.laptopshopapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static java.lang.String.format;

public class Account_Info extends AppCompatActivity {

    TextView Text1,Text2,Text3,Text4,Text5,Text6;
    Button backButton;
    Database db = new Database(this);

    int activeUserId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        initComponents();

    }

    public void initComponents(){

        activeUserId = getIntent().getIntExtra("activeid", -1);
        User activeUser = db.getUserById(activeUserId);


        backButton = (Button)findViewById(R.id.backtoSignIn);
        Text1 = (TextView) findViewById(R.id.text1);
        Text2 = (TextView)findViewById(R.id.text2);
        Text3 = (TextView)findViewById(R.id.text3);
        Text4 = (TextView)findViewById(R.id.text4);
        Text5 = (TextView)findViewById(R.id.text5);
        Text6 = (TextView)findViewById(R.id.text6);


        Text1.setText(String.format("Vaše ime: " +activeUser.getName()));
        Text2.setText(String.format("Vaše prezime: " +activeUser.getSurname()));
        Text3.setText(String.format("Vaš username: " +activeUser.getUsername()));
        Text4.setText(String.format("Vaš password: " +activeUser.getPassword()));
        Text5.setText(String.format("Vaš datum rođenja: " +activeUser.getBirth()));
        Text6.setText(String.format("Vaš e-mail: " +activeUser.getEmail()));



        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Account_Info.this,UserPage.class);
                startActivity(myIntent);
            }
        });
    }
}
