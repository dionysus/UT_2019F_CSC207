package uoft.csc207.fishtank;

import android.graphics.Canvas;
import android.graphics.Color;

public class Seaweed extends FishTankItem {
    /**
     * The number of weed segments.
     */
    private int numSegments;

    /**
     * Indicates whether the bottom segment is leaning right.
     */
    private boolean leanRight;

    /**
     * Constructs a new seaweed item at a specified location
     *
     * @param coordX      the starting x coordinate of the seaweed
     * @param coordY      the starting y coordinate of the seaweed
     * @param numSegments the number of segments this seaweed is tall.
     */
    public Seaweed(int coordX, int coordY, int numSegments) {
        super(coordX, coordY, Color.GREEN);
        this.numSegments = numSegments;
    }

    /**
     * Draws this Seaweed item.
     *
     * @param canvas the graphics context in which to draw this item.
     */
    @Override
    public void draw(Canvas canvas) {

        for (int i = 0; i < numSegments; i++) {
            // Draw a "/" seaweed segment: even numbered and leaning to the right.
            if ((i % 2 == 0 && this.leanRight) || (i % 2 == 1 && !this.leanRight)) {
                drawString(canvas, "/", this.getCoordX(), -i + this.getCoordY());
            } else {
                drawString(canvas, "\\", this.getCoordX(), -i + this.getCoordY());
            }
        }
    }

    /**
     * Causes this Seaweed to move
     */
    public void move() {
        leanRight = !leanRight;
    }
}