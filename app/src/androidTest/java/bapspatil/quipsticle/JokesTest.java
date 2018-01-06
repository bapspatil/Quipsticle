package bapspatil.quipsticle;

import android.app.Application;
import android.support.test.runner.AndroidJUnit4;
import android.test.ApplicationTestCase;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by bapspatil
 */

@RunWith(AndroidJUnit4.class)
public class JokesTest extends ApplicationTestCase<Application> implements OnJokesReceivedListener {
    private CountDownLatch signal;
    private String joke;

    public JokesTest() {
        super(Application.class);
    }

    @Test
    public void testJoke() {
        try {
            signal = new CountDownLatch(1);
            new EndpointsAsyncTask().execute(this);
            signal.await(10, TimeUnit.SECONDS);
            assertNotNull("Null joke received!", joke);
            assertFalse("Empty joke received!", joke.isEmpty());
        } catch (Exception e) {
            fail();
        }
    }

    @Override
    public void onJokesReceived(String joke) {
        this.joke = joke;
        signal.countDown();
    }
}
