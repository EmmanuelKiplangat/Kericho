package com.example.kericho;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.ScrollView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

import static androidx.constraintlayout.motion.utils.Oscillator.TAG;


public class ScheduleActivity extends AppCompatActivity {

    RecyclerView recview;
    scheduleAdapter adapter;
    Intent intent;
    private CalendarView mCalenderView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_schedule );
        ActionBar actionBar=this.getSupportActionBar();
        Objects.requireNonNull( actionBar ).setTitle( (CharSequence) "Events of");
        actionBar.setSubtitle( (CharSequence)"Kericho County Assembly " );
        actionBar.setDisplayHomeAsUpEnabled( true );
        actionBar.setDisplayShowHomeEnabled( true );
        actionBar.setBackgroundDrawable( (Drawable)new ColorDrawable( Color.parseColor((String) "#8b0000") ));
        actionBar.setHomeButtonEnabled( true );
        mCalenderView = findViewById( R.id.calenderview );
        mCalenderView.setOnDateChangeListener( new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                String date = (i1 + 1) + "-" + i2 + "-" + i;
                Log.d( TAG, "onSelectedDayChange:mm/dd/yyyy:" + date );
                Intent intent = new Intent( ScheduleActivity.this, ScheduleActivity.class );
                intent.putExtra( "date", date );
               startActivity( intent );



            }
        } );

        Intent itenta =getIntent();
        String date = itenta.getStringExtra( "date" );
        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN );
        recview = (RecyclerView)findViewById( R.id.recview1 );
        recview.setLayoutManager( new LinearLayoutManager( this ) );

        FirebaseRecyclerOptions<eventModel> options=
                new FirebaseRecyclerOptions.Builder<eventModel>()
                        .setQuery( FirebaseDatabase.getInstance().getReference().child("Event"+"/"+ date ),eventModel.class )
                        .build();

        adapter= new scheduleAdapter(options);
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
        adapter.stopListening();
    }

}