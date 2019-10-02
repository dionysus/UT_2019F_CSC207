public class GoldCollectorSortByNumGoldComparator implements Comparator<GoldCollector> {
	/**
	 * TODO: Implement compare method so that it returns:
	 *  1 - g1 has more number of gold than g2
	 * -1 - g1 has less number of gold than g2
	 *  0 - g1 has same number of gold than g2
	 *
	 * @param g1 first collector
	 * @param g2 second collector
	 * @return 1, -1 or 0 if g1 is greater, less than or equal to g2.
	 */
	@Override
	public int compare(GoldCollector g1, GoldCollector g2) {
		if (g1.getNumGolds() > g2.getNumGolds()){
			return 1;
		} else if (g1.getNumGolds() < g2.getNumGolds()){
			return -1;
		} else {
			return 0;
		}
	}
  }