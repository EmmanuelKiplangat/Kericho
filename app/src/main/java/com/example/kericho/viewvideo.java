package com.example.kericho;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.VideoView;

import java.util.Objects;

public class viewvideo extends AppCompatActivity {
    ProgressDialog pd;
  VideoView videoView;
  ImageButton btnPlayPause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_viewvideo );
        ActionBar actionBar=this.getSupportActionBar();
        Objects.requireNonNull( actionBar ).setTitle( (CharSequence) getIntent().getStringExtra( "filename" ) );
        actionBar.setSubtitle( (CharSequence)"Kericho County Assembly " );
        actionBar.setDisplayHomeAsUpEnabled( true );
        actionBar.setDisplayShowHomeEnabled( true );
        actionBar.setBackgroundDrawable( (Drawable)new ColorDrawable( Color.parseColor((String) "#8b0000") ));
        actionBar.setHomeButtonEnabled( true );

        videoView = findViewById( R.id.videoView );
        String path = getIntent().getStringExtra( "fileurl" );
        Uri uri = Uri.parse( path );
        videoView.setVideoURI( uri );

        MediaController mediaController= new MediaController( this );
        videoView.setMediaController( mediaController );
        videoView.requestFocus();
        videoView.start();
        mediaController.setAnchorView( videoView );

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            onBackPressed();  return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
