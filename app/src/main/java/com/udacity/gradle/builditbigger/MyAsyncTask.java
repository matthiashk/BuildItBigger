package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;

/**
 * Created by matthiasko on 1/6/16.
 */
public class MyAsyncTask extends AsyncTask<Void, Void, String> {


    @Override
    protected String doInBackground(Void... params) {
        String joke = "Why did the chicken cross the road?";

        return joke;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);

        System.out.println("result = " + result);
    }

}
