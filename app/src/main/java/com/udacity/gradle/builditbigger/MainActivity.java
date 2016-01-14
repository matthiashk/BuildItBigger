package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.Joker;
import com.matthiasko.displayjoke.DisplayJoke;


public class MainActivity extends ActionBarActivity {

    String joke = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new EndpointsAsyncTask().execute(new Pair<Context, String>(this, "Manfred"));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void tellJoke(View view){

        Joker myJoker = new Joker();

        Toast.makeText(this, myJoker.getJoke(), Toast.LENGTH_SHORT).show();
    }

    public void launchLibraryActivity(View view){

        // TODO: change to use myasynctask...


        TestAsyncTask testAsyncTask = new TestAsyncTask() {

            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);

                joke = result;

                Intent myIntent = new Intent(getApplicationContext(), DisplayJoke.class);

                myIntent.putExtra("aJoke", joke);

                startActivity(myIntent);
                //signal.countDown();
            }
        };

        testAsyncTask.execute();

        /*
        Joker myJoker = new Joker();

        String joke = myJoker.getJoke();

        Intent myIntent = new Intent(this, DisplayJoke.class);

        myIntent.putExtra("aJoke", joke);


        startActivity(myIntent);
        */
    }

    public void sendJoke() {
        //Joker myJoker = new Joker();


    }




}
