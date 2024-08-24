package com.example.countryinfromation;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private CustomAdapter customAdapter;
    private ListView listView;
    String[] countryName;
    String[] population;
    int[] flags={ R.drawable.afghanistan,R.drawable.armenia,R.drawable.azerbaijan,R.drawable.bahrain,
            R.drawable.bangladesh,R.drawable.bhutan,R.drawable.china,R.drawable.india,R.drawable.japan,R.drawable.nepal,R.drawable.pakistan,
            R.drawable.sri_lanka
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.green)));

        listView = (ListView) findViewById(R.id.list1);

        countryName = getResources().getStringArray(R.array.countryName);
        population = getResources().getStringArray(R.array.population);
        customAdapter = new CustomAdapter(this,flags,countryName,population);
        listView.setAdapter(customAdapter);
        listView.setTextFilterEnabled(true);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(MainActivity.this,secondScreen.class);
                intent.putExtra("tag",countryName[i]);
                startActivity(intent);

            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_sample,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==R.id.search1){

            SearchView searchView = (SearchView) item.getActionView();
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String s) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String s) {

                    return false;
                }
            });
        }

        if(item.getItemId()==R.id.share1){

            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            String subject = "Country information app";
            String text = "This app help to eassy know any country";
            intent.putExtra(Intent.EXTRA_SUBJECT,subject);
            intent.putExtra(Intent.EXTRA_TEXT,text);

            startActivity(Intent.createChooser(intent,"Share us"));

        }
        if(item.getItemId()==R.id.feedback1){

            Intent intent = new Intent(MainActivity.this, feedback.class);

            startActivity(intent);


        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {


        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder.setIcon(R.drawable.qu);
        alertDialogBuilder.setTitle(R.string.title);
        alertDialogBuilder.setMessage(R.string.msg);
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }
}