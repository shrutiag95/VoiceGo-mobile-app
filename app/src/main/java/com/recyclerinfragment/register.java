package com.recyclerinfragment;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
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
 * Created by Agarwal's on 6/10/2016.
 */
public class register extends Activity {

    EditText email,username,pass,phone;
    ProgressDialog pDialog;
    final String url="http://192.168.43.206/shruti/reg.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.signup_page);
        email = (EditText)findViewById(R.id.email_signup);
        username = (EditText)findViewById(R.id.username_signup);
        pass = (EditText)findViewById(R.id.password_signup);
        phone = (EditText)findViewById(R.id.phone_signup);
        pDialog=new ProgressDialog(this);
        pDialog.setMessage("Signing you up...");
    }

    public void Finish_signup(View v){




        pDialog.show();

        StringRequest strq = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                pDialog.dismiss();
                Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                pDialog.dismiss();
                //Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
            }
        }

        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("username", username.getText().toString());
                params.put("password", pass.getText().toString());
                params.put("phone", phone.getText().toString());
                params.put("email",email.getText().toString());
                return params;
            }

        };
        MySingleton.getInstance(getApplicationContext()).addToRequestQueue(strq);



    }
}
