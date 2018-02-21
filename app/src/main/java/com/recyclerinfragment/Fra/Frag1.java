package com.recyclerinfragment.Fra;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.recyclerinfragment.Fragments.Recycler.MyRecyclerAdapter_followers;
import com.recyclerinfragment.Fragments.Recycler.Row_follower;
import com.recyclerinfragment.MySingleton;
import com.recyclerinfragment.R;
import com.recyclerinfragment.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hpuser on 02-06-2016.
 */
public class Frag1 extends Fragment {

    @Nullable
    ProgressDialog pDialog;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_follower,null);

        //Recycler View
       final  RecyclerView rv = (RecyclerView)v.findViewById(R.id.r1);
        rv.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        String view_url = "http://192.168.43.206/shruti/view_followers.php";
        pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Loading...");
        pDialog.show();
        JsonObjectRequest req=new JsonObjectRequest(Request.Method.POST,view_url,null,new Response.Listener<JSONObject>(){


            @Override
            public void onResponse(JSONObject response) {
                pDialog.hide();
                JSONArray followerarray= null;
                List<model> list=new ArrayList<>();
                try {
                    followerarray = response.getJSONArray("followers");

                    for(int i=0;i<followerarray.length();i++){
                        model m=new model();
                        JSONObject obj=followerarray.getJSONObject(i);
                        m.setUsername(obj.getString("username").toString());
                        list.add(m);

                    }} catch (JSONException e) {
                    e.printStackTrace();
                }


                rv.setAdapter(new MyRecyclerAdapter_followers(getActivity(), list));

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                pDialog.hide();
                Toast.makeText(getActivity().getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();

            }
        });

        MySingleton.getInstance(getActivity().getApplicationContext()).addToRequestQueue(req);





        return v;
    }




    @Override
    public String toString() {
        return "Followers";
    }
}
