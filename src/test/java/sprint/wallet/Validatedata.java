package sprint.wallet;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import sprint.service.Validations;

public class Validatedata {
	Scanner s=new Scanner(System.in);
	
	@Test
	public void validateId()
	{
		
					String str;
					System.out.println("Enter the walletId/Account Number: ");
					str=s.next();
					boolean w=Validations.validateId(str);
					assertEquals(true, w,"Id should cointains only number");
					System.out.println("Your testcase for "+str+" passed.");
					
	}
	@Test
	public void validatewalletidlength()
	{
		String WalletId;
		System.out.println("Enter the WalletId: ");
		WalletId=s.next();
		boolean w1=Validations.walletlength(WalletId);
		assertEquals(true, w1,"Length of WalletId should be 4");
	}
	@Test
	public void validateaccountNolength()
	{
		System.out.println("Enter the Account number: ");
		String accountNo=s.next();
		boolean actual=Validations.bankaccountlength(accountNo);
		assertEquals(true,actual,"Length should be 11");
	}
	
}
