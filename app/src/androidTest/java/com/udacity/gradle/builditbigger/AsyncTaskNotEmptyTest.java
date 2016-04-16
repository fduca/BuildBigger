package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;
import android.util.Log;

import com.udacity.gradle.builditbigger.async.EndpointGCMAsyncTask;

import java.util.concurrent.ExecutionException;

/**
 * Created by cudaf on 16/04/2016.
 */
public class AsyncTaskNotEmptyTest extends AndroidTestCase{



    public void test(){
        String jokeResult = null;
        EndpointGCMAsyncTask endpointGCMAsyncTask = new EndpointGCMAsyncTask(getContext());
        endpointGCMAsyncTask.execute();
        try{
            jokeResult = endpointGCMAsyncTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        assertNotNull(jokeResult);
    }
}
