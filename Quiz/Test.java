package quiz;

public class Test {

	public static void main(String[] args){
		Fruit f1 = new Grape();
		Pear f2 = new Pear();
		Fruit f3 = f2;
		System.out.println(f1 instanceof Fruit);
		System.out.println(f3 == f2);
		
	}

}

