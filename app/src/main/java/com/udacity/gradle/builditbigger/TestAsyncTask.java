package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;

import com.example.Joker;

/**
 * Created by matthiasko on 1/6/16.
 */
public class TestAsyncTask extends AsyncTask<Void, Void, String> {

    @Override
    protected String doInBackground(Void... params) {

        Joker myJoker = new Joker();

        String joke = myJoker.getJoke();

        return joke;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
    }
}
