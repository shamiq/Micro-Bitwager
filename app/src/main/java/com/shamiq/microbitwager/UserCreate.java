package com.shamiq.microbitwager;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class UserCreate extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_create);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_user_create, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void next(View view){
        EditText email;
        EditText pin;

        email = (EditText)findViewById(R.id.createNameEditText);
        pin = (EditText)findViewById(R.id.createPinEditText);
        // Add validation at some point.

        // open preferences file
        SharedPreferences settings = getSharedPreferences("DEFAULT", 0);
        SharedPreferences.Editor editor = settings.edit();


        // add items to file
        editor.putString("email", email.getText().toString() );
        editor.putString("PIN", pin.getText().toString());


        // commit editor
        editor.commit();


        //Start the Fund your Account activity.
        Intent intent = new Intent(this, FundAccount.class);
        startActivity(intent);

    }
}
