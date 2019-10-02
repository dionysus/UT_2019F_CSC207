package uoft.csc207.fishtank;

import android.graphics.Color;

/**
 * A Fish Poop.
 */
public class FishPoop extends FishTankItem implements Destructible {
    /**
     * If this fish poop item needs to be destroyed
     */
    private Boolean destroyItem;

    /**
     * Constructs a new fish poop at the specified cursor location (x, y).
     *
     * @param coordX the starting x coordinate of the bubble
     * @param coordY the starting y coordinate of the bubble
     */
    public FishPoop(int coordX, int coordY) {
        super(coordX, coordY, Color.YELLOW);
        this.setAppearance("|");
        this.destroyItem = false;
    }

    /**
     * Causes the fish poop to fall downwards.
     */
    @Override
    public void move() {
        if (this.getCoordY() >= FishTankManager.getGridHeight() - 1) { // Below Screen
            this.destroyItem();
        } else {
            this.setCoordY(this.getCoordY() + 1); // Move downwards.
        }
    }

    /**
     * Prepare this fish poop to be destroyed
     */
    public void destroyItem() {
        this.destroyItem = true;
    }

    /**
     * Return if this fish poop is to be destroyed.
     */
    public boolean toBeDestroyed() {
        return this.destroyItem;
    }
}