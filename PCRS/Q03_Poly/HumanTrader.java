/*
Define a class HumanTrader that extends Trader with:
a constructor that has three parameters that represent this HumanTrader's
    initial amount of money (double),
    initial inventory (List<Tradable>),
    ability to speach both English and Alien (boolean)

an implementation of isHuman
 */

public class HumanTrader extends Trader{

    public HumanTrader(double money, List<Tradable> inventory, boolean bilingual){
        super(money, inventory, bilingual);
    }

    public boolean isHuman() {
        return true;
    }

}