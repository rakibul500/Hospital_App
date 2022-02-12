package com.example.hospital;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Home extends AppCompatActivity implements View.OnClickListener{

    ImageSlider main_slider;
    CardView button1,button2,button3,button4,button5,button6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home);

        //button hooks
        button1=findViewById(R.id.buttonId1);
        button2=findViewById(R.id.buttonId2);
        button3=findViewById(R.id.buttonId3);
        button4=findViewById(R.id.buttonId4);
        button5=findViewById(R.id.buttonId5);
        button6=findViewById(R.id.buttonId6);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);

        //slider Hooks
        main_slider=findViewById(R.id.image_slider);

        final List<SlideModel> remote_images=new ArrayList<>();

        //CallFirebase
        FirebaseDatabase.getInstance().getReference().child("Slider")
                .addListenerForSingleValueEvent(new ValueEventListener()


                {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for(DataSnapshot data:snapshot.getChildren())
                            remote_images.add(new SlideModel(Objects.requireNonNull(data.child("url").getValue()).toString(), ScaleTypes.FIT));

                        //data.child("title").getValue().toString(),
                        // (IF need title with slider just put this line into before line after first comma)

                            main_slider.setImageList(remote_images,ScaleTypes.FIT);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
    }

    @Override
    public void onClick(View v) {
        Intent i;
        if (v.getId() == R.id.buttonId1) {
            i = new Intent(this, Hospital1.class);
            startActivity(i);
        }
        if (v.getId()==R.id.buttonId2){
            i = new Intent(this, BloodBank.class);
            startActivity(i);
        }

        if (v.getId()==R.id.buttonId3){
            i = new Intent(this, Doctor.class);
            startActivity(i);
        }

        if (v.getId()==R.id.buttonId4){
            i = new Intent(this, Ambulance.class);
            startActivity(i);
        }

    }
}