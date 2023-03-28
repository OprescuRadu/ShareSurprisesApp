package giveSurprises;

import Containers.IPrint;

public class GiveSurpriseAndApplause extends AbstractGiveSurprises {
    public GiveSurpriseAndApplause(String containerType, int waitTime) {
        super(containerType, waitTime);
    }

    @Override
    void giveWithPassion() {
        System.out.println("Loud applause to you… For it is in giving that we receive.");
    }
}
