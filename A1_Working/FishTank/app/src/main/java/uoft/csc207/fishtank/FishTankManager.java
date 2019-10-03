package uoft.csc207.fishtank;

import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.List;

public class FishTankManager {

    /**
     * All the locations where a fish can be.
     */
    public Object[][] fishTankGrid;
    /**
     * The width of fishTankGrid.
     */
    private static int gridWidth;
    /**
     * The height of fishTankGrid.
     */
    private static int gridHeight;
    /**
     * All items in the fish tank.
     */
    private static List<FishTankItem> fishTankItems;
    /**
     * All Food items in the fish tank.
     */
    public static List<Food> fishTankFoods;

    /**
     * The fish tank manager on a screen with height in rows and width in cols.
     */
    public FishTankManager(int height, int width) {
        gridWidth = width;
        gridHeight = height;
        fishTankGrid = new Object[height][width];
        fishTankItems = new ArrayList<>();
        fishTankFoods = new ArrayList<>();
    }

    public void draw(Canvas canvas) {
        for (FishTankItem item : fishTankItems) {
            item.draw(canvas);
        }
        for (FishTankItem food : fishTankFoods) {
            food.draw(canvas);
        }
        
        // FishTankItem.draw(); //update all from class
        
    }

    public void update() {
        updateFishTankItems();
        updateFishFoods();
        
        // Food.update(); // move or destroy
        // Fish.update(); // move
        // Bubble.update(); // move or destroy
        // FishPoop.update();
        
        // Destructibles.update();
        
        
    }

    public void createTankItems() {

        new Fish(18, 28);
        new Fish(22, 10);
        new Fish(14, 17);
        new Fish(28, 15);
        new Fish(36, 56);
        new Fish(5, 16);
        new Fish(12, 16);
        new Fish(18, 16);
        new Fish(23, 18);

        new HungryFish(20, 10);

        new Seaweed(4, 33, 9);
        new Seaweed(13, 24, 6);
        new Seaweed(15, 42, 12);
        new Seaweed(20, 13, 5);

        for (int i = 0; i < 7; i++) {
            new Food();
        }

    }

    /**
     * Update all the foods in FishTankFoods.  Remove those marked for destroy.
     */
    private void updateFishFoods() {
    
    
        int j = 0;
        while (j < fishTankFoods.size()) {
            if (((Destructible) fishTankFoods.get(j)).toBeDestroyed()) {
                fishTankFoods.remove(j);
                System.out.println("fish food destroyed");
            } else {
                fishTankFoods.get(j).move();
                j++;
            }
        }
        if (fishTankFoods.size() < 5) {
            double d = Math.random();
            if (d < 0.1) {
                new Food();
            }
        }
    }

    /**
     * Update all the items in FishTankItems.  Remove those marked for destroy.
     */
    private void updateFishTankItems() {
        int i = 0;
        while (i < fishTankItems.size()) {
            if (fishTankItems.get(i) instanceof Destructible) {
                if (((Destructible) fishTankItems.get(i)).toBeDestroyed()) {
                    if (fishTankItems.get(i) instanceof Bubble)
                        System.out.println("bubble destroyed");
                    if (fishTankItems.get(i) instanceof FishPoop)
                        System.out.println("poop destroyed");
                    fishTankItems.remove(i);
                } else {
                    fishTankItems.get(i).move();
                    i++;
                }
            } else {
                fishTankItems.get(i).move();
                i++;
            }
        }
    }

    /**
     * Return the width of a row of locations.
     *
     * @return the width of a column of locations.
     */
    public static int getGridWidth() {

        return gridWidth;
    }

    /**
     * Return the height of a column of locations.
     *
     * @return the height of a column of locations.
     */
    public static int getGridHeight() {

        return gridHeight;
    }

    /**
     * Return a random coordinate within the grid
     *
     * @return an int array containing the x coordinate in index 1 and y coordinate in index 2.
     */
    public static int[] getRandomCoord() {
        double randX = Math.random();
        double randY = Math.random();
        int[] randCoord = new int[2];

        randCoord[0] = (int) Math.floor(randX * (gridWidth - 1)) + 1;
        randCoord[1] = (int) Math.floor(randY * (gridHeight - 1) + 1);

        return randCoord;
    }

    /**
     * Add an item to the fishTankItems list
     *
     * @item the item to add to the item list
     */
    public static void addToFishTankItems(FishTankItem item) {
        fishTankItems.add(item);
    }

    /**
     * Add an item to the fishTankFoods list
     *
     * @food the item to add to the food list
     */
    public static void addToFishTankFoods(Food food) {
        fishTankFoods.add(food);
    }
}
