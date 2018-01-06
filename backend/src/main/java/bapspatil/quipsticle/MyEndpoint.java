/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package bapspatil.quipsticle;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import java.util.ArrayList;

import javax.inject.Named;

import bapspatil.jokesLib.JokesClass;

@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "bapspatil.quipsticle",
                ownerName = "bapspatil.quipsticle",
                packagePath = ""
        )
)
public class MyEndpoint {

    /**
     * A simple endpoint method that takes a name and says Hi back
     */
    @ApiMethod(name = "sayHi")
    public MyBean sayHi(@Named("name") String name) {
        MyBean response = new MyBean();
        response.setData("Hi, " + name);
        return response;
    }

    @ApiMethod(name = "tellAJoke")
    public MyBean tellAJoke(@Named("jokes") ArrayList<String> jokes) {
        MyBean response = new MyBean();
        jokes.addAll(JokesClass.fetchJokes());
        response.setMyJokes(jokes);
        return response;
    }

}
