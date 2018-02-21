package com.recyclerinfragment.Fragments.Recycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.recyclerinfragment.R;
import com.recyclerinfragment.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hpuser on 02-06-2016.
 */
public class MyRecyclerAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context c;
    List<model> rows;

    public MyRecyclerAdapter(Context c,List<model> rows){

        this.c =c;
        this.rows = rows;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.model_following,null);
        MyViewHolder holder = new MyViewHolder(v);
        return holder;
    }

    @Override       //Bind data to views;
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        holder.nameTxt.setText(rows.get(position).getUsername());
       // holder.img.setImageResource(rows.get(position).getImage());
        Glide.with(c).load(R.drawable.man).into(holder.img);
        holder.unfollow.findViewById(R.id.unfollow_bt);
        holder.unfollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(c,"Unfollow "+holder.nameTxt.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });

        holder.zzz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(c, "View " + holder.nameTxt.getText().toString() + "\'s Profile", Toast.LENGTH_SHORT).show();
            }
        });
       /* holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void OnitemClick(View v, int pos) {
                Toast.makeText(c,"View "+rows.get(pos).getName()+"\'s Profile",Toast.LENGTH_SHORT).show();
            }
        });*/


    }

    @Override
    public int getItemCount() {
        return rows.size();
    }
}
