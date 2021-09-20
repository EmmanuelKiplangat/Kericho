package com.example.kericho;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.annotations.NotNull;
import com.squareup.picasso.Picasso;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class McaActivity extends AppCompatActivity {
    ImageView image,image1;
    TextView text,text1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_mca );
        ActionBar actionBar=this.getSupportActionBar();
        Objects.requireNonNull( actionBar ).setTitle( (CharSequence) "Assembley Leadership");
        actionBar.setSubtitle( (CharSequence)"Kericho County Assembly " );
        actionBar.setDisplayHomeAsUpEnabled( true );
        actionBar.setDisplayShowHomeEnabled( true );
        actionBar.setBackgroundDrawable( (Drawable)new ColorDrawable( Color.parseColor((String) "#8b0000") ));
        actionBar.setHomeButtonEnabled( true );
        ProgressDialog pd= new ProgressDialog( this );
        pd.setMessage( "loading" );


        image=findViewById( R.id.image );
        image1=findViewById( R.id.image1 );
        text=findViewById( R.id.text );
        text1=findViewById( R.id.text1 );

        FirebaseDatabase firebaseDatabase= FirebaseDatabase.getInstance();
        DatabaseReference databaseReference =firebaseDatabase.getReference();
        DatabaseReference first =databaseReference.child("Leadership/Speaker/image1");
        DatabaseReference first2 =databaseReference.child("Leadership/Clerk/image1");
        pd.show();


        first.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    pd.dismiss();
                }else{
                    pd.show();
                }

                String link = dataSnapshot.getValue( String.class );
                Picasso.get().load( link ).into( image );

            }



            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {
            }
            });
        first2.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    pd.dismiss();
                }else{
                    pd.show();
                }

                String link = dataSnapshot.getValue( String.class );
                Picasso.get().load( link ).into( image1 );

            }



            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {
            }
        });


                databaseReference.addValueEventListener( new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        String data = dataSnapshot.child( "Leadership/Clerk/name" ).getValue( String.class );
                        String da = dataSnapshot.child( "Leadership/Speaker/name" ).getValue( String.class );
                        text.setText( da );
                        text1.setText( data );

                    }


                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

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