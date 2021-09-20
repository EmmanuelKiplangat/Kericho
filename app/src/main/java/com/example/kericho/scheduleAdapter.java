package com.example.kericho;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class scheduleAdapter extends FirebaseRecyclerAdapter<eventModel,scheduleAdapter.myViewHOlder> {
    public scheduleAdapter(FirebaseRecyclerOptions<eventModel> options) {
        super(options);
    }




    @Override
    protected void onBindViewHolder(@NonNull myViewHOlder holder, int position, @NonNull eventModel model) {
        holder.mEvent.setText( model.getEvent() );
        holder.mTime.setText( model.getTime() );
    }

    @NonNull
    @Override
    public myViewHOlder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from( parent.getContext()).inflate( R.layout.events_cell,parent,false );
        return new myViewHOlder( view );
    }


    public class myViewHOlder extends RecyclerView.ViewHolder {
        TextView mEvent,mTime;
        public myViewHOlder(@NonNull View itemView) {
            super( itemView );
            mEvent=itemView.findViewById( R.id.Event );
            mTime=itemView.findViewById( R.id.Time );
        }
    }
}

