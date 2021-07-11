package com.example.hospital;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class myAdapter1 extends FirebaseRecyclerAdapter<model1,myAdapter1.myviewholder> {


    public myAdapter1(@NonNull FirebaseRecyclerOptions<model1> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull model1 model) {

        holder.name_text.setText(model.getName());
        holder.address_text.setText(model.getLocation());

    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerowdesign,parent,false);
        return new myviewholder(view);
    }

    public class myviewholder extends RecyclerView.ViewHolder {

        TextView name_text,address_text;
        public myviewholder(@NonNull View itemView) {
            super(itemView);

            name_text=itemView.findViewById(R.id.name_text);
            address_text=itemView.findViewById(R.id.address_text);
        }
    }
}
