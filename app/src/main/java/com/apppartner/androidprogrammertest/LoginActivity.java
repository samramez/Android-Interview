package com.apppartner.androidprogrammertest;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.apppartner.androidprogrammertest.models.CustomHttpClient;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;

public class LoginActivity extends ActionBarActivity
{

    private EditText loginEditText;
    private EditText passEditText;

    private TextView resultTextView;

    // String for receiving the JSON response from the server
    String response = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        // Initializing Views
        loginEditText = (EditText) findViewById(R.id.loginEditText);
        passEditText = (EditText) findViewById(R.id.passEditText);
        resultTextView = (TextView) findViewById(R.id.resultTextView);

    }


    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onLoginClick(View view) {

        // Getting user and pass from EditText
        String username = loginEditText.getText().toString();
        String password = passEditText.getText().toString();

        // Just fot testing purposes:
        username = "SuperBoise";
        password = "qwerty";

        //String[] login = {username,password};

        // Running the AsyncTask function and check if user and pass is right
        AuthUserPass authUserPass = new AuthUserPass();
        authUserPass.execute(new String[]{username, password});
    }

    public class AuthUserPass extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... params) {

            ArrayList<NameValuePair> postParameters = new ArrayList<NameValuePair>();
            postParameters.add(new BasicNameValuePair("username", params[0] ));
            postParameters.add(new BasicNameValuePair("password", params[1] ));
            String res = null;

            try{

                String url = "http://dev.apppartner.com/AppPartnerProgrammerTest/scripts/login.php";

                response = CustomHttpClient.executeHttpPost(url , postParameters);

                res = response;
                res = res.replaceAll("\\s+","");

            } catch (Exception e) {
                e.printStackTrace();
            }

            return res;
        }

        @Override
        protected void onPostExecute(String result) {

            if(result != null){

                // Showing the return from the server
                resultTextView.setText(result);
                resultTextView.setVisibility(View.VISIBLE);
            }
        }


    }
}
