public class GoldCollector implements Comparable<GoldCollector> {

	protected int numGolds;
	protected String name;
	/**
	 * TODO: The constructor takes a name and assigns the variable name. It also
	 * sets numGolds to 0.
	 *
	 * @param name: name of the collector
	 */
	public GoldCollector(String name) {
		this.name = name;
		this.numGolds = 0;
	}
  
	/**
	 * TODO: Implement incrementNumGolds method, and it increment numGolds by 1;
	 */
	public void incrementNumGolds () {
		this.numGolds++;
	}
  
	/**
	 * TODO: Implement collect method, and it increment the numGolds by numOfGold
	 * times.
	 *
	 * @param numOfGold number of gold collects
	 */
	public void collect (int numOfGold) {
		for (int i = 0; i < numOfGold; i++){
			incrementNumGolds();
		}
	}
  
	/**
	 * TODO: Implement Getter, getNumGolds, for numGolds.
	 *
	 * @return number of golds
	 */
	public int getNumGolds() {
		return this.numGolds;
	}
  
	/**
	 * TODO: Implement Getter, getName, for name.
	 *
	 * @return name of the collector
	 */
	public String getName() {
		return this.name;
	}
  
	/**
	 * TODO: Implement compareTo method so that it returns:
	 *  1 - this collector has more number of gold than the other collector
	 * -1 - this collector has less number of gold than the other collector
	 *  0 - this collector has same number of gold than the other collector
	 *
	 * @param other the other collector to be compared
	 * @return 1, -1 or 0 if this collector is greater, less than or equal to the
	 * other collector.
	 */
	@Override
	public int compareTo(GoldCollector other) {
		if (this.getNumGolds() > other.getNumGolds()){
			return 1;
		} else if (this.getNumGolds() < other.getNumGolds()){
			return -1;
		} else {
			return 0;
		}
	}
}