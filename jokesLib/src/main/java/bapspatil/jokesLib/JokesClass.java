package bapspatil.jokesLib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class JokesClass {
    private static Random random = new Random();

    private static ArrayList<String> jokes = new ArrayList<>(Arrays.asList(
            "A lot of people cry when they cut onions. The trick is not to form an emotional bond.",
            "Don't you hate it when someone answers their own questions? I do.",
            "People used to laugh at me when I would say \"I want to be a comedian\", well nobody's laughing now.",
            "You take away the looks, money, intelligence, charm and success and, really, there's no real difference between me and George Clooney.",
            "When I told the doctor about my loss of memory, he made me pay in advance.",
            "I'm not saying your perfume is too strong. I'm just saying the canary was alive before you got here."
    ));

    public static ArrayList<String> fetchJokes() {
        Collections.shuffle(jokes);
        return jokes;
    }
}
