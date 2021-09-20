package com.example.kericho;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.annotations.NotNull;

import java.net.CookieManager;
import java.net.URL;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import static android.content.Context.DOWNLOAD_SERVICE;
import static android.os.Environment.DIRECTORY_DOWNLOADS;
import static androidx.core.content.ContextCompat.getColorStateList;
import static androidx.core.content.ContextCompat.getSystemService;

public class tenderAdapter extends FirebaseRecyclerAdapter<tenderModel,tenderAdapter.myviewholder> {


    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public tenderAdapter(@NonNull FirebaseRecyclerOptions<tenderModel> options) {
        super( options );
    }

    @Override
    protected void onBindViewHolder(@NotNull tenderAdapter.myviewholder holder, int position, @NonNull tenderModel model) {
        holder.header.setText( model.getFilename() );
          String i= model.getFileurl();
        String name=model.getFilename();
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
        View view = LayoutInflater.from( parent.getContext() ).inflate( R.layout.elements, parent, false );
        return new myviewholder( view );


    }

    public static class  myviewholder extends RecyclerView.ViewHolder{

        ImageView img1;
        TextView header;
        ImageButton im1;

        public myviewholder(@NonNull View itemView) {
            super( itemView );
            img1=itemView.findViewById( R.id.img1 );
            header=itemView.findViewById( R.id.header );

        }


    }

}
