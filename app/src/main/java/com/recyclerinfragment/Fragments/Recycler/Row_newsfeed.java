package com.recyclerinfragment.Fragments.Recycler;

/**
 * Created by hpuser on 03-06-2016.
 */
public class Row_newsfeed {
    private String name_news;
    private int dp_news;

    public Row_newsfeed(String name_news,int dp_news){
        this.name_news = name_news;
        this.dp_news = dp_news;
    }

    public String getName_news(){
        return name_news;
    }
/*    public void setName_news(String name){
        this.name_news = name;
    }*/

    public int getImage(){
        return dp_news;
    }
    /*public void setImage(int image){
        this.dp_news = image;
    }*/
}
