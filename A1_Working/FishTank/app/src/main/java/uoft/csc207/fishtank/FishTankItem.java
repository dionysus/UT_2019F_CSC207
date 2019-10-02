package uoft.csc207.fishtank;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;

public abstract class FishTankItem {
    /**
     * This item's x coordinate.
     */
    private int coordX;
    /**
     * This item's y coordinate.
     */
    private int coordY;
    /**
     * How this fish appears on the screen.
     */
    private String appearance;
    /**
     * The item's appearance style.
     */
    private Paint paintText = new Paint();

    /**
     * Constructs a new fish.
     *
     * @param coordX the starting x coordinate of the fish
     * @param coordY the starting y coordinate of the fish
     * @param colour the color to draw this item.
     */
    public FishTankItem(int coordX, int coordY, int colour) {
        this.paintText.setTextSize(36);
        this.paintText.setColor(colour);
        this.paintText.setTypeface(Typeface.DEFAULT_BOLD);

        if (coordX < 0) coordX = 0;
        if (coordX > FishTankManager.getGridWidth())
            coordX = FishTankManager.getGridWidth() - 5;
        if (coordY < 0) coordY = 0;
        if (coordY > FishTankManager.getGridHeight())
            coordY = FishTankManager.getGridHeight() - 5;

        this.coordX = coordX;
        this.coordY = coordY;
        this.appearance = "";

        addToFishTankManager();
    }

    /**
     * Add this item to the FishTankManager collection list.
     */
    public void addToFishTankManager() {
        FishTankManager.addToFishTankItems(this);
    }

    /**
     * Draws this fish tank item.
     *
     * @param canvas the canvas on which to draw this item.
     */
    public void draw(Canvas canvas) {
        drawString(canvas, this.appearance, this.getCoordX(), this.getCoordY());
    }

    /**
     * Draws the given string in the given graphics context at
     * at the given cursor location.
     *
     * @param canvas the canvas on which to draw this item.
     * @param s      the string to draw.
     * @param x      the x-coordinate of the string's cursor location.
     * @param y      the y-coordinate of the string's cursor location.
     */
    public void drawString(Canvas canvas, String s, int x, int y) {
        canvas.drawText(s, x * FishTankView.charWidth, y * FishTankView.charHeight, paintText);
    }

    /**
     * Make this item move.
     */
    public abstract void move();

    /**
     * Return the current x coordinate of the item.
     *
     * @return the x coordinate
     */
    public int getCoordX() {
        return coordX;
    }

    /**
     * Return the current y coordinate of the item.
     *
     * @return the y coordinate
     */
    public int getCoordY() {
        return coordY;
    }

    /**
     * Set the new x coordinate of the item.
     *
     * @param coordX the new x coordinate
     */
    public void setCoordX(int coordX) {

        this.coordX = coordX;
    }

    /**
     * Set the new y coordinate of the item.
     *
     * @param coordY the new y coordinate
     */
    public void setCoordY(int coordY) {

        this.coordY = coordY;
    }

    /**
     * Return the appearance of the item.
     *
     * @return the string appearance of the item
     */
    public String getAppearance() {
        return this.appearance;
    }

    /**
     * Set the new string appearance of this item.
     *
     * @param appearance the new string appearance of the item
     */
    public void setAppearance(String appearance) {
        this.appearance = appearance;
    }

    /**
     * Return the length the item in grid units.
     *
     * @return the int number of grid units.
     */
    public int getAppearanceLength() {
        return (int) Math.floor((this.paintText.measureText(this.appearance) - FishTankView.charWidth) / FishTankView.charWidth);
    }

}
