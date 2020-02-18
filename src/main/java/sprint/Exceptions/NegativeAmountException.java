package sprint.exceptions;

public class NegativeAmountException extends Exception{
	public  NegativeAmountException()
	{
		System.err.println("Amount should not be less than zero.");
	}
}
