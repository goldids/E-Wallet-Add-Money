package sprint.client;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

import sprint.service.BankinfoService;
import sprint.service.DebitcardinfoService;
import sprint.Exceptions.DebitcardNotFoundException;
import sprint.Exceptions.InvalidAccountException;
import sprint.Exceptions.LowBalanceException;
import sprint.Exceptions.NegativeAmountException;
import sprint.service.Validations;
import sprint.service.WalletinfoService;

public class ClientDmmy {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		WalletinfoService walletService=new WalletinfoService();
		BankinfoService bankService=new BankinfoService();
		DebitcardinfoService debitcardService = new DebitcardinfoService();
		boolean flag=true;
		while(flag)
		{
			System.out.println("WELCOME TO THE E-WALLET!");
			System.out.println("Enter your walletId: ");
			try {
				
			int WalletId;
			while(true)
			{
				try
				{
					String walletid = br.readLine();
					boolean b1=Validations.validateId(walletid);
					boolean b2=Validations.walletlength(walletid);
					
					if(b1&&b2)
					{
						WalletId=Integer.parseInt(walletid);
						break;
					}
					else
					{
						if(b1==false)
						System.out.println("Wallet Id should contains only number.");
						else if(b2==false)
							System.out.println("Invalid walletId");
					}
				}
				catch(IOException e) {
					System.out.println("Wallet Id should not be empty.Enter the walletid.");
					e.printStackTrace();
				}
			}
			boolean b3=walletService.verifywalletId(WalletId);
			if(!b3)
			{
				System.out.println("WalletId Does not exists.");
			}
			else
			{
				System.out.println("Enter the Amount you want to add: ");
				int amount;
				String amt;
				while(true)
				{
					try {
					amt=br.readLine();
					boolean validateamount=Validations.amount(amt);
					
					if(validateamount)
					{
						try
						{
							amount=Integer.parseInt(amt);
								if(amount<0)
									throw new NegativeAmountException();
							break;
						}
						catch(Exception e)
						{
							System.out.println("Please enter valid amount again.");
							
						}
					}
					else
					{
						
						System.out.println(" Amount entered should not be 0");
					}
					
				}
					catch(IOException e)
					{
						System.out.println("Amount should not be null.Enter the amount again.");
					}
					
				}
				System.out.println("Choose the mode:");
				System.out.println("Press 1 for BankAccount.");
				System.out.println("press 2 for Debit Card");
				System.out.println("Enter your choice: ");
				String choice;
				choice=br.readLine();
				switch(choice)
				{
				case "1":
					System.out.println("Enter your Bank Account Number: ");
					String bankaccountNo;
					while(true)
					{
						try
						{
						bankaccountNo=br.readLine();
						boolean validaccountNo=Validations.validateId(bankaccountNo);
						boolean accountNolength=Validations.bankaccountlength(bankaccountNo);
						if(!(validaccountNo && accountNolength))
								throw new InvalidAccountException(validaccountNo,accountNolength);
					
						if(validaccountNo && accountNolength)
						{
							boolean verifyaccount=bankService.validBankaccount(bankaccountNo);
								if(verifyaccount==false)
									throw new InvalidAccountException(validaccountNo,accountNolength);
		
								double bankamount=bankService.checkBankamount(bankaccountNo);
								
										if(bankamount<1000)
											throw new LowBalanceException(bankamount);
										else if(amount>bankamount)
											throw new LowBalanceException(bankamount);
										
										bankService.updateBankamout(bankaccountNo, amount);
										walletService.updatewalletamount(WalletId, amount);
										System.out.println("Sucessfully Added Rs."+amount+" to your wallet.");
										System.out.println("Updated wallet amount: "+walletService.getwalletamount(WalletId));
										System.out.println("Available Balance in your Bank Account: "+bankService.checkBankamount(bankaccountNo));
										System.out.println("Do you want to continue (y/n)");
										String con;
										Scanner s=new Scanner(System.in);
											con = s.next();
										if(con.equals("n") || con.equals("N"))
											flag=false;
										break;
							}
							
						}
						
					
						catch(Exception e)
						{
							System.out.println("Please Enter the account number");
						}
					}
					break;
				case "2":
					System.out.println("Enter your card Number: ");
					String debitcardNo;
					String cvv;
					while(true)
					{
						try
						{
							debitcardNo=br.readLine();
							
							while(true)
							{
								System.out.println("Enter your cvv Number");
								cvv=br.readLine();
								boolean cardandcvv=debitcardService.cardandcvv(debitcardNo, cvv);
							try
							{
								if(cardandcvv==false)
									throw new Exception();
								break;
							}
							catch(Exception e)
							{
								System.out.println("Wrong CVV! provide correct CVV!");
							}
							}
							boolean validcardNo=Validations.validateId(debitcardNo);
							boolean cardNolength=Validations.debitcardlength(debitcardNo);
								if(validcardNo==false)
									System.out.println("Card number should contains only integer.");
							
							if(validcardNo && cardNolength)
							{
								boolean verifycard=debitcardService.validcard(debitcardNo);
									if(verifycard==false)
										throw new DebitcardNotFoundException();

									String cardbankaccountNo=debitcardService.getBankAccountNo(debitcardNo);
									double bankamount=bankService.checkBankamount(cardbankaccountNo);
										if(bankamount<1000)
											throw new LowBalanceException(bankamount);
										else if(amount>bankamount)
											throw new LowBalanceException(bankamount);
										bankService.updateBankamout(cardbankaccountNo, amount);
										walletService.updatewalletamount(WalletId, amount);
										System.out.println("Sucessfully Added Rs."+amount+" to your wallet.");
										System.out.println("Updated wallet amount: "+walletService.getwalletamount(WalletId));
										System.out.println("updated bank amount: "+bankService.checkBankamount(cardbankaccountNo));
										System.out.println("Do you want to continue (y/n)");
										String con;
										Scanner s=new Scanner(System.in);
											con = s.next();
										if(con.equals("n") || con.equals("N"))
											flag=false;
										break;
											
									
								}
															}
						catch(Exception e)
						{
							System.out.println("Please enter valid card number.");
						}
					}
					break;
					default:
						System.out.println("Please Enter valid choice!");
				
			}
			
		}
	}//end first try block
			catch(Exception e)
			{
				System.out.println("Enter valid walletId.");
			}
			
			
}//end while loop
}//end main function
}//end class
