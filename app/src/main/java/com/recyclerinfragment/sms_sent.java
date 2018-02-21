package com.recyclerinfragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by hpuser on 09-06-2016.
 */
public class sms_sent extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);          ////For full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.mobile_sent);
    }

    public void confirm_otp_mobile (View v){
        Snackbar.make(v,"OTP confirmed",Snackbar.LENGTH_SHORT).show();

        Intent i =  new Intent(this,reset_pass.class);
        startActivity(i);

    }
}
