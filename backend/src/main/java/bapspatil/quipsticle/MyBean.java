package bapspatil.quipsticle;

import java.util.ArrayList;

/** The object model for the data we are sending through endpoints */
public class MyBean {

    private ArrayList<String> myJokes;
    private String myData;

    public String getData() {
        return myData;
    }

    public void setData(String myData) {
        this.myData = myData;
    }

    public ArrayList<String> getMyJokes() {
        return myJokes;
    }

    public void setMyJokes(ArrayList<String> myJokes) {
        this.myJokes = myJokes;
    }
}