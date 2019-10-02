/*
Define a class Momo that implements AlienAnimal and Tradable with:

one private instance variable:
- price in the alien world (double)

a constructor that takes one parameter that represents this Momo's price in the alien world (double)

a method sound so that this Momo makes the sound "momo momo"

methods getHumanPrice and getAlienPrice; this Momo's price in the human world
is 100 times less than the price in the alien world
 */

public class Momo implements  AlienAnimal, Tradable {
    private double alienPrice;

    public Momo (double alienPrice){
        this.alienPrice = alienPrice;
    }

    public String sound(){
        return "momo momo";
    }

    public double getHumanPrice() {
        return alienPrice / 100;
    }

    public double getAlienPrice() {
        return alienPrice;
    }

}