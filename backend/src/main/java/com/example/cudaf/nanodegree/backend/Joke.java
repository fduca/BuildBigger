package com.example.cudaf.nanodegree.backend;

import com.example.JokeLibrary;

public class Joke {

    private JokeLibrary jokeLibrary;

    public Joke(){
        jokeLibrary = new JokeLibrary();
    }

    public String getJoke(){
        return jokeLibrary.getJoke();
    }
}
