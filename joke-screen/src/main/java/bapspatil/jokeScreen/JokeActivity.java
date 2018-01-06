package bapspatil.jokeScreen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import me.grantland.widget.AutofitTextView;

public class JokeActivity extends AppCompatActivity {

    public final static String JOKE_INTENT = "JOKE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        String joke = getIntent().getStringExtra(JOKE_INTENT);
        AutofitTextView jokeTextView = findViewById(R.id.joke_text_view);
        jokeTextView.setText(joke);
    }
}
