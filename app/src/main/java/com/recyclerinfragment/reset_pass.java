package com.recyclerinfragment;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hpuser on 09-06-2016.
 */
public class reset_pass extends Activity {
    EditText pass, conpass;
    ProgressDialog pDialog;
    final String url="http://192.168.43.206/shruti/reset_pass.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.reset_password);
        pass = (EditText) findViewById(R.id.new_pass);
        conpass = (EditText) findViewById(R.id.re_enter_newpass);
        pDialog=new ProgressDialog(this);
        pDialog.setMessage("Updating password...");


    }

    public void change_password(View v) {

        if (pass.getText().toString().equals(conpass.getText().toString())) {

            pDialog.show();

            StringRequest strq = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    pDialog.dismiss();
                    Toast.makeText(getApplicationContext(),response,Toast.LENGTH_SHORT).show();

                }
            }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    pDialog.hide();
                    Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
                }
            }

            ) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("pass", pass.getText().toString());
                    params.put("email",getIntent().getExtras().getString("email"));
                    return params;
                }

            };
            MySingleton.getInstance(getApplicationContext()).addToRequestQueue(strq);

        }


    }
}




