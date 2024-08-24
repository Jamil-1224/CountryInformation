package com.example.countryinfromation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class feedback extends AppCompatActivity implements View.OnClickListener {

    private EditText editText1,editText2;
    private Button button1,button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_feedback);

        editText1 = (EditText) findViewById(R.id.edit1);
        editText2 = (EditText) findViewById(R.id.edit2);

        button1 =  (Button) findViewById(R.id.button1);
        button2 =  (Button) findViewById(R.id.button2);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onClick(View view) {

        try {

            String name = editText1.getText().toString();
            String text = editText2.getText().toString();


            if(view.getId()==R.id.button1){

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/email");

                intent.putExtra(Intent.EXTRA_EMAIL,new String[] {"rousonjamil5328@gmail.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT,"Feedback from app");
                intent.putExtra(Intent.EXTRA_TEXT,"Name : "+name+" \n Message : "+text);
                startActivity(Intent.createChooser(intent,"Feedback with"));

            } else if (view.getId()==R.id.button2) {
                editText1.setText("");
                editText2.setText("");
            }
        }catch (Exception e){
            Toast.makeText(this, "Exception : "+e, Toast.LENGTH_SHORT).show();
        }
    }
}