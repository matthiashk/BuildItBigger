package com.udacity.gradle.builditbigger;

import android.test.InstrumentationTestCase;
import android.text.TextUtils;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by matthiasko on 1/5/16.
 */
public class AsyncJokeTaskTest extends InstrumentationTestCase {

    String joke = "";

    public void testString() throws Throwable{

        final CountDownLatch signal = new CountDownLatch(1);

        final MyAsyncTask myAsyncTask = new MyAsyncTask() {

            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);

                joke = result;

                signal.countDown();
            }
        };

        runTestOnUiThread(new Runnable() {
            public void run() {

                myAsyncTask.execute();
            }
        });

        signal.await(30, TimeUnit.SECONDS);

        assertFalse(TextUtils.isEmpty(joke));
    }
}