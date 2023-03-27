package surprises;

import java.util.ArrayList;
import java.util.Arrays;
import random.RandomNo;

public class FortuneCookie implements ISurprise {

    private String message;

    private static final ArrayList<String> fortuneCookiesSayings = new ArrayList<>(Arrays.asList("You can make your own happiness.",
            "You already know the answer to the questions lingering inside your head.", "Wealth awaits you very soon.",
            "Now is the time to try something new.", "A new voyage will fill your life with untold memories.",
            "You must try, or hate yourself for not trying.", "You will be called in to fulfill a position of high honor",
            "The love of your life is stepping into your planet this summer.", "You will become great if you believe in yourself.",
            "Serious trouble will bypass you.", "Let the deeds speak.", "Fortune favors the brave.",
            "The greatest risk is not taking one.", "Your shoes will make you happy today.", "You will marry your lover.",
            "Keep your eye out for someone special.", "A very attractive person has a message for you.",
            "It is now, and in this world, that we must live.", "Everyone agrees. You are the best.",
            "You will conquer obstacles to achieve success."));


    public FortuneCookie(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return String.format("[FortuneCookie] surprise= %s", message);
    }

    @Override
    public void enjoy() {
        System.out.printf("You got a fortune cookie! %n %s", message);
    }


    // A saying is chosen with the help of a random number
    public static FortuneCookie generate(){
        int surpriseElement = RandomNo.getRandomNumber(fortuneCookiesSayings.size());
        return new FortuneCookie(fortuneCookiesSayings.get(surpriseElement));
    }
}
