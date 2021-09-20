package com.example.kericho;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class myadpter  extends FirebaseRecyclerAdapter<mode,myadpter.myviewholder> {

    public myadpter(@NonNull FirebaseRecyclerOptions<mode> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myadpter.myviewholder holder, int position, @NonNull mode mode) {
        holder.textView.setText(mode.getName());
        holder.textView2.setText(mode.getEmail());
        holder.textView3.setText(mode.getConstituency());

        Glide.with(holder.imageView.getContext()).load(mode.getImage()).into(holder.imageView);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity =(AppCompatActivity)view.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.wrapper,new decFragment(mode.getImage(),mode.getConstituency(), mode.getEmail(),mode.getName(),mode.getDob(),
                        mode.getFacebook(),mode.getTwitter(),mode.getReligion(),mode.getHome(),mode.getOffice(),mode.getParty(),mode.getMarried())).addToBackStack(null).commit();
            }
        });
    }


    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View  view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);
        return new myviewholder(view);
    }

    public class myviewholder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView,textView2,textView3;


        public myviewholder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
            textView2 = itemView.findViewById(R.id.textView2);
            textView3 = itemView.findViewById(R.id.textView3);
        }
    }
}

