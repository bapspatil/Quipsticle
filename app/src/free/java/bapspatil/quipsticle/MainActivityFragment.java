package bapspatil.quipsticle;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;

import bapspatil.jokeScreen.JokeActivity;

public class MainActivityFragment extends Fragment implements OnJokesReceivedListener {
    private int count = 0;
    private ArrayList<String> jokesList = new ArrayList<>();

    public MainActivityFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        AdView mAdView = root.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);

        Button tellJokeButton = root.findViewById(R.id.tell_joke_button);
        tellJokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tellJoke();
            }
        });

        fetchAllJokes();

        return root;
    }

    private void fetchAllJokes() {
        new EndpointsAsyncTask().execute(this);
    }

    public void tellJoke() {
        String joke;
        if(count != jokesList.size()) {
            joke = jokesList.get(count);
            count++;
        } else {
            count = 0;
            joke = jokesList.get(count);
            count++;
        }
        startJokeActivity(joke);
    }

    private void startJokeActivity(String joke) {
        Intent jokeIntent = new Intent(getActivity(), JokeActivity.class);
        jokeIntent.putExtra(JokeActivity.JOKE_INTENT, joke);
        startActivity(jokeIntent);
    }

    @Override
    public void onJokesReceived(ArrayList<String> jokes) {
        jokesList.addAll(jokes);
    }
}
