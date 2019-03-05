package com.example.admin.laptopshopapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.Date;

public class RegisterActivity extends AppCompatActivity {


    EditText inputName,inputSurname, inputUsername, inputPassword, inputBirth,inputEmail;
    Button buttonConfirm, clearform;
    ArrayList<String> users = new ArrayList<String>();
    Database db = new Database(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        inputName = (EditText) findViewById(R.id.inputName);
        inputSurname = (EditText) findViewById(R.id.inputSurname);
        inputUsername = (EditText) findViewById(R.id.inputUsernameR);
        inputPassword = (EditText) findViewById(R.id.inputPasswordR);
        inputBirth = (EditText) findViewById(R.id.inputBirth);
        inputEmail = (EditText) findViewById(R.id.inputEmail);
        buttonConfirm = (Button)findViewById(R.id.buttonConfirm);
        clearform = (Button)findViewById(R.id.clearForm);




        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = inputName.getText().toString();
                String surname = inputSurname.getText().toString();
                String username = inputUsername.getText().toString();
                String password = inputPassword.getText().toString();
                String birth = inputBirth.getText().toString();
                String email = inputEmail.getText().toString();

                db.addUser(name, surname, username, password, birth, email);

                User activeUser = db.getUserByUsername(username);
//                if(activeUser!=null) {
//                    if (TextUtils.isEmpty(inputName.getText())) {
//                        inputName.setError("The text field is required !");
//                    } else {
//                        Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
//                        startActivity(i);
//                    }
//                    if (TextUtils.isEmpty(inputSurname.getText())) {
//                        inputSurname.setError("The text field is required !");
//                    } else {
//                        Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
//                        startActivity(i);
//                    }
//                    if (TextUtils.isEmpty(inputSurname.getText())) {
//                        inputSurname.setError("The text field is required !");
//                    } else {
//                        Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
//                        startActivity(i);
//                    }
//                    if (TextUtils.isEmpty(inputUsername.getText())) {
//                        inputUsername.setError("The text field is required !");
//                    } else {
//                        Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
//                        startActivity(i);
//                    }
//                    if (TextUtils.isEmpty(inputPassword.getText())) {
//                        inputPassword.setError("The text field is required !");
//                    } else {
//                        Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
//                        startActivity(i);
//                    }
//                    if (TextUtils.isEmpty(inputBirth.getText())) {
//                        inputBirth.setError("The text field is required !");
//                    } else {
//                        Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
//                        startActivity(i);
//                    }
//                    if (TextUtils.isEmpty(inputEmail.getText())) {
//                        inputEmail.setError("The text field is required !");
//                    } else {
//                        Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
//                        startActivity(i);
//                    }
//                }

                Intent intent = new Intent(RegisterActivity.this, Confirmed_register.class);
                intent.putExtra("activeid", activeUser.getUserID());
                startActivity(intent);
            }

        });
        clearform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputName.setText("");
                inputSurname.setText("");
                inputUsername.setText("");
                inputPassword.setText("");
                inputBirth.setText("");
                inputEmail.setText("");

            }
        });


    }
}