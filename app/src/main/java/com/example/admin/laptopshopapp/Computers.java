package com.example.admin.laptopshopapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class Computers extends AppCompatActivity {

    ArrayList<ConstraintLayout> lista = new ArrayList<>();

    LinearLayout Samsung, Apple, HP;
    ArrayList<computer> computers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.computers);



        Samsung = (LinearLayout) findViewById(R.id.samsung);
        Apple = (LinearLayout) findViewById(R.id.apple);
        HP = (LinearLayout) findViewById(R.id.HP);

        Intent singleComp = new Intent(this, singleComp.class);

        initComponents(singleComp);
    }

    private void initComponents(final Intent singleComp){



        computers = API_Computer.getComputers();

        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Samsung = (LinearLayout) findViewById(R.id.samsung);
        Apple = (LinearLayout) findViewById(R.id.apple);
        HP = (LinearLayout) findViewById(R.id.HP);
        EditText searchBar = (EditText)findViewById(R.id.searchBar);


        for (final computer c : computers) {

            ConstraintLayout item = (ConstraintLayout) inflater.inflate(R.layout.computer_image, null);

            switch (c.getTip()) {
                case "Laptop":
                    ((ImageView) item.findViewById(R.id.computerSlika)).setImageResource(R.drawable.laptop);
                    break;
                case "Desktop":
                    ((ImageView) item.findViewById(R.id.computerSlika)).setImageResource(R.drawable.desktop);
                    break;
                case "Tablet":
                    ((ImageView) item.findViewById(R.id.computerSlika)).setImageResource(R.drawable.tablet);
                    break;
            }

            switch(c.getBrand()) {
                case "Samsung":
                    Samsung.addView(item);
                    break;
                case "Apple":
                    Apple.addView(item);
                    break;
                case "HP":
                    HP.addView(item);
                    break;
            }

            ((TextView)item.findViewById(R.id.labelName)).setText(c.getNaziv());

            item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    singleComp.putExtra("compID", c.getId());
                    startActivity(singleComp);

                }
            });

            lista.add(item);

        }

        searchBar.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {}

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                for(ConstraintLayout item: lista)
                    item.setBackgroundResource(R.drawable.ltrans);
                if(s.length() != 0)
                {
                    for (ConstraintLayout item : lista)
                    {
                        String st = ((TextView)item.findViewById(R.id.labelName)).getText().toString().toLowerCase();
                        if(st.contains(s))
                        {
                            item.setBackgroundResource(R.drawable.lback);
                        }
                    }
                }
            }
        });




    }
}
