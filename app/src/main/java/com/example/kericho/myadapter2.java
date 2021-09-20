package com.example.kericho;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class myadapter2 extends FirebaseRecyclerAdapter<model2,myadapter2.myviewholder> {
    public myadapter2(FirebaseRecyclerOptions<model2> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myadapter2.myviewholder holder, int position, @NonNull model2 model) {
        holder.textView4.setText(model.getTitle());
        holder.textView8.setText(model.getStand());

        holder.card3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.card3.getContext(),viewcommittee.class);
                intent.putExtra("Title",model.getTitle());
                intent.putExtra( "Stand",model.getStand() );
                intent.putExtra("Description",model.getDescription());
                intent.putExtra("Members",model.getMembers());
                intent.setFlags( Intent.FLAG_ACTIVITY_NEW_TASK );
                holder.card3.getContext().startActivity( intent );
            }
        } );

    }

    @NonNull
    @Override
    public myadapter2.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from( parent.getContext()).inflate( R.layout.comitterow,parent,false );
        return new myadapter2.myviewholder( view );

    }

    public class myviewholder extends RecyclerView.ViewHolder {
        TextView textView4,textView8;
        CardView card3;
        public myviewholder(@NonNull View itemView) {
            super( itemView );

            textView4 = itemView.findViewById(R.id.textView4);
            textView8 = itemView.findViewById(R.id.textView8);
            card3 = itemView.findViewById( R.id.card3 );
        }
    }
}
