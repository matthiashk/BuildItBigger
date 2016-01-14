package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;

import com.example.Joker;

/**
 * Created by matthiasko on 1/6/16.
 */
public class TestAsyncTask extends AsyncTask<Void, Void, String> {

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
        



    }
}
