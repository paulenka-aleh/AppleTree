package paulenka.aleh.pm.appletree;

import java.util.Random;

public class AppleTree {

    private final static int LIMIT = 5000;

    private Random random = new Random();

    private int numberOfApples = 0;
    private int numberOfFlowers = 0;

    protected Random getRandom() {
        return random;
    }

    public int getNumberOfApples() {
        return numberOfApples;
    }

    protected void setNumberOfApples(int numberOfApples) {
        this.numberOfApples = numberOfApples;
    }

    public int getNumberOfFlowers() {
        return numberOfFlowers;
    }

    protected void setNumberOfFlowers(int numberOfFlowers) {
        this.numberOfFlowers = numberOfFlowers;
    }

    public int grow() {
        if (getNumberOfApples() < LIMIT && getNumberOfFlowers() > 0) {
            int applesGrown = getRandom().nextInt(Math.min(getNumberOfFlowers(), LIMIT - getNumberOfApples()));
            setNumberOfApples(getNumberOfApples() + applesGrown);

            return applesGrown;
        } else {
            return 0;
        }
    }

    public int grow(int days) {
        int applesGrown = 0;
        for (int i = 0; i < days; ++i) {
            applesGrown += grow();
        }
        return applesGrown;
    }

    public int shake() {
        if (getNumberOfApples() > 0) {
            int applesFallen = getRandom().nextInt(getNumberOfApples());
            setNumberOfApples(getNumberOfApples() - applesFallen);

            return applesFallen;
        } else {
            return 0;
        }
    }

    public int shake(int seconds) {
        int applesFallen = 0;
        for (int i = 0; i < seconds; ++i) {
            applesFallen += shake();
        }
        return applesFallen;
    }

    public int blossom() {
        if (getNumberOfFlowers() < LIMIT) {
            int flowersGrown = getRandom().nextInt(LIMIT - getNumberOfFlowers());
            setNumberOfFlowers(getNumberOfFlowers() + flowersGrown);

            return flowersGrown;
        } else {
            return 0;
        }
    }

    public int blossom(int days) {
        int flowersGrown = 0;
        for (int i = 0; i < days; ++i) {
            flowersGrown += blossom();
        }
        return flowersGrown;
    }
}
