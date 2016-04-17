package com.udacity.gradle.builditbigger.async;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Pair;
import android.view.View;
import android.widget.ProgressBar;

import com.example.cudaf.nanodegree.backend.jokeApi.JokeApi;
import com.example.cudaf.nanodegree.backend.jokeApi.model.Joke;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.R;

import java.io.IOException;

import uk.co.nanodegree.androidjokelibrary.JokeMainActivity;

/**
 * Created by cudaf on 16/04/2016.
 */
public class EndpointGCMAsyncTask  extends AsyncTask<Pair<Context, String>, Void, String> {

    private Context mContext;
    private static JokeApi mJokeApi = null;
    private String mJoke;
    private ProgressBar mProgressBar;


    public EndpointGCMAsyncTask(Context context, ProgressBar progressBar){
        mContext = context;

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if (mProgressBar != null){
            mProgressBar.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected String doInBackground(Pair<Context, String>... params) {
        if(mJokeApi == null) {  // Only do this once
            JokeApi.Builder builder = new JokeApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl(mContext.getResources().getString(R.string.app_engine_url))
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            mJokeApi = builder.build();
        }

        try {
            return mJokeApi.generateJoke(new Joke()).execute().getJoke();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if (mProgressBar != null){
            mProgressBar.setVisibility(View.GONE);
        }
        mJoke = s;
        startJokeMainActivity();
    }

    private void startJokeMainActivity() {
        Intent intent = new Intent(mContext, JokeMainActivity.class);
        intent.putExtra(JokeMainActivity.INTENT_EXTRA_JOKE, mJoke);
        mContext.startActivity(intent);
    }
}
