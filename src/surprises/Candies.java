package surprises;

import random.RandomNo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Candies implements ISurprise{

    private String candyType;
    private int number;
    private static final ArrayList<String> candyList = new ArrayList<>(Arrays.asList("chocolate", "jelly",
            "fruits", "vanilla"));
    private static final int maxNumberOfCandies = 100;


    public Candies(String candyType, int number) {
        this(candyType);
        this.number = number;
    }
    public Candies(String candyType){
        this.candyType = candyType;
    }

    @Override
    public String toString() {
        return String.format("[Candies] type = %s, number = %d,", candyType, number);
    }

    @Override
    public void enjoy() {
        System.out.printf("Yummy! You received %d %s candies%n", number, candyType);
    }

    //The type and quantity are random
    public static Candies generate(){
       int type =  RandomNo.getRandomNumber(candyList.size());
       int numberOfCandies = RandomNo.getRandomNumber(maxNumberOfCandies);
       return new Candies(candyList.get(type),numberOfCandies);
    }
}
