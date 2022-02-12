package com.example.hospital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DoctorDetails extends AppCompatActivity {

    TextView doctor_name,doctor_speciality,doctor_degree,doctor_address1,doctor_address2,visiting1,visiting2,phone1,phone2;
    ImageView doctor_image;
    Button visiting_call1,visiting_call2;
    String str_phone1,str_phone2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        doctor_name=(TextView)findViewById(R.id.doctor_name);
        doctor_speciality=(TextView) findViewById(R.id.doctor_speciality);
        doctor_degree=(TextView) findViewById(R.id.doctor_degree);
        doctor_address1=(TextView)findViewById(R.id.visiting_address1);
        doctor_address2=(TextView)findViewById(R.id.visiting_address2);
        visiting1=(TextView)findViewById(R.id.visiting_time1);
        visiting2=(TextView)findViewById(R.id.visiting_time2);
        phone1=(TextView)findViewById(R.id.visiting_phone1);
        phone2=(TextView)findViewById(R.id.visiting_phone2);
        doctor_image=(ImageView)findViewById(R.id.doctor_image);
        visiting_call1=(Button)findViewById(R.id.visiting_call1);
        visiting_call2=(Button)findViewById(R.id.visiting_call2);


        str_phone1 = getIntent().getStringExtra("phone1");
        str_phone2 = getIntent().getStringExtra("phone2");



        //Set PutExtra Value from myadapter3 to target filed
        doctor_name.setText(getIntent().getStringExtra("D_name").toString());
        doctor_speciality.setText(getIntent().getStringExtra("D_speciality").toString());
        doctor_degree.setText(getIntent().getStringExtra("D_degree").toString());
        doctor_address1.setText(getIntent().getStringExtra("D_address1").toString());
        doctor_address2.setText(getIntent().getStringExtra("D_address2").toString());
        visiting1.setText(getIntent().getStringExtra("D_visiting_time1").toString());
        visiting2.setText(getIntent().getStringExtra("D_visiting_time2").toString());
        phone1.setText(str_phone1);
        phone2.setText(str_phone2);

        String url=getIntent().getStringExtra("D_p_url");
        Glide.with(getApplicationContext()).load(url).into(doctor_image);



        visiting_call1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                String phonee = "tel:"+str_phone1;
                intent.setData(Uri.parse(phonee));
                startActivity(intent);
            }


        });

        visiting_call2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                String phonee = "tel:"+str_phone2;
                intent.setData(Uri.parse(phonee));
                startActivity(intent);
            }


        });




    }
}