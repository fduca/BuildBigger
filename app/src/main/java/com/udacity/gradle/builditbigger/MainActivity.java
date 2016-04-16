package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.JokeLibrary;

import uk.co.nanodegree.androidjokelibrary.JokeMainActivity;


public class MainActivity extends AppCompatActivity {

    //This part is for Step 1: Create a Java library
    private JokeLibrary jokeLibrary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jokeLibrary = new JokeLibrary();
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
        // This is the implementation for Step 1
        // Toast.makeText(this, jokeLibrary.getJoke(), Toast.LENGTH_SHORT).show();
        String joke = jokeLibrary.getJoke();
        Intent intent = new Intent(this, JokeMainActivity.class);
        intent.putExtra(JokeMainActivity.INTENT_EXTRA_JOKE, joke);
        startActivity(intent);
    }


}
