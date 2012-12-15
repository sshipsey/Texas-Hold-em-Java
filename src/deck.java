import java.util.Random;
import java.awt.*;

public class deck {

		
				
	public deck()
	{
	}
	public static card[] makeDeck()
	{
		//iterator
		int i = 0;
		//random number
		Random rand = new Random();
		
		//create cards + deck
		card[] cardsInOrder = new card[52];
		//clubs
		card CA = new card(14,'c',"1.png");
		cardsInOrder[0] = CA;
		card C2 = new card(2,'c',"49.png");
		cardsInOrder[1] = C2;
		card C3 = new card(3,'c',"49.png");
		cardsInOrder[2] = C3;
		card C4 = new card(4,'c',"49.png");
		cardsInOrder[3] = C4;
		card C5 = new card(5,'c',"49.png");
		cardsInOrder[4] = C5;
		card C6 = new card(6,'c',"49.png");
		cardsInOrder[5] = C6;
		card C7 = new card(7,'c',"49.png");
		cardsInOrder[6] = C7;
		card C8 = new card(8,'c',"49.png");
		cardsInOrder[7] = C8;
		card C9 = new card(9,'c',"49.png");
		cardsInOrder[8] = C9;
		card C10 = new card(10,'c',"49.png");
		cardsInOrder[9] = C10;
		card CJ = new card(11,'c',"49.png");
		cardsInOrder[10] = CJ;
		card CQ = new card(12,'c',"49.png");
		cardsInOrder[11] = CQ;
		card CK = new card(13,'c',"49.png");
		cardsInOrder[12] = CK;
		
		//spades
		
		card SA = new card(14,'s',"49.png");
		cardsInOrder[13] = SA;
		card S2 = new card(2,'s',"49.png");
		cardsInOrder[14] = S2;
		card S3 = new card(3,'s',"49.png");
		cardsInOrder[15] = S3;
		card S4 = new card(4,'s',"49.png");
		cardsInOrder[16] = S4;
		card S5 = new card(5,'s',"49.png");
		cardsInOrder[17] = S5;
		card S6 = new card(6,'s',"49.png");
		cardsInOrder[18] = S6;
		card S7 = new card(7,'s',"49.png");
		cardsInOrder[19] = S7;
		card S8 = new card(8,'s',"49.png");
		cardsInOrder[20] = S8;
		card S9 = new card(9,'s',"49.png");
		cardsInOrder[21] = S9;
		card S10 = new card(10,'s',"49.png");
		cardsInOrder[22] = S10;
		card SJ = new card(11,'s',"49.png");
		cardsInOrder[23] = SJ;
		card SQ = new card(12,'s',"49.png");
		cardsInOrder[24] = SQ;
		card SK = new card(13,'s',"49.png");
		cardsInOrder[25] = SK;
		
		//diamonds
		card DA = new card(14,'d',"49.png");
		cardsInOrder[26] = DA;
		card D2 = new card(2,'d',"49.png");
		cardsInOrder[27] = D2;
		card D3 = new card(3,'d',"49.png");
		cardsInOrder[28] = D3;
		card D4 = new card(4,'d',"49.png");
		cardsInOrder[29] = D4;
		card D5 = new card(5,'d',"49.png");
		cardsInOrder[30] = D5;
		card D6 = new card(6,'d',"49.png");
		cardsInOrder[31] = D6;
		card D7 = new card(7,'d',"49.png");
		cardsInOrder[32] = D7;
		card D8 = new card(8,'d',"49.png");
		cardsInOrder[33] = D8;
		card D9 = new card(9,'d',"49.png");
		cardsInOrder[34] = D9;
		card D10 = new card(10,'d',"49.png");
		cardsInOrder[35] = D10;
		card DJ = new card(11,'d',"49.png");
		cardsInOrder[36] = DJ;
		card DQ = new card(12,'d',"49.png");
		cardsInOrder[37] = DQ;
		card DK = new card(13,'d',"49.png");
		cardsInOrder[38] = DK;


		//hearts
		card HA = new card(14,'h',"49.png");
		cardsInOrder[39] = HA;
		card H2 = new card(2,'h',"49.png");
		cardsInOrder[40] = H2;
		card H3 = new card(3,'h',"49.png");
		cardsInOrder[41] = H3;
		card H4 = new card(4,'h',"49.png");
		cardsInOrder[42] = H4;
		card H5 = new card(5,'h',"49.png");
		cardsInOrder[43] = H5;
		card H6 = new card(6,'h',"49.png");
		cardsInOrder[44] = H6;
		card H7 = new card(7,'h',"49.png");
		cardsInOrder[45] = H7;
		card H8 = new card(8,'h',"49.png");
		cardsInOrder[46] = H8;
		card H9 = new card(9,'h',"49.png");
		cardsInOrder[47] = H9;
		card H10 = new card(10,'h',"49.png");
		cardsInOrder[48] = H10;
		card HJ = new card(11,'h',"49.png");
		cardsInOrder[49] = HJ;
		card HQ = new card(12,'h',"49.png");
		cardsInOrder[50] = HQ;
		card HK = new card(13,'h',"49.png");
		cardsInOrder[51] = HK;
		
		//create deck
		
		card[] deck = new card[52];
		int[] cardAdded = new int[52];
		
		
		//shuffle
		int cardPlace;
		for(i=0;i<52;i++)
		{
		
		cardPlace = rand.nextInt(52);
		if (cardAdded[cardPlace] == 0)
				{
					cardAdded[cardPlace] = 1;
					deck[i] = cardsInOrder[cardPlace];
					System.out.print("Succesful card placed - ");
					System.out.print(i+1);
					System.out.print(" - ");
					System.out.print(deck[i].value);
					System.out.println(deck[i].suit);
					
				}
		else
		{
			i--;
		}
		
		}
		System.out.println("\n");
		return deck;
	}
	
}