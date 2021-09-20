package com.example.kericho;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuView;

import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.net.URLEncoder;
import java.util.Base64;
import java.util.Objects;

import static android.os.Environment.DIRECTORY_DOWNLOADS;

public class viewpdf extends AppCompatActivity {
WebView pdfview;
public  String filename,fileurl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_viewpdf );
        ActionBar actionBar=this.getSupportActionBar();
        Objects.requireNonNull( actionBar ).setTitle( (CharSequence)"Document View");
        actionBar.setSubtitle( (CharSequence)"Kericho County Assembly " );
        actionBar.setDisplayHomeAsUpEnabled( true );
        actionBar.setDisplayShowHomeEnabled( true );
        actionBar.setBackgroundDrawable( (Drawable)new ColorDrawable( Color.parseColor((String) "#8b0000") ));
        actionBar.setHomeButtonEnabled( true );

        pdfview=(WebView)findViewById( R.id.viewpdf );

        pdfview.getSettings().setJavaScriptEnabled( true );


        filename= getIntent().getStringExtra( "filename" );
        fileurl = getIntent().getStringExtra( "fileurl" );

        ProgressDialog pd = new ProgressDialog( this );
        pd.setTitle( filename );
        pd.setMessage( "Opening" );


        pdfview.setWebViewClient( new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted( view, url, favicon );
                pd.show();
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished( view, url );
                pd.dismiss();
            }
        } );


        String url="";
        try {
            url= URLEncoder.encode( fileurl,"UTF-8" );
        }catch (Exception ex)
        {}

        pdfview.loadUrl( "http://docs.google.com/gview?embedded=true&url="+url );



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
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater =getMenuInflater();
        inflater.inflate( R.menu.download ,menu);

        MenuItem item = menu.findItem(R.id.download);
       item.setOnMenuItemClickListener( new MenuItem.OnMenuItemClickListener() {
           @Override
           public boolean onMenuItemClick(MenuItem menuItem) {
               downloadFile(getApplicationContext(),filename,".pdf",DIRECTORY_DOWNLOADS,fileurl);
               return false;
           }
       } );

        return true;
    }

    public long downloadFile(Context context, String fileName, String fileExtension, String destinationDirectory, String url) {


        DownloadManager downloadmanager = (DownloadManager) context.
                getSystemService( Context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(url);
        DownloadManager.Request request = new DownloadManager.Request(uri);

        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalFilesDir(context, destinationDirectory, fileName + fileExtension);

        return downloadmanager.enqueue(request);
    }


}

