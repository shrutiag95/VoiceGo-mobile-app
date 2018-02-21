package com.recyclerinfragment.Fragments.Recycler;

/**
 * Created by hpuser on 02-06-2016.
 */
public class Row_follower {
    private String name;
    private int image;
    public Row_follower(String name,int image){
        this.name =name;
        this.image=image;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){

        this.name= name;
    }
    public int getImage(){
        return image;
    }
   /* public void setImage(int image){
        this.image = image;
    }*/
}
