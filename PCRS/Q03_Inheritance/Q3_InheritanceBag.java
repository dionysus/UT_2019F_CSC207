public abstract class Bag {
	private String color;
	private int capacity;
	private int numberOfContents;
	private String[] contents;
	
	public Bag(String color, int capacity) {
		this.color = color;
		this.capacity = capacity;
		this.numberOfContents = 0;
		this.contents = new String[capacity];
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String newColor){
		this.color = newColor;
	}

	public int getNumberOfContents() {
		return this.numberOfContents;
	}

	public int getCapacity() {
		return this.capacity;
	}

	public String addItem(String item) {
		if (this.numberOfContents == this.capacity){
			return item;
		} else {
			this.contents[this.numberOfContents] = item;
			this.numberOfContents++;
			return null;
		}
	}

	public String popItem() {
		if (this.numberOfContents == 0){
			return null;
		} else {
			String lastItem = this.contents[this.numberOfContents - 1];
			this.contents[this.numberOfContents - 1] = null;
			this.numberOfContents--;
			return lastItem;
		}
	}

	public abstract void enhance();

	protected void update(int extraCapacity){
		this.capacity += extraCapacity;
		String[] newContents = new String[this.capacity];
		for (int i = 0; i < this.numberOfContents; i++){
			newContents[i] = this.contents[i];
		}
		this.contents = newContents;
	}
}
