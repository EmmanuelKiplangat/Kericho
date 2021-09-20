package com.example.kericho;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Objects;

public class viewnews extends AppCompatActivity {
TextView news4;
public String news;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_viewnews );
        ActionBar actionBar=this.getSupportActionBar();
        Objects.requireNonNull( actionBar ).setTitle( (CharSequence) "news");
        actionBar.setSubtitle( (CharSequence)"Kericho County Assembly " );
        actionBar.setDisplayHomeAsUpEnabled( true );
        actionBar.setDisplayShowHomeEnabled( true );
        actionBar.setBackgroundDrawable( (Drawable)new ColorDrawable( Color.parseColor((String) "#8b0000") ));
        actionBar.setHomeButtonEnabled( true );
        news4=findViewById( R.id.news4 );
        news = getIntent().getStringExtra( "news" );
        news4.setText( news );
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