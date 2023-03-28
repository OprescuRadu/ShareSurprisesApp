package factory;

import containers.BagFIFO;
import containers.BagLIFO;
import containers.IBag;

public class BagFactoryOptimizeAccess implements IBagFactory{
    private static BagFactoryOptimizeAccess bag = null;

    public static BagFactoryOptimizeAccess getInstance() {
        if (bag == null) {
            bag = new BagFactoryOptimizeAccess();
        }
        return bag;
    }
    @Override
    public IBag makeBag(String type) {
        switch (type.toLowerCase()) {
            case "lifo":
                return new BagLIFO();
            case "fifo":
                return new BagFIFO();
            default:
                System.out.println("Not applicable!");
        }
        return null;
    }
}
