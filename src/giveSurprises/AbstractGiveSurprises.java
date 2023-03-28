package giveSurprises;

import Containers.IBag;
import Containers.IPrint;
import Factory.BagFactoryOptimizeStorage;
import Factory.BagFactoryOptimizeAccess;
import Factory.IBagFactory;
import surprises.ISurprise;
import surprises.GatherSurprises;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;

public abstract class AbstractGiveSurprises {
    private final IBag bag;

    // Seconds until next surprise is shown
    private final int waitTime;
    private IPrint print;

    public AbstractGiveSurprises(String containerType, int waitTime) {
        this.bag = bagFactoryInstance(containerType).makeBag(containerType);
        this.waitTime = waitTime;
    }

    // Access/Storage option
    public  IBagFactory bagFactoryInstance(String containerType){
       containerType = containerType.toLowerCase();
        if(containerType.equals("fifo") || containerType.equals("lifo")){
            return BagFactoryOptimizeAccess.getInstance();
        }
        if(containerType.equals("random")) {
            return BagFactoryOptimizeStorage.getInstance();
        }
        return null;
    }

    // Adds multiple surprises
    public void put(List<ISurprise> newSurprise){
        for (ISurprise iSurprise : newSurprise) {
            this.bag.put(iSurprise);
        }
    }
    // Adds one new surprise
    public void put(ISurprise newSurprise){
        this.bag.put(newSurprise);
    }

    //  Moves all surprises from container
    public void put(IBag surprises){
        this.bag.put(surprises);
    }

    // Shares one surprise according to container specifications
    public void give(){
        if(!bag.isEmpty()) {
            this.bag.takeOut().enjoy();
            giveWithPassion();
        }
    }

    // Shares all surprises
    public void giveAll(){
        while(!bag.isEmpty()){
            give();
            // Sleep for X seconds - code snippet
            try {
                TimeUnit.SECONDS.sleep(waitTime); // number of seconds to sleep
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    public boolean isEmpty(){
        return bag.isEmpty();
    }

    abstract void giveWithPassion();

    public void print() {
        this.bag.print();
    }
}
