package sprint.wallet;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import sprint.service.Validations;

public class Validatedata {
	Scanner s=new Scanner(System.in);
	@AfterEach
	public void aftereach()
	{
		System.out.println("Your test case passed.");
	}
	@Test
	public void validatedata()
	{
		boolean flag=true;
		while(flag)
		{
			System.out.println("TESTING");
			System.out.println("press 1 for validating the walletId or Bank account number");
			System.out.println("press 2 for validating the length of wallet id");
			System.out.println("press 3 for validating the length of Bank Account numbers");
			System.out.println("Press 4 for exit");
			System.out.println("Enter the choice: ");
			String choice=s.next();
			
			switch(choice)
			{
				case "1":
					String str;
					System.out.println("Enter the string: ");
					str=s.next();
					boolean w=Validations.validateId(str);
					assertEquals(true, w,"Id should cointains only number");
					System.out.println("Your testcase for "+str+" passed.");
					break;
				case "2":
					String WalletId;
					System.out.println("Enter the WalletId: ");
					WalletId=s.next();
					boolean w1=Validations.walletlength(WalletId);
					assertEquals(true, w1,"Length of WalletId should be 4");
					break;
				case "3":
					break;
				case "4":
					flag=false;
					break;
				default:
					System.out.println("Please enter correct choice.");
			}
		}
	}
}
