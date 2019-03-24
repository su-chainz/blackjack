import java.util.ArrayList;

public class Hand {

	public static int[] getValues(ArrayList<CardB> list) {
		int count1 = 0;
		for(CardB x: list) {
			count1 = count1 + x.pointValue();  }

		int count2 = 0;
		boolean usedEleven = false;
		for(CardB y: list) {
			if(y.pointValue() == 1 && !usedEleven) {
				count2 = count2 + 11;
				usedEleven = true;
			}
			else
				count2 = count2 + y.pointValue();	

		}
		if(count2 > 21)
			count2 = count1;
		int[] handValue = {count1, count2};	
		return handValue;
	}

}

