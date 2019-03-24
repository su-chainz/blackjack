import java.util.ArrayList;


public class Blackjack
{
	ArrayList<CardB> cards = new ArrayList<CardB>();
	int games = 0;
	String name = "Suchetan";
	String balance = "1000";

	public void playGame() {
		DeckB.setCards();
		while(true)
			startRound();
	}
	public void startRound() {
		int dealerMinValue = 0;
		int dealerMaxValue = 0;
		int playerMinValue = 0;
		int playerMaxValue = 0;
		
		
		System.out.println(name + "'s balance: " + balance);	
		System.out.println("How much money would you like to bet? (Q to cash out)");
		
		String bet = Input.getInput();
		while (Integer.parseInt(bet) > Integer.parseInt(balance)) {
			System.out.println("Can't bet more than you have!");
			System.out.println("How much money would you like to bet? (Q to cash out)");
			bet = Input.getInput();
		}
		while (isNumeric(bet) == false) {
			System.out.println("Must be a number!");
			System.out.println("How much money would you like to bet? (Q to cash out)");
			bet = Input.getInput();
		}
		if(bet.equals("Q")) {
			endProgram();
		}

		ArrayList<CardB> dealerCards = new ArrayList<CardB>();   // make array to hold dealers cards
		ArrayList<CardB> playerCards = new ArrayList<CardB>();   // players cards
		dealerCards.add(DeckB.pickCard());                                                                  //Starts dealers first pick
		System.out.println("The dealer draws the " + dealerCards.get(0).toString());
		int[] dealerHandVal = Hand.getValues(dealerCards);
		dealerMinValue = dealerHandVal[0];
		dealerMaxValue = dealerHandVal[1];
		if(dealerMinValue == dealerMaxValue)
			System.out.println("The dealer has " + dealerMinValue);
		else
			System.out.println("The dealer has " + dealerMinValue + " or " + dealerMaxValue + " due to Ace.");         //End dealers first picks

		boolean roundOver = false;
		boolean playerTurnOver = false;
		playerCards.add(DeckB.pickCard());
		playerCards.add(DeckB.pickCard());
		int[] playerHandVal = Hand.getValues(playerCards);
		playerMinValue = playerHandVal[0];
		playerMaxValue = playerHandVal[1];
		System.out.println("\nYou draw the " + playerCards.get(0).toString());
		System.out.println("You draw the " + playerCards.get(1).toString());
		if(playerMinValue == playerMaxValue)
			System.out.println("You have " + playerMinValue);
		else
			System.out.println("You have " + playerMinValue + " or " + playerMaxValue + " due to Ace.");
		if(playerMaxValue == 21) {
			System.out.println("You got blackjack!");
			balance = Integer.toString(Integer.parseInt(balance) + Integer.parseInt(bet));
			games++;
			roundOver = true;
			playerTurnOver = true;
		}
		String position = "";
		if(!playerTurnOver && !roundOver) {
			System.out.println("What will you do?");
			System.out.println("1. Hit");
			System.out.println("2. Stand");
			System.out.println("");
			position = Input.getInput();
		}	



		while(!playerTurnOver && !roundOver)
		{
			if(position.equals("1")) {  
				playerCards.add(DeckB.pickCard());
				playerHandVal = Hand.getValues(playerCards);
				playerMinValue = playerHandVal[0];
				playerMaxValue = playerHandVal[1];
				System.out.println("You draw the " + playerCards.get(playerCards.size()-1).toString());
				if(playerMinValue == playerMaxValue)
					System.out.println("You have " + playerMinValue);
				else
					System.out.println("You have " + playerMinValue + " or " + playerMaxValue + " due to Ace.");
				if(playerMaxValue > 21) {
					roundOver = true;
					playerTurnOver = true;
					System.out.println("You bust.");
					balance = Integer.toString(Integer.parseInt(balance) - Integer.parseInt(bet));
					games++;


				}

				if(playerMaxValue == 21) {
					roundOver = true;
					playerTurnOver = true;
					System.out.println("You got blackjack!");
					balance = Integer.toString(Integer.parseInt(balance) + Integer.parseInt(bet));
					games++;

				}
			}
			if(position.equalsIgnoreCase("2")) { //Stand
				System.out.println("You stand.");
				playerTurnOver = true;
			}

			if(!playerTurnOver) {
				System.out.println("What will you do?");
				System.out.println("1. Hit");
				System.out.println("2. Stand");
				System.out.println("");
				position = Input.getInput();
			}


		}



		boolean dealerTurnOver = false;
		while(!dealerTurnOver && !roundOver) {

			dealerCards.add(DeckB.pickCard());
			System.out.println("\nThe dealer draws the " + dealerCards.get(dealerCards.size()-1).toString());
			dealerHandVal = Hand.getValues(dealerCards);
			dealerMinValue = dealerHandVal[0];
			dealerMaxValue = dealerHandVal[1];

			if(dealerMinValue == dealerMaxValue)
				System.out.println("The dealer has " + dealerMinValue);
			else
				System.out.println("The dealer has " + dealerMinValue + " or " + dealerMaxValue + " due to Ace.");

			if(dealerMaxValue >= 17 && dealerMaxValue < 22) {
				//
				if(dealerMaxValue == 21) {
					System.out.println("Dealer got blackjack.");
					balance = Integer.toString(Integer.parseInt(balance) - Integer.parseInt(bet));
					games++;
					dealerTurnOver = true;
					roundOver = true;
				}

				else if(dealerMaxValue < playerMaxValue) {
					System.out.println("You win.");
					balance = Integer.toString(Integer.parseInt(balance) + Integer.parseInt(bet));
					games++;

					dealerTurnOver = true;
					roundOver = true;
				}
				else if(dealerMaxValue == playerMaxValue) {
					System.out.println("You tied with the dealer. By house rules dealer wins.");
					balance = Integer.toString(Integer.parseInt(balance) - Integer.parseInt(bet));
					games++;
					dealerTurnOver = true;
					roundOver = true;
				}
				else {
					System.out.println("The dealer beat you.");
					balance = Integer.toString(Integer.parseInt(balance) - Integer.parseInt(bet));
					games++;
					dealerTurnOver = true;
					roundOver = true;
				}

			}
			if(dealerMaxValue > 21) {
				System.out.println("The dealer busts. You win!");
				balance = Integer.toString(Integer.parseInt(balance) + Integer.parseInt(bet));
				games++;
				dealerTurnOver = true;
				roundOver = true;
			}
		}
	}
	public void endProgram() {
		System.exit(0);
	}
	
	public static boolean isNumeric(String str) { 
		  try {  
		    Double.parseDouble(str);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
	}
}
