/*
Define a class Sedan that implements Vehicle and Tradable with:
two private instance variables:
- price in the human world (double)
- speed (int)

a constructor that has one parameter that represents this Sedan's price
in the human world (double); this Sedan's speed is initially 0

methods speedUp and speedDown so that this Sedan's speed changes by 2

methods getHumanPrice and getAlienPrice; this Sedan's price in the alien world
is 50 times more than the price in the human world
 */

public class Sedan implements Vehicle, Tradable {
    private double humanPrice;
    private int speed;

    public Sedan (double humanPrice) {
        this.humanPrice = humanPrice;
        this.speed = 0;
    }

    public void speedUp() {
        this.speed += 2;
    }

    public void speedDown() {
        this.speed -= 2;
    }

    public double getHumanPrice(){
        return humanPrice;
    }

    public double getAlienPrice(){
        return humanPrice * 50;
    }

}