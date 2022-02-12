package com.example.hospital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class HospitalDetails extends AppCompatActivity {
    TextView name,add,ambu,phn;
    ImageView h_pic;
    Button call_btn;
    String phn_value,ambu_value;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_details);

        name=(TextView) findViewById(R.id.hos_detail_name);
        add=(TextView) findViewById(R.id.hos_detail_address);
        ambu=(TextView) findViewById(R.id.hos_detail_ambulance);
        phn=(TextView) findViewById(R.id.hos_detail_phone);
        h_pic=(ImageView) findViewById(R.id.hos_image);
        call_btn=(Button)findViewById(R.id.hos_call);



        name.setText(getIntent().getStringExtra("H_name").toString());
        add.setText(getIntent().getStringExtra("H_location").toString());

        phn_value=getIntent().getStringExtra("H_phone");
        ambu_value=getIntent().getStringExtra("H_ambulance");
        ambu.setText(ambu_value);
        phn.setText(phn_value);

        String picurl=getIntent().getStringExtra("H_pic");
        Glide.with(getApplicationContext()).load(picurl).into(h_pic);

        call_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                String phonee = "tel:"+ambu_value;
                intent.setData(Uri.parse(phonee));
                startActivity(intent);
            }
        });



    }
}