package factory;

import containers.BagRandom;
import containers.IBag;

public class BagFactoryOptimizeStorage implements IBagFactory {
    private static BagFactoryOptimizeStorage bag = null;

    public static BagFactoryOptimizeStorage getInstance() {
        if (bag == null) {
            bag = new BagFactoryOptimizeStorage();
        }
        return bag;
    }
    public IBag makeBag(String type) {
        return new BagRandom();
    }
}
