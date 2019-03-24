

public class CardB implements Comparable<CardB> {
	private String suit;
	private String rank;
	private int pointValue;
	
	public CardB(String cardRank, String cardSuit, int cardPointValue) {
		rank = cardRank;
		suit = cardSuit;
		pointValue = cardPointValue;
	}
	
	public String suit() {
		return suit;
	}

	public String rank() {
		return rank;
	}

	public int pointValue() {
		return pointValue;
	}

	public String toString() {
		String fullName = suit + " of " + rank;
		return fullName;
	}
	@Override
	public int compareTo(CardB o) {
		return 0;
	}
}
