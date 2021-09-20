package com.example.kericho;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    Button button,b2,b3,b4,b5,b6,tender,butt00;
    ImageButton imagebutt1,imagebutt2;
    CardView orders;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar=this.getSupportActionBar();
        Objects.requireNonNull( actionBar ).setTitle( (CharSequence) "Kericho County Assembly ");
        actionBar.setBackgroundDrawable( (Drawable)new ColorDrawable( Color.parseColor((String) "#8b0000") ));

        imagebutt1=findViewById( R.id.imagebutt1 );
        imagebutt2=findViewById( R.id.imagebutt2 );
        button=findViewById( R.id.b1 );
        tender=findViewById( R.id.tender );
        b2=findViewById( R.id.b2 );
        b3=findViewById( R.id.b3 );
        b4=findViewById( R.id.b4 );
        b5=findViewById( R.id.b5 );
        b6=findViewById( R.id.b6 );
        butt00=findViewById( R.id.butt00 );

        imagebutt1.setOnClickListener( view -> imagebutt1.getContext().startActivity( new Intent(imagebutt1.getContext(),ScheduleActivity.class) ) );
        butt00.setOnClickListener( view -> butt00.getContext().startActivity( new Intent(butt00.getContext(),CommiteeActivity.class) ) );
        imagebutt2.setOnClickListener( view -> imagebutt2.getContext().startActivity( new Intent(imagebutt2.getContext(),StreamActivity.class) ) );
        b2.setOnClickListener( view -> b2.getContext().startActivity( new Intent(b2.getContext(),MotionsActivity.class) ) );
        b3.setOnClickListener( view -> b3.getContext().startActivity( new Intent(b3.getContext(),HansardActivity.class) ) );
        b5.setOnClickListener( view -> b5.getContext().startActivity( new Intent(b5.getContext(),LeadershipActivity.class) ) );
        b4.setOnClickListener( view -> b4.getContext().startActivity( new Intent(b4.getContext(),ActsActivity.class) ) );
        tender.setOnClickListener( view -> tender.getContext().startActivity( new Intent(tender.getContext(),Tender.class) ) );
        b6.setOnClickListener( view -> b6.getContext().startActivity( new Intent(b6.getContext(),McaActivity.class) ) );
        button.setOnClickListener( view ->
                button.getContext().startActivity( new Intent(button.getContext(),BillsActivity.class) ));
        orders=findViewById( R.id.HB);
        orders.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orders.getContext().startActivity( new Intent(orders.getContext(),HouseBussiness.class) );
            }
        } );
    }
}