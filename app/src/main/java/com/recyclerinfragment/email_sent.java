package com.recyclerinfragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by hpuser on 09-06-2016.
 */
public class email_sent extends Activity {
    Button b;
    EditText et;
    Bundle bundle=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);          ////For full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.email_sent);

        et=(EditText)findViewById(R.id.OTP_insert_email);
        bundle =getIntent().getExtras();
        Toast.makeText(getApplicationContext(),bundle.getString("otp"),Toast.LENGTH_SHORT).show();    }

    public void confirm_otp_email(View v){

        String actual=bundle.getString("otp");
        String usergiven=et.getText().toString();
        if(actual.equals(usergiven)){



            Intent in=new Intent(email_sent.this,reset_pass.class);
            in.putExtras(bundle);
            startActivity(in);

        }
        else
            Toast.makeText(getApplicationContext(),"Invalid OTP",Toast.LENGTH_SHORT).show();



    }
}
