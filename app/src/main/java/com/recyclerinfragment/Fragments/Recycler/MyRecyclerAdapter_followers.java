package com.recyclerinfragment.Fragments.Recycler;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.recyclerinfragment.R;
import com.recyclerinfragment.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hpuser on 02-06-2016.
 */
public class MyRecyclerAdapter_followers extends RecyclerView.Adapter<MyViewHolder_followers> {

    Context c;
    List<model> rows;

    public MyRecyclerAdapter_followers(Context c,List<model> rows){

        this.c =c;
        this.rows = rows;

    }

    @Override
    public MyViewHolder_followers onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.model_follower,null);
        MyViewHolder_followers holder = new MyViewHolder_followers(v);
        return holder;
    }

    @Override       //Bind data to views;
    public void onBindViewHolder(final MyViewHolder_followers holder, int position) {

        holder.nameTxt.setText(rows.get(position).getUsername());
        // holder.img.setImageResource(rows.get(position).getImage());
        Glide.with(c).load(R.drawable.man).into(holder.img);
        holder.remove.findViewById(R.id.remove_btn);
        holder.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ///Toast.makeText(c, "Remove " + holder.nameTxt.getText().toString(), Toast.LENGTH_SHORT).show();

                Snackbar.make(v, "Remove " + holder.nameTxt.getText().toString() + " from following?", Snackbar.LENGTH_SHORT).setAction("Yes", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //   Toast.makeText(getApplicationContext(),"ksdjfsdfkjs",Toast.LENGTH_SHORT).show();
                    }
                }).show();
            }
        });

        holder.zzz_followers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(c, "View " + holder.nameTxt.getText().toString() + "\'s Profile", Toast.LENGTH_SHORT).show();

                Snackbar.make(v, "View " + holder.nameTxt.getText().toString() + "\'s Profile", Snackbar.LENGTH_SHORT).setAction("OK", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //   Toast.makeText(getApplicationContext(),"ksdjfsdfkjs",Toast.LENGTH_SHORT).show();
                    }
                }).show();
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
