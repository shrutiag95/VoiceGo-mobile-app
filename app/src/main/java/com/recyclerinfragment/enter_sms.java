package com.recyclerinfragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by hpuser on 31-05-2016.
 */
public class enter_sms extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.phone_forgot);
    }

    public void confirm_phone(View v){

        Intent i =  new Intent(enter_sms.this,sms_sent.class);
        startActivity(i);
    }
}
