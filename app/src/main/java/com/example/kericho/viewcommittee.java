package com.example.kericho;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

import java.text.MessageFormat;
import java.util.Objects;

public class viewcommittee extends AppCompatActivity {
    TextView textView9,textView10;
    RecyclerView recview;
    ComAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_viewcommittee );
        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN );
        ActionBar actionBar=this.getSupportActionBar();
        Objects.requireNonNull( actionBar ).setTitle( (CharSequence)getIntent().getStringExtra( "Title" ));
        actionBar.setSubtitle( (CharSequence)"Kericho County Assembly " );
        actionBar.setDisplayHomeAsUpEnabled( true );
        actionBar.setDisplayShowHomeEnabled( true );
        actionBar.setBackgroundDrawable( (Drawable)new ColorDrawable( Color.parseColor((String) "#8b0000") ));
        actionBar.setHomeButtonEnabled( true );

        textView9 = findViewById( R.id.textView9 );
        textView10 = findViewById( R.id.textView10 );

        String title = getIntent().getStringExtra( "Title" );
        String Stand = getIntent().getStringExtra( "Stand" );
        String description = getIntent().getStringExtra( "Description" );


        textView9.setText( MessageFormat.format( "{0}({1})", title, Stand ) );
        textView10.setText( description );

        recview=(RecyclerView)findViewById(R.id.recyclerView2);
        recview.setLayoutManager( new LinearLayoutManager( this ) );

        FirebaseRecyclerOptions<Commodel> options=
                new  FirebaseRecyclerOptions.Builder<Commodel>()
                        .setQuery( FirebaseDatabase.getInstance().getReference().child("CommMembers"+"/"+title), Commodel.class)
                        .build();
        adapter = new ComAdapter(options);
        recview.setAdapter(adapter);



    }
    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.startListening();
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