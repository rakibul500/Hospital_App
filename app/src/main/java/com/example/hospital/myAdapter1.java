package com.example.hospital;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class myAdapter1 extends FirebaseRecyclerAdapter<model1,myAdapter1.myviewholder1> {
    private Context context;

    public myAdapter1(@NonNull FirebaseRecyclerOptions<model1> options, Context context) {
        super(options);
        this.context = context;
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder1 holder, int position, @NonNull model1 model1) {

        holder.name_text.setText(model1.getH_name());
        holder.address_text.setText(model1.getH_location());
        holder.phone_text.setText(""+model1.getH_phone());
        Glide.with(holder.hos_pic.getContext()).load(model1.getPic_url()).into(holder.hos_pic);

        holder.name_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(holder.name_text.getContext(),HospitalDetails.class);

                intent.putExtra("H_name",model1.getH_name());
                intent.putExtra("H_location",model1.getH_location());
                intent.putExtra("H_phone",""+model1.getH_phone());
                intent.putExtra("H_ambulance",""+model1.getH_ambulance());
                intent.putExtra("H_pic",model1.getPic_url());
                intent.putExtra("Longitude",model1.getLongi());
                intent.putExtra("Latitude",model1.getLati());

                intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK);
                holder.name_text.getContext().startActivity(intent);
            }
        });

        holder.call_button1.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            String phonee = "tel:"+String.valueOf(model1.getH_phone());
            intent.setData(Uri.parse(phonee));
            context.startActivity(intent);
        });
        



    }


    @NonNull
    @Override
    public myviewholder1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerowdesign,parent,false);
        return new myviewholder1(view);
    }

    public static class myviewholder1 extends RecyclerView.ViewHolder {

        TextView name_text,address_text,phone_text;
        ImageView hos_pic;
        Button call_button1;

        public myviewholder1(@NonNull View itemView) {
            super(itemView);

            name_text=itemView.findViewById(R.id.name_text);
            address_text=itemView.findViewById(R.id.address_text);
            phone_text=itemView.findViewById(R.id.phone_text);
            call_button1=itemView.findViewById(R.id.call_button1);
            hos_pic=itemView.findViewById(R.id.hos_pic);


        }
    }
}
