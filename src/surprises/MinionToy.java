package surprises;

import java.util.ArrayList;
import java.util.Arrays;

public class MinionToy implements ISurprise {

    private final String minionName;
    private static int count = -1;
    private static final ArrayList<String> minionList = new ArrayList<>(Arrays.asList("Dave", "Carl",
            "Kevin", "Stuart", "Jerry", "Tim"));

    public MinionToy(String minionName) {
        this.minionName = minionName;
    }

    @Override
    public String toString() {
        return String.format("[Minion] name = %s!", minionName);
    }

    @Override
    public void enjoy() {
        System.out.printf("Congratulations! You got a minion named %s! ", minionName);
    }

    // The toys are chosen in order
    public static MinionToy generate() {
        count++;
        if (count == 5) {
            count = 0;
        }
        return new MinionToy(minionList.get(count));
    }
}
