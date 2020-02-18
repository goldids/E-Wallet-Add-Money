package sprint.Exceptions;

public class NegativeAmountException extends Exception{
	public  NegativeAmountException()
	{
		System.out.println("Amount should not be less than zero.");
	}
}
