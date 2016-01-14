package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.example.Joker;
import com.matthiasko.displayjoke.DisplayJoke;

/**
 * Created by matthiasko on 1/6/16.
 */
public class MyAsyncTask extends AsyncTask<Void, Void, String> {

    private Context context;

    public MainActivityFragment.AsyncResponse delegate = null;

    public MyAsyncTask(Context context, MainActivityFragment.AsyncResponse asyncResponse){

        this.context = context;
        delegate = asyncResponse;
    }



    @Override
    protected String doInBackground(Void... params) {


        /*
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
                System.out.println("sleeping...");
            } catch (InterruptedException e) {
                Thread.interrupted();
            }
        }*/


        //String joke = "Why did the chicken cross the road?";

        Joker myJoker = new Joker();

        String joke = myJoker.getJoke();



        return joke;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);

        Intent myIntent = new Intent(context, DisplayJoke.class);

        myIntent.putExtra("aJoke", result);

        context.startActivity(myIntent);

        System.out.println("MyAsyncTask - result = " + result);

        delegate.processFinish();
    }
}
