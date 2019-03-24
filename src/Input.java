import java.util.Scanner;

public class Input {

	public static String getInput() {

		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		String response = in.nextLine();
		return response;
	}
}
