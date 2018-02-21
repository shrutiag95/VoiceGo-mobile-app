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
public class select_recovery_option extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.forgot_login_options);
    }

    public void Via_phone(View view){
        Intent i = new Intent(select_recovery_option.this,enter_sms.class);
        startActivity(i);
       // Toast.makeText(getApplicationContext(),"Via sms",Toast.LENGTH_SHORT).show();
    }

    public void Via_email(View V){
        Intent i = new Intent(select_recovery_option.this,email.class);
        startActivity(i);
     //   Toast.makeText(getApplicationContext(),"Via email",Toast.LENGTH_SHORT).show();
    }
}
