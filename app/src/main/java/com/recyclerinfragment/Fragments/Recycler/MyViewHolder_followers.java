package com.recyclerinfragment.Fragments.Recycler;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.recyclerinfragment.R;

/**
 * Created by hpuser on 02-06-2016.
 */
public class MyViewHolder_followers extends RecyclerView.ViewHolder implements View.OnClickListener {

    ImageView img; TextView nameTxt; Button remove; RelativeLayout zzz_followers;
    ItemClickListener itemClickListener;


    public MyViewHolder_followers(View itemView) {
        super(itemView);

        final Context xx; zzz_followers = (RelativeLayout) itemView.findViewById(R.id.zzz_follower);
        img =(ImageView)zzz_followers.findViewById(R.id.dp_in_followers);
        nameTxt = (TextView)zzz_followers.findViewById(R.id.name_in_followers);

        remove =(Button)zzz_followers.findViewById(R.id.remove_btn);

    }


  /*  public void setItemClickListener(ItemClickListener ic){
        this.itemClickListener = ic;
    }*/

    @Override
    public void onClick(View v) {
        this.itemClickListener.OnitemClick(v,getLayoutPosition());
    }
}
