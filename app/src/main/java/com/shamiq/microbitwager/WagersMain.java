package com.shamiq.microbitwager;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class WagersMain extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wagers_main);

        SharedPreferences settings = getSharedPreferences("DEFAULT", 0);
        String string = settings.getString("balance", "");
        TextView balance = (TextView)findViewById(R.id.balanceWagersTextView);
        balance.setText("Current balance: " + string + " BTC");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_wagers_main, menu);
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

    public void makeWager(View view){
        Intent intent = new Intent(this, NewWager.class);
        startActivity(intent);
    }

    public void pendingWagers(View view){
        Intent intent = new Intent(this, PendingWagers.class);
        startActivity(intent);
    }
}
