/*
Define a class Pikachu that implements AlienAnimal and Tradable with:

two private instance variables:
- price in the human world (double)
- price in the alien world (double)

a constructor that takes two parameters that represent this Pikachu's
prices in the human world and alien world (two doubles)

a method sound so that this Pikachu makes the sound "pika pika"

methods getHumanPrice and getAlienPrice

*/

public class Pikachu implements  AlienAnimal, Tradable {
    private double humanPrice;
    private double alienPrice;

    public Pikachu (double humanPrice, double alienPrice){
        this.humanPrice = humanPrice;
        this.alienPrice = alienPrice;
    }

    public String sound(){
        return "pika pika";
    }

    public double getHumanPrice() {
        return humanPrice;
    }

    public double getAlienPrice() {
        return alienPrice;
    }

}