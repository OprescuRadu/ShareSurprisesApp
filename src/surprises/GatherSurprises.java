package surprises;

import Containers.IBag;
import random.RandomNo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public final class GatherSurprises {

   // No need to be created
    private GatherSurprises(){
    }

    // Generates one random surprise
    public static ISurprise gather() {
        int randomNo = RandomNo.getRandomNumber(Integer.MAX_VALUE);
        int n = randomNo % 3;
        return switch (n) {
            case 0 -> FortuneCookie.generate();
            case 1 -> Candies.generate();
            case 2 -> MinionToy.generate();
            default -> null;
        };
    }

    // Generates n random surprises
    public static List<ISurprise> gather(int n){
        List<ISurprise> surprise = new ArrayList<>();
        for (int i = 0 ; i < n ; i++){
            surprise.add(gather());
        }
        return surprise;
    }
}
