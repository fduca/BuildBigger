package uk.co.nanodegree.androidjokelibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeMainActivity extends AppCompatActivity {

    public static final String INTENT_EXTRA_JOKE = "INTENT_EXTRA_JOKE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_main);
        String joke = getIntent().getStringExtra(INTENT_EXTRA_JOKE);
        TextView jokeText = (TextView) findViewById(R.id.joke_text);
        jokeText.setText(joke);
    }
}
