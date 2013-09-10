package paulenka.aleh.pm.appletree;

import java.util.Random;

public class AppleTree {

    private final static int LIMIT = 5000;

    private Random random = new Random();

    private int numberOfApples = 0;

    protected Random getRandom() {
        return random;
    }

    public int getNumberOfApples() {
        return numberOfApples;
    }

    protected void setNumberOfApples(int numberOfApples) {
        this.numberOfApples = numberOfApples;
    }

    public int grow() {
        int applesGrown = getRandom().nextInt(LIMIT - getNumberOfApples());
        setNumberOfApples(getNumberOfApples() + applesGrown);

        return applesGrown;
    }

    public int grow(int parseInt) {
        return 0;
    }

    public int shake() {
        int applesFallen = getRandom().nextInt(getNumberOfApples());
        setNumberOfApples(getNumberOfApples() - applesFallen);

        return applesFallen;
    }

    public int shake(int parseInt) {
        return 0;
    }
}
