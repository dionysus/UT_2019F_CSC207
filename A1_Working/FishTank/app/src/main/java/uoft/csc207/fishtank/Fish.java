package uoft.csc207.fishtank;

import android.graphics.Color;

import java.util.HashMap;

/**
 * A fish.
 */
public class Fish extends FishTankItem {

    /**
     * Indicates whether this fish is moving right.
     */
    private boolean goingRight;
    private String body;
    private String reverseBody;
    private StringBuilder stomach;
    private int stomachCapacity;
    private int foodRadius;

    /**
     * Constructs a new fish.
     *
     * @param coordX the starting x coordinate of the fish
     * @param coordY the starting y coordinate of the fish
     */
    public Fish(int coordX, int coordY) {
        super(coordX, coordY, Color.CYAN);
        this.goingRight = true;
        this.body = "";
        this.reverseBody = "";
        this.stomach = new StringBuilder();
        this.stomachCapacity = 4;
        this.foodRadius = 5;
        updateAppearance();

    }

    /**
     * Causes this item to take its turn in the fish-tank simulation.
     */
    public void move() {

        if (this.stomach.length() >= this.stomachCapacity * 2) {
            moveRandom();
        } else {
            Food target = this.detectFood();
            if (target != null) {
                moveTowards(target.getCoordX(), target.getCoordY());
            } else {
                moveRandom();
            }
        }

        if (stomach.length() > 1) {
            double d = Math.random();
            if (d < 0.01) {
                poop();
            }
        }

        // Figure out whether I blow a bubble.
        double d = Math.random();
        if (d < 0.1) {
            blowBubble();
        }
    }

    /**
     * Turns this fish around, causing it to reverse direction.
     */
    private void turnAround() {
        this.goingRight = !this.goingRight;
        if (this instanceof HungryFish)
            System.out.println("Turning around " + this.getAppearance());
        this.updateAppearance();
        if (this instanceof HungryFish)
            System.out.println("Turned around " + this.getAppearance());
    }

    /**
     * Makes this fish move randomly within the walls of the tank.
     */
    private void moveRandom() {
        // Figure out whether I turn around.

        if (this.getHeadPos()[0] >= FishTankManager.getGridWidth() - 1 ||
                this.getCoordX() <= 0) {
            turnAround();
        } else {
            double d = Math.random();
            if (d < 0.1) {
                turnAround();
            }
        }

        // Move one spot to the right or left in the direction I'm going. If I bump into a wall,
        // turn around.

        if (goingRight) {
            this.setCoordX(this.getCoordX() + 1);
        } else {
            this.setCoordX(this.getCoordX() - 1);
        }

        // Figure out whether to move up or down, or neither.
        double d = Math.random();
        if (d < 0.1 && this.getCoordY() < FishTankManager.getGridHeight() - 4) {
            this.setCoordY(this.getCoordY() + 1);
        } else if (d < 0.2 && this.getCoordY() > 1) {
            this.setCoordY(this.getCoordY() - 1);
        }
    }

    /**
     * Makes this fish move towards a target x and y coordinate.
     *
     * @param targetX target x coordinate
     * @param targetY target y coordinate
     */
    private void moveTowards(int targetX, int targetY) {
        // Move one spot to the right or left in the direction I'm going. If I bump into a wall,
        // turn around.

        if ((this.getHeadPos()[0] > targetX && this.goingRight) ||
                (this.getHeadPos()[0] < targetX && !this.goingRight)) {
            this.turnAround();
        }

        if (Math.abs(this.getHeadPos()[0] - targetX) > 1) {
            if (goingRight) {
                this.setCoordX(this.getCoordX() + 1);
            } else {
                this.setCoordX(this.getCoordX() - 1);
            }
        }

        if (this.getCoordY() > targetY) {
            this.setCoordY(this.getCoordY() - 1);
        } else if (this.getCoordY() < targetY) {
            // Figure out whether to move up or down, or neither.
            this.setCoordY(this.getCoordY() + 1);
        }
    }

    /**
     * Causes this fish to blow a bubble.
     */
    private void blowBubble() {
        int[] headPos = getHeadPos();
        FishTankManager.addToFishTankItems(new Bubble(headPos[0], headPos[1]));
        System.out.println(headPos[0] + " " + headPos[1]);
    }

    /**
     * Update this Fish's appearance
     */
    public void updateAppearance() {
        if (this.goingRight) {
            this.setAppearance("><" + stomach + body + ">");
        } else {
            this.setAppearance("<" + reverseBody + stomach + "><");
        }
    }

    /**
     * Return the reversed string.
     *
     * @param s the string to reverse
     * @return the string in reverse
     */
    public String reverseString(String s) {

        if (s == null) return "";

        HashMap<Character, Character> reverseMap = new HashMap<>();
        // Add keys and values (char, reversed char)
        reverseMap.put(')', '(');
        reverseMap.put('(', ')');
        reverseMap.put('>', '<');
        reverseMap.put('<', '>');
        reverseMap.put('}', '{');
        reverseMap.put('{', '}');
        reverseMap.put(']', '[');
        reverseMap.put('[', ']');

        StringBuilder reverse = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (reverseMap.containsKey(s.charAt(i))) {
                reverse.append(reverseMap.get(s.charAt(i)));
            } else {
                reverse.append(s.charAt(i));
            }
        }
        return reverse.toString();
    }

    /**
     * Set the body of the Fish and update the forward and backward appearance
     *
     * @param body the new body of the fish
     */
    public void setBody(String body) {
        this.body = body;
        this.updateAppearance();
        this.reverseBody = reverseString(body);
    }

    /**
     * Returns the closest food item within the the foodRadius of detection
     *
     * @return the closest food item, or null if none are close
     */
    private Food detectFood() {
        Food closestFood = null;
        double closestDistance = 999999;

        for (Food food : FishTankManager.fishTankFoods) {
            if (!food.toBeDestroyed()) {
                double distanceFromFood = food.distanceFrom(this);
                if (distanceFromFood <= this.foodRadius && distanceFromFood < closestDistance) {
                    closestFood = food;
                }
                if ((this.goingRight) &&
                        (food.getCoordX() <= this.getHeadPos()[0] + 1) &&
                        (food.getCoordX() >= this.getCoordX() - 1) &&
                        (food.getCoordY() == this.getCoordY())) {
                    this.eatFood(food);
                }
                if ((!this.goingRight) &&
                        (food.getCoordX() <= this.getCoordX() + 1) &&
                        (food.getCoordX() >= this.getHeadPos()[0] - 1) &&
                        (food.getCoordY() == this.getCoordY())) {
                    this.eatFood(food);
                }
            }
        }
        return closestFood;
    }

    /**
     * Return the xy coordinates of the head.
     *
     * @return an int array with x coordinate in the first index and y in the second index
     */
    public int[] getHeadPos() {
        int[] pos = new int[2];
        if (!goingRight) {
            pos[0] = this.getCoordX();
        } else {
            pos[0] = this.getCoordX() + this.getAppearanceLength();
        }
        pos[1] = this.getCoordY();

        return pos;
    }

    /**
     * Causes the Fish to eat the Food item
     *
     * @param food the food item to be eaten
     */
    public void eatFood(Food food) {
        food.destroyItem();
        this.growStomach();
    }

    /**
     * Causes the Fish to poop its stomach contents
     */
    public void poop() {
        shrinkStomach();
        FishTankManager.addToFishTankItems(new FishPoop(this.getCoordX(), this.getCoordY()));
    }

    /**
     * Causes the Fish to grow longer
     */
    public void growStomach() {
        this.stomach.append("::");
        updateAppearance();
    }

    /**
     * Causes the Fish to grow shorter
     */
    public void shrinkStomach() {
        this.stomach.setLength(stomach.length() - 2);
        updateAppearance();
    }

    /**
     * Change the foodRadius for detecting food
     *
     * @param radius int representing the new foodRadius
     */
    public void setFoodRadius(int radius) {
        this.foodRadius = radius;
    }
}