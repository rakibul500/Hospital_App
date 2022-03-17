package com.example.hospital;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;


public class HospitalDetails extends AppCompatActivity {
    TextView name,add,ambu,phn,map;
    ImageView h_pic;
    Button call_btn;
    String phn_value,hos_name;
    String ambu_value;
    double longi;
    double lati;

    boolean isPermissionGranted;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_details);

        name = findViewById(R.id.hos_detail_name);
        add = findViewById(R.id.hos_detail_address);
        ambu = findViewById(R.id.hos_detail_ambulance);
        phn = findViewById(R.id.hos_detail_phone);
        h_pic = findViewById(R.id.hos_image);
        call_btn = findViewById(R.id.hos_call);
        map=findViewById(R.id.map_add);


        add.setText(getIntent().getStringExtra("H_location"));
        map.setText(getIntent().getStringExtra("H_location"));


        phn_value = getIntent().getStringExtra("H_phone");
        ambu_value = getIntent().getStringExtra("H_ambulance");

        Intent receiveIntent=this.getIntent();
        hos_name=getIntent().getStringExtra("H_name");
        longi= receiveIntent.getDoubleExtra("Longitude",0.0000000000000000000);
        lati=receiveIntent.getDoubleExtra("Latitude",0.0000000000000000000);

        name.setText(hos_name);
        ambu.setText(ambu_value);
        phn.setText(phn_value);

        String picurl = getIntent().getStringExtra("H_pic");
        Glide.with(getApplicationContext()).load(picurl).into(h_pic);

        call_btn.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            String phonee = "tel:" + ambu_value;
            intent.setData(Uri.parse(phonee));
            startActivity(intent);
        });

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HospitalDetails.this,MapsActivity.class);
                intent.putExtra("Longitude",longi);
                intent.putExtra("Latitude",lati);
                intent.putExtra("Hos_name",hos_name);
                startActivity(intent);
            }
        });

    }
}
