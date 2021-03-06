package bapspatil.quipsticle;

import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

import quipsticle.bapspatil.myApi.MyApi;

/**
 * Created by bapspatil
 */

public class EndpointsAsyncTask extends AsyncTask<OnJokesReceivedListener, Void, String> {
    private MyApi myApi = null;
    private OnJokesReceivedListener listener;

    @Override
    protected String doInBackground(OnJokesReceivedListener... params) {
        if (myApi == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("https://bapspatil-android-nanodegree.appspot.com/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            myApi = builder.build();
        }
        listener = params[0];
        try {
            return myApi.sayHi("Joke").execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String results) {
        listener.onJokesReceived(results);
    }
}
