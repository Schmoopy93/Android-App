package com.example.admin.laptopshopapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class UserPage extends AppCompatActivity {

    Button CheckProducts,AccInfo,LogOut;
    Database db = new Database(this);
    int activeUserId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_page);

        activeUserId = getIntent().getIntExtra("activeid", -1);
        User activeUser = db.getUserById(activeUserId);

        initComponents();
    }

    private void initComponents(){

        CheckProducts = (Button)findViewById(R.id.view_computers);
        LogOut =(Button)findViewById(R.id.logOut);
        AccInfo = (Button)findViewById(R.id.AccInfo);

        CheckProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent computers = new Intent(UserPage.this, Computers.class);
                startActivity(computers);
            }
        });


        LogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent LogOut = new Intent(UserPage.this, titlePage.class);
                startActivity(LogOut);
                finish();
            }
        });

//        AccInfo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent myIntent = new Intent(UserPage.this, Account_Info.class);
//                myIntent.putExtra("activeid",activeUserId );
//                startActivity(myIntent);
//            }
//        });



    }
}
