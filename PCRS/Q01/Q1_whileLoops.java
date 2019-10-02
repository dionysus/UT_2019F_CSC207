public class Backwards {
	
	private int [] A, B;
	
	public Backwards() {
		A = new int [10];
		B = new int [10];
	}
	
	//hidden code fills A
	public void fillA (){
		for (int a = 0; a < 10; a++){
			A[a] = a;
		}
	}

	/**
	 * Copies positive elements of A to B, but in reverse order, stopping upon encountering a negative element.
	 */
	public void backwardsCopy() {
		int i = 99;
		while (i >= 0 && this.A[i] >= 0){
			this.B[i] = new int this.A[i];
			i--;
		}
	}
}