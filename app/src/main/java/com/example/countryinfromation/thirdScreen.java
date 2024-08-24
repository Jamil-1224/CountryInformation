package com.example.countryinfromation;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class thirdScreen extends AppCompatActivity {

    private VideoView videoView;
    private Uri uri;
    private MediaController mediaController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_third_screen);

        mediaController = new MediaController(this);
        videoView = (VideoView) findViewById(R.id.video1);
        
        Bundle bundle = getIntent().getExtras();
        
        if(bundle!=null){
            String val = bundle.getString("cat");
            showVideo(val);
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void showVideo(String val){
        if(val.equals("Bangladesh")){
            Toast.makeText(this, "jamil", Toast.LENGTH_SHORT).show();
            uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.bd_song);
            videoView.setVideoURI(uri);

            videoView.setMediaController(mediaController);
            videoView.start();
        }
    }
}