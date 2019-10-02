import java.util.Random;

public class CandyPlayer {

	private static int totalCandy = (new Random()).nextInt(100);
//----- code starts here -----//
	private static int turn = 0;
	private static int numberOfPlayers = 0;
	private int playerId;
	private int myCandy;

	public CandyPlayer(int initCandy) {
		this.myCandy = initCandy;
		this.playerId = getNumberOfPlayers();
		setNumberOfPlayers(getNumberOfPlayers() + 1);
	}
	
	public static int getTurn(){
		return turn;
	}

	public static void setTurn(int newTurn){
		turn = newTurn;
	}

	public static int getNumberOfPlayers(){
		return numberOfPlayers;
	}

	public static void setNumberOfPlayers(int newPlayer){
		numberOfPlayers = newPlayer;
	}

	public int getMyCandy() {
		return this.myCandy;
	}
	
	public static int getMountainCandy() {
		return totalCandy;
	}

	public boolean play (int giveCandy) {
		if (getTurn() != this.playerId){
			return false;
		} else if (giveCandy <= 0 || giveCandy > getMyCandy()) {
			nextTurn();
			return false;
		} else if (giveCandy <= getMountainCandy()){
			this.myCandy += giveCandy;
			totalCandy -= giveCandy;
			nextTurn();
			return true;
		} else {
			this.myCandy -= giveCandy;
			totalCandy += giveCandy;
			nextTurn();
			return false;
		}
	}

	private void nextTurn() {
		if (getTurn() == getNumberOfPlayers() - 1){
			setTurn(0);
		} else {
			setTurn(getTurn() + 1);
		}	
	}
}