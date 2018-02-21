package com.recyclerinfragment.Fragments.Recycler;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.recyclerinfragment.R;
import com.recyclerinfragment.Utilities;

import java.util.ArrayList;

public class MyRecyclerAdapter_news extends RecyclerView.Adapter<MyViewHolder_news> {

    Context c; ArrayList<Row_newsfeed>row_news;




    public MyRecyclerAdapter_news(Context c, ArrayList<Row_newsfeed>row_news){
        this.row_news = row_news;
        this.c=c;
    }

    @Override
    public MyViewHolder_news onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.model_newsfeed,null);
        MyViewHolder_news holder_news =new MyViewHolder_news(v);
        return holder_news;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder_news holder_news, int position) {

        holder_news.nameTxt.setText(row_news.get(position).getName_news());
    //    holder_news.img.setImageResource(row_news.get(position).getImage());        ////Replace by Picasso/Glide
        Glide.with(c).load(row_news.get(position).getImage()).into(holder_news.img);


        holder_news.rel_news.setOnClickListener(new View.OnClickListener() {

            SeekBar sb;
            TextView aud_name, progress_time, played;
            Button play_pause;
            MediaPlayer song;
            Handler seekhandler = new Handler();
            int count = 1;
            Utilities utils = new Utilities();

            @Override
            public void onClick(View v) {
                // Toast.makeText(c, "Listen to " + holder_news.nameTxt.getText().toString() + "\'s Upload", Toast.LENGTH_SHORT).show();


                final Dialog song_play_dialog = new Dialog(c);
                song_play_dialog.setTitle("Now Playing");
                song_play_dialog.setContentView(R.layout.song_play);
                song_play_dialog.show();


                song_play_dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        seekhandler.removeCallbacks(run);

                        song.pause();
                        song.stop();

                        song.release();
                        song_play_dialog.onBackPressed();
                        //finish();
                    }
                });


                sb = (SeekBar) song_play_dialog.findViewById(R.id.sb);
                play_pause = (Button) song_play_dialog.findViewById(R.id.play_pause);
                aud_name = (TextView) song_play_dialog.findViewById(R.id.audio_name_dialog);
                played = (TextView) song_play_dialog.findViewById(R.id.played);
                progress_time = (TextView) song_play_dialog.findViewById(R.id.duration);
                song = MediaPlayer.create(song_play_dialog.getContext(), R.raw.phoo);            ///Doubtful line.

                sb.setMax(song.getDuration());
                progress_time.setText("" + utils.millisecondstoTimer(song.getDuration()));

                updater();

                if (count == 1) {
                    song.start();
                    //  played.setText(""+utils.millisecondstoTimer(song.getCurrentPosition()));
                    updater();
                    play_pause.setText("PAUSE");
                }

                play_pause.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        count = (count + 1) % 2;
                        switch (count) {
                            case 1:
                                song.start();
                                //  played.setText(""+utils.millisecondstoTimer(song.getCurrentPosition()));
                                updater();
                                play_pause.setText("PAUSE");
                                break;
                            case 0:
                                song.pause();
                                //played.
                                play_pause.setText("PLAY");
                                break;
                        }

                    }


                });                                           ///play_pause set on click listener end.


                sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        //song.getCurrentPosition();
                        //   song.seekTo(progress);
                        if (song != null && fromUser) {


                            song.seekTo(progress);
                            sb.setProgress(progress);       //Latest added line

                            if (count == 1) {
                                song.start();                             //  RE consider it.
                                play_pause.setText("PAUSE");
                            }

                        }

                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                        //   sb.setProgress(song.getCurrentPosition());

                        //  run.
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        song.getCurrentPosition();

                    }
                });


            }


            Runnable run = new Runnable() {
                @Override
                public void run() {

                    //  if(song.isPlaying())
                    if (count == 1)
                        updater();
                    // seekhandler.postDelayed(run,1000);

                }

            };

            private void updater() {
                sb.setProgress(song.getCurrentPosition());

                played.setText("" + utils.millisecondstoTimer(song.getCurrentPosition()));

                // song.seekTo(song.getCurrentPosition());
                seekhandler.postDelayed(run, 1000);
            }


        });

        holder_news.nameTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  Toast.makeText(c, "Visit " + holder_news.nameTxt.getText().toString() + "\'s Profile", Toast.LENGTH_SHORT).show();


                Snackbar.make(v, "View " + holder_news.nameTxt.getText().toString() + "\'s Profile", Snackbar.LENGTH_SHORT).setAction("OK", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //   Toast.makeText(getApplicationContext(),"ksdjfsdfkjs",Toast.LENGTH_SHORT).show();
                    }
                }).show();
            }
        });


        holder_news.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(c, "Visit " + holder_news.nameTxt.getText().toString() + "\'s Profile", Toast.LENGTH_SHORT).show();
                Snackbar.make(v, "View " + holder_news.nameTxt.getText().toString() + "\'s Profile", Snackbar.LENGTH_SHORT).setAction("OK", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //   Toast.makeText(getApplicationContext(),"ksdjfsdfkjs",Toast.LENGTH_SHORT).show();
                    }
                }).show();
            }
        });

    }



    @Override
    public int getItemCount() {
        return row_news.size();
    }
}
