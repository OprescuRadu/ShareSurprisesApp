package testing;

import Containers.BagFIFO;
import Containers.BagLIFO;
import Containers.BagRandom;
import Containers.IBag;
import Factory.BagFactoryOptimizeAccess;
import giveSurprises.GiveSurpriseAndApplause;
import giveSurprises.GiveSurpriseAndHug;
import giveSurprises.GiveSurpriseAndSing;
import surprises.GatherSurprises;

public class Main {
    public static void main(String[] args) {
        System.out.println("------------Container testing--------------");
        IBag firstBag = new BagFIFO();
        IBag secondBag = new BagLIFO();
        IBag thirdBag = new BagRandom();
        firstBag.put(GatherSurprises.gather());
        firstBag.put(GatherSurprises.gather());
        firstBag.put(GatherSurprises.gather());
        System.out.println("The surprises in the first bag: ");
        firstBag.print();
        System.out.println();
        System.out.println("FIFO removing:");
        System.out.println(firstBag.takeOut());
        for (int i = 0; i < 3; i++) {
            secondBag.put(GatherSurprises.gather());
        }
        System.out.println("The surprises in the second bag: ");
        secondBag.print();
        System.out.println();
        secondBag.put(firstBag);
        System.out.println("The surprises in the second bag after adding from the first bag:");
        secondBag.print();
        System.out.println();
        System.out.println("Bag 1 size should be 0: " + (firstBag.size() == 0));
        System.out.println();
        System.out.println("LIFO removing:");
        for (int i = 0; i < 2; i++) {
            System.out.println(secondBag.takeOut());
        }
        System.out.println();
        for (int i = 0; i < 3; i++) {
            thirdBag.put(GatherSurprises.gather());
        }
        System.out.println("The surprise of the third bag:");
        thirdBag.print();
        System.out.println();
        System.out.println("Random remove");
        System.out.println(thirdBag.takeOut());
        System.out.println();

        System.out.println("----------Sharing surprises testing--------");
        System.out.println();
        BagFactoryOptimizeAccess bagFactory = new BagFactoryOptimizeAccess();
        GiveSurpriseAndApplause first = new GiveSurpriseAndApplause("FIFO", 1);
        GiveSurpriseAndHug second = new GiveSurpriseAndHug("LIFO", 1);
        GiveSurpriseAndSing third = new GiveSurpriseAndSing("Random", 1);
        first.put(GatherSurprises.gather(4));
        System.out.println("First surprises and applaud:");
        first.print();
        System.out.println();
        first.giveAll();
        System.out.println();
        System.out.println("Second surprises and give hugs:");
        second.put(GatherSurprises.gather());
        second.put(GatherSurprises.gather());
        second.print();
        System.out.println();
        second.give();
        second.give();
        System.out.println();
        System.out.println("Third surprises and sing (give random): ");
        third.put(GatherSurprises.gather(4));
        third.print();
        System.out.println();
        third.giveAll();
        System.out.println();
        System.out.println("---------------End of testing------------");
    }
}
