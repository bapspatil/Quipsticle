package bapspatil.quipsticle;

import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;
import java.util.ArrayList;

import quipsticle.bapspatil.myApi.MyApi;

/**
 * Created by bapspatil
 */

public class EndpointsAsyncTask extends AsyncTask<OnJokesReceivedListener, Void, ArrayList<String>> {
    private MyApi myApi = null;
    private OnJokesReceivedListener listener;
    private ArrayList<String> jokes = new ArrayList<>();

    @Override
    protected ArrayList<String> doInBackground(OnJokesReceivedListener... params) {
        if (myApi == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(false);
                        }
                    });
            myApi = builder.build();
        }
        listener = params[0];
        try {
            return (ArrayList<String>) myApi.tellAJoke(jokes).execute().getMyJokes();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void onPostExecute(ArrayList<String> results) {
        listener.onJokesReceived(results);
    }
}
