package com.example.admin.laptopshopapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class titlePage extends AppCompatActivity {

    TextView enter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_stranica);

        enter = (TextView) findViewById(R.id.enter);

        initComponents();
    }

    private void initComponents(){
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signIn = new Intent(titlePage.this, SignIn.class );
                startActivity(signIn);
            }
        });
    }
}
