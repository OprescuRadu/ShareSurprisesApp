package Containers;

import surprises.ISurprise;

import java.util.Iterator;
import java.util.LinkedList;

public class BagLIFO implements IBag, IPrint{
    private final LinkedList<ISurprise> bagLIFO = new LinkedList<>();

    @Override
    public void put(ISurprise newSurprise) {
        bagLIFO.push(newSurprise);
    }

    @Override
    public void put(IBag bagOfSurprises) {
        while(!bagOfSurprises.isEmpty()){
            bagLIFO.push(bagOfSurprises.takeOut());
        }
    }

    @Override
    public ISurprise takeOut() {
        if(!bagLIFO.isEmpty()){
            return bagLIFO.pop();
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return bagLIFO.isEmpty();
    }

    @Override
    public int size() {
        return bagLIFO.size();
    }

    @Override
    public void print() {
        for (ISurprise iSurprise : bagLIFO) {
            System.out.println(iSurprise);
        }
    }
}
