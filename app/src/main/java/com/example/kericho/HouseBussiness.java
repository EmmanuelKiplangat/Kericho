package com.example.kericho;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import java.util.Objects;

public class HouseBussiness extends AppCompatActivity {
    CardView  orders, votes,bills,acts,video,hansard,motion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house_bussiness);
        ActionBar actionBar=this.getSupportActionBar();
        Objects.requireNonNull( actionBar ).setTitle( (CharSequence) "Assembly Business");
        actionBar.setSubtitle( (CharSequence)"Kericho County Assembly " );
        actionBar.setDisplayHomeAsUpEnabled( true );
        actionBar.setDisplayShowHomeEnabled( true );
        actionBar.setBackgroundDrawable( (Drawable)new ColorDrawable( Color.parseColor((String) "#8b0000") ));
        actionBar.setHomeButtonEnabled( true );
        orders=findViewById( R.id.order);
        orders.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            orders.getContext().startActivity( new Intent(orders.getContext(),OrdersActivity.class) );
            }
        } );
        votes=findViewById( R.id.votes );
        votes.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                votes.getContext().startActivity( new Intent(votes.getContext(),VotesActivity.class) );

            }
        } );
        bills=findViewById( R.id.bills );
        bills.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bills.getContext().startActivity( new Intent(bills.getContext(),BillsActivity.class) );

            }
        } );
        acts=findViewById( R.id.Acts );
        acts.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                acts.getContext().startActivity( new Intent(acts.getContext(),ActsActivity.class) );

            }
        } );
        video=findViewById( R.id.video );
        video.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                video.getContext().startActivity( new Intent(video.getContext(),ArchievActivicty.class) );
            }
        } );
        hansard=findViewById( R.id.hansard );
        hansard.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               hansard.getContext().startActivity( new Intent(hansard.getContext(),HansardActivity.class) );
            }
        } );
        motion= findViewById( R.id.motion );
        motion.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                motion.getContext().startActivity( new Intent(motion.getContext(),MotionsActivity.class) );
            }
        } );
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