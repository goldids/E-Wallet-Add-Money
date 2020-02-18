package sprint.exceptions;

public class InvalidAccountException extends Exception{
	public InvalidAccountException(boolean validaccountNo,boolean accountNolength)
	{
		if(validaccountNo==false )
			System.out.println("Account Number should contains only Integer!\n plaese try again.");
		else if(accountNolength==false)
			System.out.println("Invalid Account Number!Please Try Again");
		else
			System.out.println("Account number does not exist!");
	}

}
