package com.example.test_mad_3125;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SpaceAdapter extends BaseAdapter {

    int logos[] = {R.drawable.demosat, R.drawable.ratsat, R.drawable.razaksat,
            R.drawable.trailblazer, R.drawable.logo};
    String SpaceNames[] = {"Demosat", "RatSat", "RazakSat", "Tarilblazer","Logo"} ;
    String Year[] = {"2001","2002","2003"};
    LayoutInflater inflater;
    Context context;


    SpaceAdapter(Context context){
        this.logos = logos;
        this.Year = Year;
        this.SpaceNames = SpaceNames;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return SpaceNames.length;
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
    public View getView(final int position, View view, ViewGroup viewGroup) {

        view = inflater.inflate(R.layout.spacelayout,null);

        ImageView imgLogo =(ImageView) view.findViewById(R.id.imgLogo);
        TextView txtCompany = view.findViewById(R.id.txtSpace);
        TextView txtYear = view.findViewById(R.id.txtYear);

        imgLogo.setImageResource(this.logos[position]);
        txtCompany.setText(this.SpaceNames[position]);
        txtYear.setText(this.Year[position]);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "item " + position + " selected", Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }
}