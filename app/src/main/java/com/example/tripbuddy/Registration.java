package com.example.tripbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.jar.Attributes;

public class Registration extends AppCompatActivity {
Button registration;
EditText name;
EditText mail;
EditText password;
EditText phone;
TextView regist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registration);
        registration = findViewById(R.id.register);
        name= findViewById(R.id.Name);
        mail = findViewById(R.id.RegMail);
        phone = findViewById(R.id.phone);
        password = findViewById(R.id.RegPassword);
        regist = findViewById(R.id.reg);


        registration.setOnClickListener(v -> {

            String userName = name.getText().toString();
            String userMail = mail.getText().toString();
            String userPhone = phone.getText().toString();
            String userPassword = password.getText().toString();

            if (userName.isEmpty()){
                name.setError("Try again");
                Toast.makeText(Registration.this, "Please enter your name", Toast.LENGTH_SHORT).show();
            }else if (userMail.isEmpty()) {
                mail.setError("Try again");
                Toast.makeText(Registration.this, "Please enter your email", Toast.LENGTH_SHORT).show();
            }else if (userPhone.isEmpty()) {
                phone.setError("Try again");
                Toast.makeText(Registration.this, "Please enter your phone number", Toast.LENGTH_SHORT).show();
            }else if (userPassword.isEmpty()) {
                password.setError("Try again");
                Toast.makeText(Registration.this, "Please create a password", Toast.LENGTH_SHORT).show();
            }else{
                int phoneNum = Integer.parseInt(userPhone);

                Toast.makeText(Registration.this,"Registration Successful!", Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(Registration.this, Home.class);
                startActivity(intent);
            }

        });

    }

}