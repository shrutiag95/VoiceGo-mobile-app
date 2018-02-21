package com.recyclerinfragment;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
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
 * Created by hpuser on 29-05-2016.
 */
public class Login_signup extends Activity {



    EditText uname,pw;
    Button bt_login;

    ProgressDialog pDialog;
    sessionmanager session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        final String url="http://192.168.43.206/shruti/loginvolley.php";


        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_login_signup);
        session=new sessionmanager(getApplicationContext());
        uname = (EditText)findViewById(R.id.user_name_login);
        pw =(EditText)findViewById(R.id.pass_login);

        bt_login = (Button) findViewById(R.id.login_btn);

        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Loading...");




        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




               pDialog.show();

                StringRequest strq = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        repo(response);

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        pDialog.hide();
                        Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
                    }
                }

                ){
                    @Override
                    protected Map<String,String> getParams() throws AuthFailureError{
                        Map<String,String> params= new HashMap<String, String>();
                        params.put("username",uname.getText().toString());
                        params.put("password",pw.getText().toString());
                        return params;
                    }

                };
                MySingleton.getInstance(getApplicationContext()).addToRequestQueue(strq);

            }
        });




    }
    public void repo(String response){
        pDialog.hide();

        if(response.equals("Login successfully")){

            session.createLoginSession(uname.getText().toString());
        Intent i= new Intent(Login_signup.this,Slider.class);
        startActivity(i);

    } else{
            Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBackPressed() {
        if(session.isLoggedIn()){
            super.onBackPressed();

        }
        else{
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);

    }
    }





    public void Create_acc(View v){

        Intent i = new Intent(Login_signup.this,register.class);
        startActivity(i);

    }

    public void Recover_forgotten(View v){
        Intent i = new Intent(Login_signup.this,select_recovery_option.class);
        startActivity(i);


    }
}
