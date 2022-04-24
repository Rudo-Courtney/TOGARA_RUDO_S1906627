package com.example.togara_rudo_s1906627.my_DetailActivity;

/* Rudo Courtney Togara
 * S1906627
 * Mobile Platform Development Coursework 1
 * */

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.example.togara_rudo_s1906627.R;
import com.google.android.material.snackbar.Snackbar;

public class DetailActivity extends AppCompatActivity {

    TextView titleTxt, descTxt, dateTxt, roadTxt, regionTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        Button openRoadWorks = (Button) findViewById(R.id.openRoadWorks);

        titleTxt = (TextView) findViewById(R.id.titleDetailTxt);
        descTxt = (TextView) findViewById(R.id.descDetailTxt);
        roadTxt = (TextView) findViewById(R.id.roadDetailTxt);
        regionTxt = (TextView) findViewById(R.id.regionDetailTxt);
        dateTxt = (TextView) findViewById(R.id.dateDetailTxt);

        Intent i = this.getIntent();

        String title = i.getExtras().getString("TITLE_KEY");
        String desc = i.getExtras().getString("DESC_KEY");
        String road = i.getExtras().getString("ROAD_KEY");
        String region = i.getExtras().getString("REGION_KEY");
        String date = i.getExtras().getString("DATE_KEY");

        titleTxt.setText(title);
        descTxt.setText(desc);
        roadTxt.setText(road);
        regionTxt.setText(region);
        dateTxt.setText(date);


        openRoadWorks.setOnClickListener((view) -> {
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
        });
    }



    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            this.finish();
        }
return super.onOptionsItemSelected(item);
    }
}