package com.example.kericho;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.annotations.NotNull;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class myadapter extends FirebaseRecyclerAdapter<model,myadapter.myviewholder> {


    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public myadapter(@NonNull FirebaseRecyclerOptions<model> options) {
        super( options );
    }

    @Override
    protected void onBindViewHolder(@NotNull myadapter.myviewholder holder, int position, @NonNull model model) {
        holder.header.setText( model.getFilename() );

        holder.img1.setOnClickListener( view -> {
           Intent intent = new Intent(holder.img1.getContext(),viewpdf.class);
           intent.putExtra("filename",model.getFilename());
           intent.putExtra( "fileurl",model.getFileurl() );
           intent.setFlags( Intent.FLAG_ACTIVITY_NEW_TASK );
           holder.img1.getContext().startActivity( intent );

        } );
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from( parent.getContext()).inflate( R.layout.singlerowdesign,parent,false );
        return new myviewholder( view );
    }

    public static class  myviewholder extends RecyclerView.ViewHolder{

        ImageView img1;
        TextView header;

        public myviewholder(@NonNull View itemView) {
            super( itemView );
            img1=itemView.findViewById( R.id.img1 );
            header=itemView.findViewById( R.id.header );
        }

    }
}
