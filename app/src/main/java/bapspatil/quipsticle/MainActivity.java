package bapspatil.quipsticle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;

import bapspatil.jokeScreen.JokeActivity;
import bapspatil.jokesLib.JokesClass;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> jokesList = new ArrayList<>();
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jokesList.addAll(JokesClass.fetchJokes());
    }

    public void tellJoke(View view) {
        String joke;
        if(count != jokesList.size()) {
            joke = jokesList.get(count);
            count++;
        } else {
            count = 0;
            joke = jokesList.get(count);
            count++;
        }
        Intent jokeIntent = new Intent(this, JokeActivity.class);
        jokeIntent.putExtra(JokeActivity.JOKE_INTENT, joke);
        startActivity(jokeIntent);
    }
}
