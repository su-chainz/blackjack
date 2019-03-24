import java.util.ArrayList;

public class DeckB extends ArrayList<CardB> {
	
		static ArrayList<CardB> cards = new ArrayList<CardB>();

		public static CardB pickCard() {
			return cards.get((int)Math.ceil(Math.random() * 52)-1);
		}
		public static void setCards() {
			String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
			for(int i = 1; i < 5; i++) {
				cards.add(new CardB(suits[i-1], "Ace" , 1));
			}
			for(int i = 1; i < 5; i++) {
				cards.add(new CardB(suits[i-1], "Jack" , 10));
			}
			for(int i = 1; i < 5; i++) {
				cards.add(new CardB(suits[i-1], "Queen" , 10));
			}
			for(int i = 1; i < 5; i++) {
				cards.add(new CardB(suits[i-1], "King" , 10));
			}
			for(int i = 1; i < 5; i++) {
				cards.add(new CardB(suits[i-1], "Two" , 2));
			}
			for(int i = 1; i < 5; i++) {
				cards.add(new CardB(suits[i-1], "Three" , 3));
			}
			for(int i = 1; i < 5; i++) {
				cards.add(new CardB(suits[i-1], "Four" , 4));
			}
			for(int i = 1; i < 5; i++) {
				cards.add(new CardB(suits[i-1], "Five" , 5));
			}
			for(int i = 1; i < 5; i++) {
				cards.add(new CardB(suits[i-1], "Six" , 6));
			}
			for(int i = 1; i < 5; i++) {
				cards.add(new CardB(suits[i-1], "Seven" , 7));
			}
			for(int i = 1; i < 5; i++) {
				cards.add(new CardB(suits[i-1], "Eight" , 8));
			}
			for(int i = 1; i < 5; i++) {
				cards.add(new CardB(suits[i-1], "Nine" , 9));
			}
			for(int i = 1; i < 5; i++) {
				cards.add(new CardB(suits[i-1], "Ten" , 10));
			}
		}
}
