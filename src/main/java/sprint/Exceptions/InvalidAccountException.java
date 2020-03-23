package sprint.exceptions;

public class InvalidAccountException extends Exception{
	public InvalidAccountException(boolean validaccountNo,boolean accountNolength)
	{
			super("Account number does not exist!");
	}

}
