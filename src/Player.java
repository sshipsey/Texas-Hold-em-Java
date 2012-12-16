
public class Player {
	
	private int pNum;
	private Card[] hand = new Card[2];
	private Card[] fullHand = new Card[5];
	private Player[] players;
	public Player(int a, Card[] b)
	{
		pNum = a;
		hand = b;
		
	}
	public Player[] seatPlayers(int numPlayers)
	{
		for(int i=0;i<numPlayers;i++)
		{
			players[i] = new Player(i+1,//fuck)
		}
		return players;
	}
	
	public Card[] getHand(Player p)
	{
		
		
		
		return fullHand;
	}
}
