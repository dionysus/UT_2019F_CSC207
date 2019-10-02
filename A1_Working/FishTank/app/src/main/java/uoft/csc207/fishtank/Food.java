package uoft.csc207.fishtank;

import android.graphics.Color;

import java.util.List;

public class Food extends FishTankItem implements Destructible {
    /**
     * If this food item needs to be destroyed
     */
    private boolean destroyItem;
    /**
     * The life left of the food before it is automatically destroyed.
     */
    private int life;

    private static List<Food> Foods;

    /**
     * Constructs a new Food at the specified cursor location (x, y).
     *
     * @param coordX the starting x coordinate of the Food
     * @param coordY the starting y coordinate of the Food
     */
    public Food(int coordX, int coordY) {
        super(coordX, coordY, Color.RED);
        this.setAppearance("\uD80C\uDD99");
        this.destroyItem = false;
        this.life = 20 + (int) Math.round(Math.random() * 30);
        Foods.add(this);
    }

    /**
     * Constructs a new Food at a random location on the screen.
     */
    public Food() {
        this(FishTankManager.getRandomCoord()[0], FishTankManager.getRandomCoord()[1]);
    }

    /**
     * Add this food item to the FishTankFood collection list.
     */
    @Override
    public void addToFishTankManager() {
        FishTankManager.addToFishTankFoods(this);
    }

    /**
     * Determine if the food item wiggles, or reached end of life.
     */
    @Override
    public void move() {
        if (--this.life <= 0) {
            this.destroyItem();
        } else {
            changeAppearance();
        }
    }

    /**
     * Make the food wiggle randomly.
     */
    public void changeAppearance() {
        double d = Math.random();
        if (d < 0.2) {
            this.setAppearance("\uD80C\uDD9A");
        } else if (d < 0.4) {
            this.setAppearance("\uD80C\uDD99");
        } else if (d < 0.6) {
            this.setAppearance("\uD80C\uDD91");
        }
    }

    /**
     * Return the distance of input Fish from this food.
     *
     * @return double representing the distance
     */
    public double distanceFrom(Fish fish) {
        return (Math.sqrt(
                Math.pow(fish.getHeadPos()[0] - this.getCoordX(), 2)
                        + Math.pow(fish.getHeadPos()[1] - this.getCoordY(), 2)));
    }

    /**
     * Prepare this food item to be destroyed
     */
    public void destroyItem() {
        this.setAppearance("\uD80C\uDCCB");
        this.destroyItem = true;
        FishTankManager.addToFishTankItems(new Bubble(this.getCoordX(), this.getCoordY()));
    }

    /**
     * Return if this food is to be destroyed.
     */
    public boolean toBeDestroyed() {
        return this.destroyItem;
    }

}
