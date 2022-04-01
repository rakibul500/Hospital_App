package com.example.hospital;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class Hospital1 extends AppCompatActivity {

    RecyclerView recyclerView1;
    myAdapter1 adapter1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital1);

        recyclerView1=findViewById(R.id.recylerView1);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<model1> options =
                new FirebaseRecyclerOptions.Builder<model1>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Hospital_list"), model1.class)
                        .build();

        adapter1=new myAdapter1(options, Hospital1.this);
        recyclerView1.setAdapter(adapter1);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter1.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter1.stopListening();
    }

    @Override

    //For Search Option
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.searchmenu1,menu);
        MenuItem item=menu.findItem(R.id.search1);
        SearchView searchView=(SearchView)item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
               processSearch(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                processSearch(s);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    private void processSearch(String s)

    {
        FirebaseRecyclerOptions<model1> options =
                new FirebaseRecyclerOptions.Builder<model1>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Hospital_list").orderByChild("h_name").startAt(s).endAt(s+"\uf8ff"), model1.class)
                        .build();

        adapter1=new myAdapter1(options, Hospital1.this);
        adapter1.startListening();
        recyclerView1.setAdapter(adapter1);
    }
}