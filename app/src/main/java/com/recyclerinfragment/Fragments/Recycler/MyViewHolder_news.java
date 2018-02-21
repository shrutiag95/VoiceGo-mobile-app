package com.recyclerinfragment.Fragments.Recycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.recyclerinfragment.R;

/**
 * Created by hpuser on 03-06-2016.
 */
public class MyViewHolder_news extends RecyclerView.ViewHolder {

    ImageView img; TextView nameTxt; RelativeLayout rel_news;

    public MyViewHolder_news(View itemView) {
        super(itemView);
        rel_news = (RelativeLayout)itemView.findViewById(R.id.rel_layout_newsfeed);
        nameTxt =(TextView)itemView.findViewById(R.id.name_in_newsfeed);
        img =(ImageView)itemView.findViewById(R.id.dp_in_newsfeed);

    }
}
