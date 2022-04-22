package com.example.togara_rudo_s1906627.my_UI;

/* Rudo Courtney Togara
 * S1906627
 * Mobile Platform Development Coursework 1
 * */

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;


import com.example.togara_rudo_s1906627.R;
import com.example.togara_rudo_s1906627.my_DataObject.Roadwork;
import com.example.togara_rudo_s1906627.my_DetailActivity.DetailActivity;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    Context c;
    ArrayList<Roadwork> roadworkList;

    public CustomAdapter(Context c, ArrayList<Roadwork> roadworkList) {
        this.c = c;
        this.roadworkList = roadworkList;
    }

    @Override
    public int getCount() {
        return roadworkList.size();
    }

    @Override
    public Object getItem(int position) {
        return roadworkList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null){
            convertView=LayoutInflater.from(c).inflate(R.layout.model,parent,false);
        }

        TextView titleTxt = (TextView) convertView.findViewById(R.id.titleTxt);
        TextView descTxt = (TextView) convertView.findViewById(R.id.descTxt);
        TextView roadTxt = (TextView) convertView.findViewById(R.id.roadTxt);
        TextView pubDate = (TextView) convertView.findViewById(R.id.pubDate);


        Roadwork roadwork= (Roadwork) this.getItem(position);

        final String title = roadwork.getTitle();
        final String desc = roadwork.getDescription();
        final String road = roadwork.getRoad();
        final String region = roadwork.getRegion();
        final String date= roadwork.getPubDate();

        titleTxt.setText(title);
        descTxt.setText(desc);
        roadTxt.setText(road);
        pubDate.setText(date);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Open the detailed activity
                openDetailActivity(title, desc, road, region, date);

                Toast.makeText(c,roadwork.getTitle(),Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }

    private void openDetailActivity(String...details){
        Intent i = new Intent(c, DetailActivity.class);

        i.putExtra("TITLE_KEY", details[0]);
        i.putExtra("DESC_KEY", details[1]);
        i.putExtra("ROAD_KEY", details[2]);
        i.putExtra("REGION_KEY", details[3]);
        i.putExtra("DATE_KEY", details[4]);

        c.startActivity(i);

    }
}

