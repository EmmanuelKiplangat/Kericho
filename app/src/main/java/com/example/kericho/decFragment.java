package com.example.kericho;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class decFragment extends Fragment {
    String name, constituency, email,image, dob,  facebook, religion, home,  office, party,twitter,marry;
     ImageView face,twit;
    public decFragment(String image, String constituency, String email, String name, String dob, String facebook,
                       String twitter, String religion, String home, String office, String party, String married) {
        this.name = name;
        this.email=email;
        this.constituency=constituency;
        this.image=image;
        this.dob=dob;
        this.facebook=facebook;
        this.twitter=twitter;
        this.religion=religion;
        this.home=home;
        this.office=office;
        this.party=party;
        this.marry=married;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_dec2, container, false);
        face = view.findViewById( R.id.face );
        face.setOnClickListener( view1 -> {
            String url=facebook;
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData( Uri.parse( url ) );
            startActivity( i );

        } );
        twit = view.findViewById( R.id.twitter );
        twit.setOnClickListener( view1 -> {
            String url = facebook;
            Intent i =new Intent(Intent.ACTION_VIEW);
            i.setData( Uri.parse( url ) );
            startActivity( i );
        } );
        face.setOnClickListener( view1 -> {
            String url=facebook;
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData( Uri.parse( url ) );
            startActivity( i );

        } );
        ImageView imageholder=view.findViewById(R.id.imageView3);
        TextView nameholder=view.findViewById(R.id.textView5);
        TextView constituencyholder=view.findViewById(R.id.textView6);
        TextView emailholder=view.findViewById(R.id.textView7);
        TextView dobholder=view.findViewById(R.id.date);
        TextView religionholder=view.findViewById(R.id.Religion);
        TextView homeholder=view.findViewById(R.id.Home);
        TextView officeholder=view.findViewById(R.id.office);
        TextView partyholder=view.findViewById(R.id.party);
        TextView marrryholder=view.findViewById( R.id.marriage );

        marrryholder.setText( marry );
        nameholder.setText(name);
        emailholder.setText(email);
        constituencyholder.setText(constituency);
        dobholder.setText(dob);
        religionholder.setText( religion );
        homeholder.setText( home );
        officeholder.setText( office );
        partyholder.setText( party );

        Glide.with(imageholder.getContext()).load(image).into(imageholder);
        return  view;

    }
    public void onBackPressed(){
        AppCompatActivity activity =(AppCompatActivity)getContext();
        assert activity != null;
        activity.getSupportFragmentManager().beginTransaction().replace(R.id.wrapper,new detFragment()).addToBackStack(null).commit();
    }
}