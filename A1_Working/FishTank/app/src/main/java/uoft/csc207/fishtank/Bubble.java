package uoft.csc207.fishtank;

import android.graphics.Color;

/**
 * A bubble.
 */
public class Bubble extends FishTankItem implements Destructible {
    /**
     * If this bubble item needs to be destroyed
     */
    private Boolean destroyItem;
    
    public static List<Destructible> collector;

    /**
     * Constructs a new bubble at the specified cursor location (x, y).
     *
     * @param coordX the starting x coordinate of the bubble
     * @param coordY the starting y coordinate of the bubble
     */
    public Bubble(int coordX, int coordY) {
        super(coordX, coordY, Color.LTGRAY);
        this.setAppearance(".");
        this.destroyItem = false;
        collector.append(this);
    }

    /**
     * Causes the bubble to move, or be destroyed when it reaches the top of the screen.
     */
    @Override
    public void move() {
        if (this.getCoordY() <= 0) { // Above Screen
            this.destroyItem();
        } else {
            moveRandom();
            bubbleChange();
        }
    }

    /**
     * Causes the bubble to float upwards, with a random horizontal shift.
     */
    private void moveRandom() {
        double d = Math.random();
        int a = 0;
        if (d < 0.33) a = 1;
        else if (d < 0.66) a = -1;
        this.setCoordX(this.getCoordX() + a); // Move horizontal.
        this.setCoordY(this.getCoordY() - 1); // Move upwards.
    }

    /**
     * Causes the bubble to randomly change size.
     */
    private void bubbleChange() {
        // Figure out whether to grow, if at all.
        double d = Math.random();
        // Occasionally change a . to a o or a o to a O
        if (d < 0.05) {
            // If the appearance is a ., change it to an o
            if (this.getAppearance().equals("."))
                this.setAppearance("o");
                // If the appearance is an o, change it to a O
            else if (this.getAppearance().equals("o"))
                this.setAppearance("O");
        }
    }

    /**
     * Prepare this bubble to be destroyed
     */
    public void destroyItem() {
        this.destroyItem = true;
    }

    /**
     * Return if this bubble is to be destroyed.
     */
    public boolean toBeDestroyed() {
        return this.destroyItem;
    }
    
    public List<Destructible> getCollector(){
        return this.collector();
    }

}
