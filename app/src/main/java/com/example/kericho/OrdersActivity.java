package com.example.kericho;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.SearchView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class OrdersActivity extends AppCompatActivity {
    RecyclerView recview;
    myadapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);
        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN );
        ProgressDialog pd= new ProgressDialog( this );
        pd.setMessage( "loading" );
        recview = (RecyclerView)findViewById( R.id.recvi );
        recview.setLayoutManager( new LinearLayoutManager( this ) );

        ActionBar actionBar=this.getSupportActionBar();
        Objects.requireNonNull( actionBar ).setTitle( (CharSequence) "Orders");
        actionBar.setSubtitle( (CharSequence)"Kericho County Assembly " );
        actionBar.setDisplayHomeAsUpEnabled( true );
        actionBar.setDisplayShowHomeEnabled( true );
        actionBar.setBackgroundDrawable( (Drawable)new ColorDrawable( Color.parseColor((String) "#8b0000") ));
        actionBar.setHomeButtonEnabled( true );

        FirebaseRecyclerOptions<model> options=
                new FirebaseRecyclerOptions.Builder<model>()
                        .setQuery( FirebaseDatabase.getInstance().getReference().child( "Orders" ),model.class )
                        .build();

        pd.show();
        adapter= new myadapter(options);
        recview.setAdapter( adapter );
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            onBackPressed();  return true;
        }

        return super.onOptionsItemSelected(item);
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
        getMenuInflater().inflate( R.menu.searchmenu,menu );
        MenuItem item = menu.findItem( R.id.search );

        SearchView searchView= (SearchView)item.getActionView();
        searchView.setOnQueryTextListener( new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                processsearch(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                processsearch(s);
                return false;
            }
        } );
        return super.onCreateOptionsMenu( menu );
    }

    private void processsearch(String s) {
        FirebaseRecyclerOptions<model> options=
                new FirebaseRecyclerOptions.Builder<model>()
                        .setQuery( FirebaseDatabase.getInstance().getReference().child( "Orders" ).orderByChild( "filename" ).startAt( s ).endAt( s+"\uf8ff" ),model.class )
                        .build();

        adapter=new myadapter( options );
        adapter.startListening();
        recview.setAdapter( adapter );
}
}