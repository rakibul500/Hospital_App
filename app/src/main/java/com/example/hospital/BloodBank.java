package com.example.hospital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class BloodBank extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_bank);

        SharedPreferences prefs = getSharedPreferences("name", MODE_PRIVATE);
        boolean isLoggedIn= prefs.getBoolean("isLoggedIn", false);

        if(isLoggedIn){
            startActivity(new Intent(getApplicationContext(),BloodBankMain.class));
                    finish();
                    return;
        }
        else{
            startActivity(new Intent(getApplicationContext(),BloodBankMain.class));
            finish();
            return;
        }

    }
}

