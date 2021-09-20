package com.example.kericho;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DownloadManager;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SearchView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Objects;

public class Tender extends AppCompatActivity {
    RecyclerView recview;
    tenderAdapter adapter;
    ImageButton im1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        Context context = this;
        setContentView( R.layout.activity_tender );
        recview = (RecyclerView) findViewById( R.id.recycler );
        recview.setLayoutManager( new LinearLayoutManager( this ) );
        ActionBar actionBar = this.getSupportActionBar();
        Objects.requireNonNull( actionBar ).setTitle( (CharSequence) "Tenders" );
        actionBar.setSubtitle( (CharSequence) "Kericho County Assembly " );
        actionBar.setDisplayHomeAsUpEnabled( true );
        actionBar.setDisplayShowHomeEnabled( true );
        actionBar.setBackgroundDrawable( (Drawable) new ColorDrawable( Color.parseColor( (String) "#8b0000" ) ) );
        actionBar.setHomeButtonEnabled( true );

        FirebaseRecyclerOptions<tenderModel> options =
                new FirebaseRecyclerOptions.Builder<tenderModel>()
                        .setQuery( FirebaseDatabase.getInstance().getReference().child( "Tenders" ), tenderModel.class )
                        .build();


        adapter = new tenderAdapter( options );
        recview.setAdapter( adapter );

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected( item );
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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate( R.menu.searchmenu, menu );
        MenuItem item = menu.findItem( R.id.search );

        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener( new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                processsearch( s );
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                processsearch( s );
                return false;
            }
        } );
        return super.onCreateOptionsMenu( menu );
    }

    private void processsearch(String s) {
        FirebaseRecyclerOptions<tenderModel> options =
                new FirebaseRecyclerOptions.Builder<tenderModel>()
                        .setQuery( FirebaseDatabase.getInstance().getReference().child( "Tenders" ).orderByChild( "filename" ).startAt( s ).endAt( s + "\uf8ff" ), tenderModel.class )
                        .build();

        adapter = new tenderAdapter( options );
        adapter.startListening();
        recview.setAdapter( adapter );
    }
}