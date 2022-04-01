package com.example.hospital;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class SignIn extends AppCompatActivity {

    Button signIn,forgetPass;
    TextView backToSignUp,number,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        signIn=findViewById(R.id.signInButtonId);
        forgetPass=findViewById(R.id.forgetPassButtonId);
        backToSignUp=findViewById(R.id.signUpBack);
        number=findViewById(R.id.signInNumberId);
        password=findViewById(R.id.signInPasswordId);


        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String _phone = number.getText().toString().trim();
                final String _password = password.getText().toString().trim();

                if (_phone.isEmpty()) {
                    number.setError("Enter Your Phone Number");
                    number.requestFocus();
                    return;
                }
                if (_password.isEmpty()) {
                    password.setError("Enter a password");
                    password.requestFocus();
                    return;
                }

                DatabaseReference reference= FirebaseDatabase.getInstance().getReference("BloodBank_users");
                Query checkUser=reference.orderByChild("phone").equalTo(_phone);

                checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()) {
                            number.setError(null);
                            number.setEnabled(true);

                            String passwordFromDB = snapshot.child(_phone).child("password").getValue(String.class);

                            if (passwordFromDB.equals(_password)) {

                                password.setError(null);
                                password.setEnabled(true);

                                //String phoneFromDB = snapshot.child(phone).child("phoneNo").getValue(String.class);
                                //String nameFromDB = snapshot.child(phone).child("name").getValue(String.class);
                                //String genderFromDB = snapshot.child(phone).child("gender").getValue(String.class);
                                //String bloodGroupFromDB = snapshot.child(phone).child("bloodGroup").getValue(String.class);

                                Intent intent = new Intent(getApplicationContext(),BloodBank.class);
                                startActivity(intent);
                            } else {
                                password.setError("Wrong Password Or User Name");
                                password.requestFocus();
                            }

                        }
                        else {
                            number.setError("This Number Is Not Registered");
                            number.requestFocus();
                        }
                    }


                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });


            }
        });



        backToSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(SignIn.this,SignUp.class);
                startActivity(intent);
            }
        });


    }
}