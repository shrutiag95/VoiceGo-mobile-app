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
public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    ImageView img; TextView nameTxt; Button unfollow; RelativeLayout zzz;
    ItemClickListener itemClickListener;


    public MyViewHolder(View itemView) {
        super(itemView);

        final Context x; zzz = (RelativeLayout) itemView.findViewById(R.id.zzz);
        img =(ImageView)zzz.findViewById(R.id.dp_in_followers);
        nameTxt = (TextView)zzz.findViewById(R.id.name_in_following);

        unfollow =(Button)zzz.findViewById(R.id.unfollow_bt);

    }


    public void setItemClickListener(ItemClickListener ic){
        this.itemClickListener = ic;
    }

    @Override
    public void onClick(View v) {
        this.itemClickListener.OnitemClick(v,getLayoutPosition());
    }
}
