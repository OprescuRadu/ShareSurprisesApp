package Containers;

import surprises.ISurprise;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BagFIFO implements IBag, IPrint {
    private final LinkedList<ISurprise> bagFIFO = new LinkedList<>();

    @Override
    public void put(ISurprise newSurprise) {
        bagFIFO.offer(newSurprise);
    }

    @Override
    public void put(IBag bagOfSurprises) {
        BagFIFO anotherIBag = (BagFIFO) bagOfSurprises;
        bagFIFO.addAll(anotherIBag.bagFIFO);
    }

    @Override
    public ISurprise takeOut() {
        if(!bagFIFO.isEmpty()) {
            return bagFIFO.poll();
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return bagFIFO.isEmpty();
    }

    @Override
    public int size() {
        return bagFIFO.size();
    }

    @Override
    public void print() {
        Iterator<ISurprise> it = bagFIFO.listIterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
