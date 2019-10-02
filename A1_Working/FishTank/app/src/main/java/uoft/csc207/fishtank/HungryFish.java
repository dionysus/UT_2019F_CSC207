package uoft.csc207.fishtank;

public class HungryFish extends Fish {

    /**
     * Constructs a new hungry fish at a specific location.
     *
     * @param coordX the starting x coordinate of the fish
     * @param coordY the starting y coordinate of the fish
     */
    public HungryFish(int coordX, int coordY) {
        super(coordX, coordY);
        this.setBody("MEHUNGRY");
        this.setFoodRadius(10);
    }

    /**
     * Causes the HungryFish to eat the food
     */
    @Override
    public void eatFood(Food food) {
        food.destroyItem();
    }

}
