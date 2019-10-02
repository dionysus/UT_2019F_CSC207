/*
Define an abstract class Trader with:
        four private instance variables:
        - inventory (List<Tradable>)
        - wish list (List<Tradable>)
        - money (double)
        - bilingual (boolean)

        a constructor that has three parameters that represent this Trader's initial
        amount of money (double), initial inventory (List<Tradable>), and ability to
        speach both English and Alien (boolean);
        initialize wish list to an empty ArrayList

        an abstract method called isHuman that returns true if and only if this Trader is a human

        a method called addToWishlist that takes Tradable and returns nothing

        a method called sellTo that takes Trader and returns true if and only if both Traders can communicate;
        if both Traders can communicate, trade can be made by the following: if any Tradable item in this Trader's
        inventory is in the input Trader's wish list and the input Trader has enough money to pay, remove the item
        from this Trader's inventory, and the input Trader's wish list and add it to the input Trader's inventory;
        update both Traders' money with appropriate currency

        a method called buyFrom that takes Trader and returns true if and only if both Traders can communicate;
        If both Traders can communicate, trade can be made by the following: if any Tradable item in this Trader's
        wish list is in the input Trader's inventory and this Trader has enough money to pay, remove the item from
        the input Trader's inventory, and this Trader's wish list and add it to this Trader's inventory;
        update both Traders' money with appropriate currency (hint: you can use sellTo method here)

        Do not define getters

 */

import java.util.ArrayList;
import java.util.List;

public abstract class Trader {
    private List<Tradable> inventory;
    private List<Tradable> wishlist;
    private double money;
    private boolean bilingual;

    public Trader (double money, List<Tradable> inventory, boolean bilingual){
        this.inventory = inventory;
        this.wishlist = new ArrayList<Tradable>();
        this.money = money;
        this.bilingual = bilingual;
    }

    public abstract boolean isHuman();

    public void addToWishlist(Tradable wishItem) {

        this.wishlist.add(wishItem);
    }

    public boolean sellTo (Trader buyer){
        if (!this.canCommunicateWith(buyer)){
            return false;
        }
        int i = 0;
        while (i < buyer.wishlist.size()){

            Tradable item = (Tradable) buyer.wishlist.get(i);

            double buyPrice = buyer.getPriceOf(item);
            double sellPrice = this.getPriceOf(item);

            if (buyPrice <= buyer.money) {
                this.money += sellPrice;
                buyer.money -= buyPrice;

                int j = 0;
                while (this.inventory.get(j) != item){
                    j++;
                }
                this.inventory.remove(j);
                buyer.inventory.add(item);
                buyer.wishlist.remove(i);
            } else {
                i++;
            }
        }
        return true;
    }

    public boolean buyFrom (Trader seller){

        return seller.sellTo(this);
    }

    private double getPriceOf(Tradable item){
        if (this.isHuman()) {
            return item.getHumanPrice();
        } else {
            return item.getAlienPrice();
        }
    }

    private boolean canCommunicateWith (Trader other){
        if (this.bilingual || other.bilingual){
            return true;
        } else if (this.isHuman() == other.isHuman()) {
            return true;
        } else {
            return false;
        }
    }
}