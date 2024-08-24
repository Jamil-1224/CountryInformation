package com.example.countryinfromation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class secondScreen extends AppCompatActivity {

    private Button button;
    private ImageView imageView;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_intent);

        imageView = (ImageView) findViewById(R.id.image1);
        textView = (TextView) findViewById(R.id.text1);
        button = (Button) findViewById(R.id.button1);


        Bundle bundle = getIntent().getExtras();


        if (bundle != null){
            String value = bundle.getString("tag");
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(secondScreen.this, thirdScreen.class);
                    intent.putExtra("cat",value);
                    startActivity(intent);
                }
            });

            showDetails(value);
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void showDetails( String value){
        if(value.equals("Bangladesh")){
            imageView.setImageResource(R.drawable.bd_pik);
            textView.setText(R.string.bd);

        }
        if(value.equals("Armenia")){
            imageView.setImageResource(R.drawable.armenia_pikh);
            textView.setText(R.string.armenia);
        }
        if(value.equals("Azerbaijan")){
            imageView.setImageResource(R.drawable.azerbijan_pikh);
            textView.setText(R.string.azerbaijan);
        }
        if(value.equals("Bahrain")){
            imageView.setImageResource(R.drawable.baharin_pikh);
            textView.setText(R.string.bahrain);
        }


    }
}