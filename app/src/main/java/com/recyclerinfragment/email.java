package com.recyclerinfragment;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Created by Agarwal's on 6/10/2016.
 */




/**
 * Created by hpuser on 10-06-2016.
 */

public class email extends Activity {

    Session session=null; String base = "0123456789qwertyuiopasdfghjklzmxncbvPALSKDJFHGQWERTYUIOMXNZBCVKLA"; String OTP=null;
    Context context = null;
    ProgressDialog pdialog = null; EditText reciepient; Button send ; String rec;
     Bundle b;
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mail);

        context =this;
        send = (Button)findViewById(R.id.send);
        reciepient = (EditText)findViewById(R.id.email_id);
        i=new Intent(email.this,email_sent.class);
        b=new Bundle();

    }


    public void mail_Send(View v) {

        OTP = getOTP();
        rec = reciepient.getText().toString();
        b.putString("otp",OTP);
        b.putString("email",rec);
        i.putExtras(b);
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port","465");
        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth","true");
        props.put("mail.smtp.port","465");


        session = Session.getDefaultInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("voicegoapp@gmail.com", "asdf@1JD");

            }
        });
        pdialog = ProgressDialog.show(context, "", "Sending email...", true);


        RetrieveFeedTask task =  new RetrieveFeedTask();
        task.execute();

    }

    class RetrieveFeedTask extends AsyncTask<String,Void,String> {

        @Override
        protected String doInBackground(String... params) {

            try{

                Message message =  new MimeMessage(session);
                message.setFrom(new InternetAddress("voicegoapp@gmail.com"));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(rec));
                message.setSubject("VoiceGO OTP");
                message.setContent("Hello Dear, Your VoiceGO OTP is " + OTP, "text/html; charset= utf-8");

                Transport.send(message);

             return "Email sent";

            }catch (MessagingException e){return e.getMessage();} catch (Exception e){return e.getMessage();}


        }

        @Override
        protected void onPostExecute(String aVoid) {

            pdialog.dismiss();
            Toast.makeText(getApplicationContext(),aVoid,Toast.LENGTH_SHORT).show();

            if(aVoid.equals("Email sent")){
            startActivity(i);
            }

        }
    }



    public String getOTP() {
        Random r = new Random();
        StringBuilder xxx = new StringBuilder(6);
        for(int i = 0 ; i<6;  ++i){
            xxx.append(base.charAt(r.nextInt(base.length())));
        }
        return xxx.toString();
    }
}
