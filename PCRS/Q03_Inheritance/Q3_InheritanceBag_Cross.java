public class CrossbodyBag extends Bag {
	private int straps;

	public CrossbodyBag(String color, int capacity, int straps){
		super(color, capacity);
		this.straps = straps;
	}

	public int getNumberOfStraps(){
		return this.straps;
	}

	public void enhance (){
		this.update(2);
	}
}