package com.example.countryinfromation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

    String[] coutryName;
    String[] population;
    int[] flags;
    Context context;
    private LayoutInflater inflater;

    public CustomAdapter(MainActivity mainActivity, int[] flags, String[] countryName, String[] population) {
       this.context = mainActivity;
       this.flags =flags;
       this.coutryName = countryName;
       this.population = population;
    }

    @Override
    public int getCount() {
        return coutryName.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null){

            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.convert_view,viewGroup,false);

        }
        ImageView imageView = (ImageView) view.findViewById(R.id.image1);
        imageView.setImageResource(flags[i]);
        TextView textView1 = (TextView) view.findViewById(R.id.text1);
        textView1.setText(coutryName[i]);
        TextView textView2 = (TextView) view.findViewById(R.id.text2);
        textView2.setText(population[i]);

        return view;
    }
}
