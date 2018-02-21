package com.recyclerinfragment.Fra;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.recyclerinfragment.Fragments.Recycler.MyRecyclerAdapter_news;
import com.recyclerinfragment.Fragments.Recycler.Row_newsfeed;
import com.recyclerinfragment.R;

import java.util.ArrayList;

/**
 * Created by hpuser on 03-06-2016.
 */
public class frag_news extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.frag_newsfeed,null);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.r_news);

        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        recyclerView.setAdapter(new MyRecyclerAdapter_news(this.getActivity(),     get_newsfeed(this.getActivity()) ));
        return view;
    }

    private ArrayList<Row_newsfeed> get_newsfeed(Context context) {


        ArrayList<Row_newsfeed> rows_list = new ArrayList<>();
        Resources res = context.getResources();
        String [] name =res.getStringArray(R.array.username);
        int [] images = {R.drawable.abc,R.drawable.dp,R.drawable.bcd,R.drawable.cde,R.drawable.def,R.drawable.efg,R.drawable.fgh};


        for (int i=0 ; i<10;++i){
            rows_list.add(new Row_newsfeed(name[i],images[i%7]));
        }

        return rows_list;
    }

    @Override
    public String toString() {
        return "NewsFeed";
    }
}
