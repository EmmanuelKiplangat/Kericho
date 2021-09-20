package com.example.kericho;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;

public class StreamActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {


    YouTubePlayerView player;
    String API_key ="AIzaSyABnXnWCf54ySew6JksR-qO2i2kvwj2JTg";
    private final FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
    private final DatabaseReference reference = firebaseDatabase.getReference();
    private final DatabaseReference childreference =reference.child( "stream" );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_stream );
        player= findViewById( R.id.view3 );
        player.initialize( API_key,this );

                }



    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b){
        childreference.addValueEventListener( new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String id = snapshot.getValue(String.class);
                   if (!b & snapshot.exists()) {
                       youTubePlayer.cueVideo( id );
                       youTubePlayer.play();
                   }else{
                       alert( "No Live stream!!! " +
                               "Want To view archived for previous proceedings" );
                   }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        } );

    }


    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

    }
    private void alert(String message){
        AlertDialog dig = new AlertDialog.Builder( StreamActivity.this )
                .setTitle( "Message" )
                .setMessage( message )
                .setNegativeButton( "No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent=new Intent(StreamActivity.this,MainActivity.class);
                        startActivity( intent );
                    }
                } )
                .setPositiveButton( "Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent=new Intent(StreamActivity.this,ArchievActivicty.class);
                        startActivity( intent );

                    }
                } )
                .create();
        dig.show();
    }
}