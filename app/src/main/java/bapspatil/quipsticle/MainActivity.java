package bapspatil.quipsticle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

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
        Toast.makeText(this, joke, Toast.LENGTH_LONG).show();
    }
}
