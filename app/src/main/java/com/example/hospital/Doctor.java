package com.example.hospital;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SearchView;
import android.widget.Spinner;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Doctor extends AppCompatActivity {

    RecyclerView recyclerView2;
    myAdapter2 adapter2;
    private Object AdapterView;
    Spinner catSpinner;
    String[] docCategory;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);

        recyclerView2=findViewById(R.id.recylerView2);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));

        //For Blood Spinner
        catSpinner = (Spinner) findViewById(R.id.categorySpinner);
        docCategory = getResources().getStringArray(R.array.doctor_category);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, R.layout.sample_view, R.id.spinner1_view, docCategory);
        catSpinner.setAdapter(adapter1);

       catSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(android.widget.AdapterView<?> parent, View view, int position, long id) {
               Query query = null;
               if (position == 0 ){
                   query = FirebaseDatabase.getInstance().getReference().child("Doctor_list");
               }
               else if (position == 1) {
                   query = FirebaseDatabase.getInstance().getReference().child("Doctor_list").orderByChild("specialist").equalTo("Medicine");
               }
               else if (position == 2) {
                   query = FirebaseDatabase.getInstance().getReference().child("Doctor_list").orderByChild("specialist").equalTo("Psychology");
               }
               else if (position == 3) {
                   query = FirebaseDatabase.getInstance().getReference().child("Doctor_list").orderByChild("specialist").equalTo("Orthopedic");
               }
               FirebaseRecyclerOptions<model2> newOptions = new FirebaseRecyclerOptions.Builder<model2>()
                       .setQuery(query, model2.class)
                       .build();
               adapter2.updateOptions(newOptions);
           }

           @Override
           public void onNothingSelected(android.widget.AdapterView<?> parent) {

           }
       });

        FirebaseRecyclerOptions<model2> options =
                new FirebaseRecyclerOptions.Builder<model2>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Doctor_list"), model2.class)
                        .build();
        adapter2=new myAdapter2(options);
        recyclerView2.setAdapter(adapter2);

    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter2.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter2.stopListening();
    }

}