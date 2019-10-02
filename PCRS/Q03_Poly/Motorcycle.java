/*
Define a class Motorcycle that implements Vehicle and Tradable with:

        three private instance variables:
        - price in the human world (double)
        - price in the alien world (double)
        - speed (int)

        a constructor that has two parameters that represent this Motorcycle's prices
        in the human world and alien world (two doubles);
        this Motorcycle's speed is initially 0

        methods speedUp and speedDown so that this Motorcycle's speed changes by 1

        methods getHumanPrice and getAlienPrice
*/

public class Motorcycle implements Vehicle, Tradable {
    private double humanPrice;
    private double alienPrice;
    private int speed;

    public Motorcycle (double humanPrice, double alienPrice) {
        this.humanPrice = humanPrice;
        this.alienPrice = alienPrice;
        this.speed = 0;
    }

    public void speedUp() {
        this.speed += 1;
    }

    public void speedDown() {
        this.speed -= 1;
    }

    public double getHumanPrice(){
        return humanPrice;
    }

    public double getAlienPrice(){
        return alienPrice;
    }

}