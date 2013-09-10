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
        int applesGrown = getRandom().nextInt(Math.min(getNumberOfFlowers() + 1, LIMIT - getNumberOfApples() + 1));
        setNumberOfApples(getNumberOfApples() + applesGrown);
        setNumberOfFlowers(getNumberOfFlowers() - applesGrown);

        return applesGrown;
    }

    public int grow(int days) {
        int applesGrown = 0;
        for (int i = 0; i < days; ++i) {
            applesGrown += grow();
        }
        return applesGrown;
    }

    public int shake() {
        int applesFallen = getRandom().nextInt(getNumberOfApples() + 1);
        setNumberOfApples(getNumberOfApples() - applesFallen);

        return applesFallen;
    }

    public int shake(int seconds) {
        int applesFallen = 0;
        for (int i = 0; i < seconds; ++i) {
            applesFallen += shake();
        }
        return applesFallen;
    }

    public int blossom() {
        int flowersGrown = getRandom().nextInt(LIMIT - getNumberOfFlowers() + 1);
        setNumberOfFlowers(getNumberOfFlowers() + flowersGrown);

        return flowersGrown;
    }

    public int blossom(int days) {
        int flowersGrown = 0;
        for (int i = 0; i < days; ++i) {
            flowersGrown += blossom();
        }
        return flowersGrown;
    }
}
