package com.example.hospital;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class BloodBank extends AppCompatActivity {

    private FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_bank);

        mFirebaseAuth=FirebaseAuth.getInstance();

    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser mFirebaseUser=mFirebaseAuth.getCurrentUser();
        if (mFirebaseUser!=null){
            startActivity(new Intent(BloodBank.this,BloodBankMain.class));
            finish();
        }
        else {
            startActivity(new Intent(BloodBank.this,SignIn.class));
            finish();
        }
    }
}