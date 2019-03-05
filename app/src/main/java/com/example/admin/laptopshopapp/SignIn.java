package com.example.admin.laptopshopapp;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

public class SignIn extends AppCompatActivity {

    EditText inputusername, inputpassword,name,email;
    Button signIn,register;
    Database db = new Database(this);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        inputusername = (EditText) findViewById(R.id.username);
        inputpassword = (EditText) findViewById(R.id.password);
        name = (EditText)findViewById(R.id.name);
        email = (EditText)findViewById(R.id.email);
        signIn = (Button) findViewById(R.id.signIn);
        register = (Button)findViewById(R.id.register);


        initComponents();
    }

    private void initComponents( ){

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = inputusername.getText().toString();
                String password = inputpassword.getText().toString();
                User user = db.getUserByUsername(username);

                if(user!=null)
                {
                    if(password.equals(user.getPassword()))
                    {
                        Intent intent = new Intent(SignIn.this, UserPage.class);
                        intent.putExtra("activeid", user.getUserID());
                        startActivity(intent);
                    }else
                        Toast.makeText(SignIn.this, "Invalid Password", Toast.LENGTH_LONG).show();



                }else
                    Toast.makeText(SignIn.this, "Invalid Username", Toast.LENGTH_LONG).show();



            }
        });

//        signIn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(API_User.checkLogIn(username.getText().toString(), password.getText().toString())){
//                    Intent mainMenu = new Intent(SignIn.this, UserPage.class);
//                    SignIn.this.startActivity(mainMenu);
//                }else{
//                    Toast.makeText(getApplicationContext(),"Incorrect Username or Password",Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(SignIn.this,RegisterActivity.class);
                Bundle b = new Bundle();
                myIntent.putExtras(b);

                startActivity(myIntent);
            }
        });



    }

}

