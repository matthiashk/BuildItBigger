package com.example;

import java.util.Random;

public class Joker {

    public String getJoke() {

        // choose a random joke
        Random ran = new Random();
        int x = ran.nextInt(3);

        String[] jokes = new String[3];

        jokes[0] = "What did one computer say to the other? - 010101101010101010101";
        jokes[1] = "Most people believe that if it ain't broke, don't fix it.\n" +
                "Engineers believe that if it ain't broke, it doesn't have enough features yet.";
        jokes[2] = "Why do they call it hyper text? \n" +
                "Too much JAVA.";

        return jokes[x];
    }

    //public void sendJoke() {}
}
