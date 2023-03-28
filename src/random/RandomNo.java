package random;

import java.util.Random;

public  class RandomNo {
    private static final Random random = new Random();

    // Helper method
    public static int getRandomNumber(int max){
        return random.nextInt(max);
    }
}
