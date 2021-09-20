package com.example.kericho;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class detFragment extends Fragment {
    RecyclerView recyclerView;
    myadpter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_det, container, false);
        recyclerView=(RecyclerView)view.findViewById(R.id.recview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        FirebaseRecyclerOptions<mode> options=
                new  FirebaseRecyclerOptions.Builder<mode>()
                        .setQuery( FirebaseDatabase.getInstance().getReference().child("MCAs"), mode.class)
                        .build();
        adapter = new myadpter(options);
        recyclerView.setAdapter(adapter);
        return view;
    }
    public void onStart(){
        super.onStart();
        adapter.startListening();
    }
    public void onStop(){
        super.onStop();
        adapter.stopListening();
    }
    @Override
    public void onCreateOptionsMenu(Menu menu , MenuInflater inflater) {
        inflater.inflate( R.menu.searchmenu,menu );
        MenuItem item = menu.findItem( R.id.search );
        super.onCreateOptionsMenu( menu,inflater );

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
    }

    private void processsearch(String s) {
        FirebaseRecyclerOptions<mode> options=
                new  FirebaseRecyclerOptions.Builder<mode>()
                        .setQuery( FirebaseDatabase.getInstance().getReference().child("MCAs").orderByChild( "name" ).startAt( s ).endAt( s + "\uf8ff" ), mode.class)
                        .build();

        adapter=new myadpter( options );
        adapter.startListening();
        recyclerView.setAdapter( adapter );
}

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated( savedInstanceState );
        setHasOptionsMenu( true );
    }
}
