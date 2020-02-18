package sprint.Exceptions;

public class LowBalanceException extends Exception{
public LowBalanceException(double bankamount)
{

	if(bankamount<1000)
	System.out.println("Low Balance!");
	else
	{
		System.out.println("Insufficient balance.");
	}
}
}
