public class Fruit {

    public String name;
    public static int numFruit;
    public static String salesCat = "produce";

    public Fruit(String name) {
        this.name = name;
        numFruit++;
    }

    public static String getSalesCat() {
        return salesCat;
    }

    public void setIsForSale(boolean b) {
    }

    public String getName() {
        return name;
    }

    public static int getNumFruit() {
        return numFruit;
    }

    public void whatIsThis() {
        System.out.println("This is a fruit");
    }

    public String toString() {
        return "This is a " + name;
    }

}
