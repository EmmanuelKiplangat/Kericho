package com.example.kericho;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class motionAdapter extends FirebaseRecyclerAdapter<motionModel,motionAdapter.myViewHolder> {
    public motionAdapter(FirebaseRecyclerOptions<motionModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull motionModel model) {
        holder.textView11.setText( model.getMotion() );
        holder.pBy.setText( model.getOpenDate() );
        holder.textView13.setText( model.getProposer() );
        holder.secBy.setText( model.getSeconder() );
        holder.cDate.setText( model.getCloseDate() );
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from( parent.getContext()).inflate( R.layout.motiontrack_cell,parent,false );
        return new myViewHolder( view );
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView textView11,textView13,pBy,secBy,cDate;
        public myViewHolder(@NonNull View itemView) {
            super( itemView );
            textView11=itemView.findViewById( R.id.textView11);
            textView13=itemView.findViewById( R.id.textView13);
            pBy=itemView.findViewById( R.id.pBy);
            secBy=itemView.findViewById( R.id.secBy);
            cDate=itemView.findViewById( R.id.cDate);

        }
    }

}
