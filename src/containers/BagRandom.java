package containers;

import random.RandomNo;
import surprises.ISurprise;

import java.util.ArrayList;


public class BagRandom implements IBag, IPrint {
    private final ArrayList<ISurprise> bagRandom = new ArrayList<>();

    @Override
    public void put(ISurprise newSurprise) {
        bagRandom.add(newSurprise);
    }

    @Override
    public void put(IBag bagOfSurprises) {
        while(!bagOfSurprises.isEmpty()){
            bagRandom.add(bagOfSurprises.takeOut());
        }
    }

    @Override
    public ISurprise takeOut() {
        if(!bagRandom.isEmpty()) {
            int randomSurprise = RandomNo.getRandomNumber(bagRandom.size());
            ISurprise toTakeOut = bagRandom.get(randomSurprise);
            bagRandom.remove(toTakeOut);
            return toTakeOut;
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return bagRandom.isEmpty();
    }

    @Override
    public int size() {
        return bagRandom.size();
    }

    @Override
    public void print() {
        for (ISurprise iSurprise : bagRandom) {
            System.out.println(iSurprise);
        }
    }
}
