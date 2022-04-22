package com.example.togara_rudo_s1906627.my_UI;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.togara_rudo_s1906627.R;

public class MyViewHolder extends RecyclerView.ViewHolder {

    TextView titleTxt,descTxt,pubDate;


    public MyViewHolder(View itemView) {
        super(itemView);

        titleTxt=(TextView) itemView.findViewById(R.id.titleTxt);
        descTxt=(TextView) itemView.findViewById(R.id.descTxt);
        pubDate=(TextView) itemView.findViewById(R.id.pubDate);
    }


}