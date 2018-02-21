package com.recyclerinfragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Agarwal's on 6/17/2016.
 */
public class profile extends AppCompatActivity {
    TextView tv,tv2;
    sessionmanager session;
    final String url="http://192.168.43.206/shruti/getname.php";
    String username=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);          ////For full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.profile);
        session=new sessionmanager(getApplicationContext());
        tv=(TextView)findViewById(R.id.username_home);
        tv2=(TextView)findViewById(R.id.name_home);
        username=session.getUserDetails().get(session.KEY_NAME);
        profilesetup();


    }
    public void profilesetup(){

        StringRequest strq = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                tv.setText(username);
                tv2.setText(response);

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
            }
        }

        ){
            @Override
            protected Map<String,String> getParams() throws AuthFailureError{
                Map<String,String> params= new HashMap<String, String>();
                params.put("username",username);
                return params;
            }

        };
        MySingleton.getInstance(getApplicationContext()).addToRequestQueue(strq);



    }
}
