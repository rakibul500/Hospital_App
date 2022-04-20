package com.example.hospital;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class BloodBankMain extends AppCompatActivity {

    RecyclerView recyclerView4;
    myAdapter4 adapter4;
    private Spinner spinnerBlood,spinnerDivision,spinnerDistrict,spinnerUpozila;
    private String selectedDivision,selectedDistrict,selectedUpozila,selectedBlood;
    String[] bloodGroup;

    FirebaseAuth firebaseAuth;
    FirebaseUser user;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_bank_main);

        firebaseAuth=FirebaseAuth.getInstance();
        user=firebaseAuth.getCurrentUser();


        //For Blood Spinner
        spinnerBlood = (Spinner) findViewById(R.id.filterBloodSpinner);
        bloodGroup = getResources().getStringArray(R.array.blood_group);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, R.layout.sample_view, R.id.spinner1_view, bloodGroup);
        spinnerBlood.setAdapter(adapter1);
        spinnerBlood.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedBlood=spinnerBlood.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //Close



        recyclerView4=findViewById(R.id.recylerView4);
        recyclerView4.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<model4> options =
                new FirebaseRecyclerOptions.Builder<model4>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("BloodBank_users"), model4.class)
                        .build();

        adapter4=new myAdapter4(options,BloodBankMain.this);
        recyclerView4.setAdapter(adapter4);
    }


    @Override
    protected void onStart() {
        super.onStart();
        adapter4.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter4.stopListening();
    }

    public void btnToProfile(View view) {
        SharedPreferences.Editor editor = getSharedPreferences("name", MODE_PRIVATE).edit();
        editor.putString("phone", "");
        editor.putBoolean("isLoggedIn", false);
        editor.apply();

        Intent intent = new Intent(getApplicationContext(), Home.class);
        intent.putExtra("finish", true);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }
}