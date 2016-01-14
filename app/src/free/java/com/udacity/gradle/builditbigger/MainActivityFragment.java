package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    InterstitialAd mInterstitialAd;
    private ProgressBar spinner;
    public static int JOKE_RESULT = 10;

    public MainActivityFragment() {
    }

    public interface AsyncResponse {
        void processFinish();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        spinner = (ProgressBar) root.findViewById(R.id.progressBar1);

        spinner.setVisibility(View.GONE);

        /*
        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);

        */



        mInterstitialAd = new InterstitialAd(getContext());
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitial();
                //beginPlayingGame();

                spinner.setVisibility(View.VISIBLE);

                MyAsyncTask myAsyncTask = new MyAsyncTask(getContext(), new AsyncResponse() {
                    @Override
                    public void processFinish() {

                        System.out.println("PROCESSFINISH");

                        spinner.setVisibility(View.GONE);
                    }
                });




                myAsyncTask.execute();

                //spinner.setVisibility(View.GONE);

                /*
                Joker myJoker = new Joker();

                String joke = myJoker.getJoke();

                Intent myIntent = new Intent(getContext(), DisplayJoke.class);

                myIntent.putExtra("aJoke", joke);

                startActivityForResult(myIntent, JOKE_RESULT);
                */
            }
        });

        requestNewInterstitial();

        Button button = (Button) root.findViewById(R.id.mybutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //System.out.println("LOADING INTERSTITIAL");

                if (mInterstitialAd.isLoaded()) {

                    //System.out.println("AD IS LOADED");
                    mInterstitialAd.show();
                } else {
                    //System.out.println("AD IS NOT LOADED");
                    //beginPlayingGame();
                }

            }
        });



        return root;
    }

    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();

        mInterstitialAd.loadAd(adRequest);
    }

    /*
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        spinner.setVisibility(View.GONE);

        super.onActivityResult(requestCode, resultCode, data);


    }

    */

}
