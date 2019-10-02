/*
Define a class AlienTrader that extends Trader
with:a constructor that has three parameters that represent this AlienTrader's
    initial amount of money (double),
    initial inventory (List<Tradable>),
    ability to speach both English and Alien (boolean)

an implementation of isHuman
 */

public class AlienTrader extends Trader{

    public AlienTrader(double money, List<Tradable> inventory, boolean bilingual){
        super(money, inventory, bilingual);
    }

    public boolean isHuman() {
        return false;
    }

}