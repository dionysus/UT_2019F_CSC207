
/*
a constructor that has two parameters that represents
this GradedFruit's type (String), and rating (double)

a constructor that has three parameters that represents
this GradedFruit's type (String), price (double), and rating (double)

override getPrice so that it returns this GradedFruit's
price multiplied by its rating

override toString so that it returns a String representation of
this GradedFruit formatted as "(type, original price, new price)";
for example, GradedFruit("orange", 2, 1.1)'s toString() returns (orange, 2.0, 2.2)

*/
public class GradedFruit extends Fruit{
    private double rating;

    public GradedFruit(String type2, double rating) {
        super(type2);
        this.rating = rating;
    }

    public GradedFruit(String type3, double price3, double rating) {
        super(type3, price3);
        this.rating = rating;
    }

    public double getPrice() {
        return super.getPrice() * this.rating;
    }

    @Override
    public String toString() {
        return "(" + super.getType() + ", " + super.getPrice() + ", " + this.getPrice() + ")";
    }

    public double getRating() {
        return this.rating;
    }

    public void setRating(double newRating) {
        this.rating = newRating;
    }
}