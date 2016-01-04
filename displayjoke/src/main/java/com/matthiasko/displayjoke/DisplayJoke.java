package com.matthiasko.displayjoke;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by matthiasko on 12/31/15.
 */
public class DisplayJoke extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_image);

        Intent intent = getIntent();

        String joke = intent.getStringExtra("aJoke");

        System.out.println("joke = " + joke);

        finish();
    }

    public void launchLibraryActivity(View view){
        Intent myIntent = new Intent(this, DisplayJoke.class);
        startActivity(myIntent);
    }

}
