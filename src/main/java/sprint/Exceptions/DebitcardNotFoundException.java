package sprint.Exceptions;

public class DebitcardNotFoundException extends Exception{
	public DebitcardNotFoundException()
	{
		System.out.println("Card number does not exists.");
	}

}
