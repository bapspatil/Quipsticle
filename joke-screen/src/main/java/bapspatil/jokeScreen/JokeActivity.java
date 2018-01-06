package bapspatil.jokeScreen;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;

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
        Typeface typeface = ResourcesCompat.getFont(this, R.font.varela_round);
        jokeTextView.setTypeface(typeface);
    }
}
