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
import androidx.recyclerview.widget.RecyclerView;

public class ComAdapter  extends FirebaseRecyclerAdapter<Commodel,ComAdapter.myviewholder> {
    public ComAdapter(FirebaseRecyclerOptions<Commodel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ComAdapter.myviewholder holder, int position, @NonNull Commodel model) {
        holder.textView.setText(model.getName());
        holder.textView2.setText(model.getEmail());
        holder.textView3.setText(model.getConstituency());
        Glide.with(holder.imageView.getContext()).load(model.getImage()).into(holder.imageView);

    }

    @NonNull
    @Override
    public ComAdapter.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from( parent.getContext()).inflate( R.layout.singlerow,parent,false );
        return new ComAdapter.myviewholder( view );
    }

    public class myviewholder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView,textView2,textView3;
        public myviewholder(@NonNull View itemView) {
            super( itemView );

            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
            textView2 = itemView.findViewById(R.id.textView2);
            textView3 = itemView.findViewById(R.id.textView3);
        }
    }
}
