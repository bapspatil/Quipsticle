package bapspatil.quipsticle;

import android.app.Application;
import android.support.test.runner.AndroidJUnit4;
import android.test.ApplicationTestCase;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by bapspatil
 */

@RunWith(AndroidJUnit4.class)
public class JokesTest extends ApplicationTestCase<Application> implements OnJokesReceivedListener {
    private CountDownLatch signal;
    private ArrayList<String> jokes = new ArrayList<>();

    public JokesTest() {
        super(Application.class);
    }

    @Test
    public void testJoke() {
        try {
            signal = new CountDownLatch(1);
            new EndpointsAsyncTask().execute(this);
            signal.await(10, TimeUnit.SECONDS);
            assertNotNull("Null list of jokes received!", jokes);
            assertFalse("Empty list of jokes received!", jokes.isEmpty());
        } catch (Exception e) {
            fail();
        }
    }

    @Override
    public void onJokesReceived(ArrayList<String> jokes) {
        this.jokes = jokes;
        signal.countDown();
    }
}
