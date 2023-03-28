package containers;

import surprises.ISurprise;

public interface IBag extends IPrint{

    // Adds a surprise in the bag
    void put(ISurprise newSurprise);

    /* Adds all the surprises from another IBag
       -> the 'bagOfSurprises' will be empty() afterwards */
    void put(IBag bagOfSurprises);

    // Removes a surprise from the bag and returns it
    ISurprise takeOut();

    // Checks if the bag is empty or not
    boolean isEmpty();

    // Returns the number of surprises
    int size();

}

