package com.example.hospital;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import de.hdodenhof.circleimageview.CircleImageView;

public class myAdapter2 extends FirebaseRecyclerAdapter<model2,myAdapter2.myviewholder> {


    public myAdapter2(@NonNull FirebaseRecyclerOptions<model2> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull model2 model2) {

        holder.doctor_name.setText(model2.getDoctor_name());
        holder.specialist.setText(model2.getSpecialist());
        holder.degree.setText(model2.getDegree());
        Glide.with(holder.img.getContext()).load(model2.getPicture_url()).into(holder.img);

        //Ex
        holder.doctor_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(holder.doctor_name.getContext(),DoctorDetails.class);
                intent.putExtra("D_name",model2.getDoctor_name());
                intent.putExtra("D_speciality",model2.getSpecialist());
                intent.putExtra("D_degree",model2.getDegree());
                intent.putExtra("D_p_url",model2.getPicture_url());
                intent.putExtra("D_address1",model2.getAddress1());
                intent.putExtra("D_address2",model2.getAddress2());
                intent.putExtra("D_visiting_time1",model2.getVisiting_time1());
                intent.putExtra("D_visiting_time2",model2.getVisiting_time2());
                intent.putExtra("phone1",""+model2.getPhone1());
                intent.putExtra("phone2",""+model2.getPhone2());
                intent.putExtra("D_p_url",model2.getPicture_url());

                intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK);
                holder.doctor_name.getContext().startActivity(intent);

            }
        });


    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerowdesign2,parent,false);
        return new myviewholder(view);
    }

    public class myviewholder extends RecyclerView.ViewHolder {

        TextView doctor_name,specialist,degree;
        CircleImageView img;


        public myviewholder(@NonNull View itemView) {
            super(itemView);

            doctor_name=itemView.findViewById(R.id.doctor_name);
            specialist=itemView.findViewById(R.id.specialist);
            degree=itemView.findViewById(R.id.degree);
            img=(CircleImageView) itemView.findViewById(R.id.doc_img);

        }
    }
}
