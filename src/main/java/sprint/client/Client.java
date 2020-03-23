package sprint.client;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Scanner;

import sprint.exceptions.CvvNotMatchException;
import sprint.exceptions.DebitcardNotFoundException;
import sprint.exceptions.InvalidAccountException;
import sprint.exceptions.LowBalanceException;
import sprint.exceptions.NegativeAmountException;

import sprint.service.Validations;
import sprint.service.WalletinfoService;

public class Client {

	public static void main(String[] args)throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		WalletinfoService walletService=new WalletinfoService();
		
		boolean flag=true;
		boolean flag1=true;
		System.out.println("====================================");
		System.out.println("WELCOME TO THE E-WALLET!");
		System.out.println("====================================\n");
		while(flag1)
		{
			

			System.out.println("Enter your walletId: ");	
			int walletId;
			while(true)
			{
				try
				{
					String walletid = br.readLine();
					boolean validwalletid=Validations.validateId(walletid);
					boolean validwalletidlength=Validations.walletlength(walletid);
					
					if(validwalletid&&validwalletidlength)
					{
						walletId=Integer.parseInt(walletid);
						break;
					}
					else
					{
						if(!validwalletid)
							System.out.println("Wallet Id should contains only number.Try Again");
						else if(!validwalletidlength)
							System.out.println("Invalid walletId.Try Again.");
					}
				}
				catch(Exception e) {
					System.out.println("Wallet Id should not be empty.\nEnter the walletid.");
					
				}
			}
			boolean b3=walletService.verifywalletId(walletId);
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
					
					if(!validateamount)
					{
						try
						{
							amount=Integer.parseInt(amt);
								if(amount<0)
									throw new NegativeAmountException("Amount cannot be negative.");
							break;
						}
						catch(NegativeAmountException e)
						{
							System.out.println(e.getMessage());
							
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
				do
				{
				//System.out.println("Choose the mode:");
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
						{
								System.out.println("Invalid Account Number\n Please enter the account number again.");
						}
					
						if(validaccountNo && accountNolength)
						{
							boolean verifyaccount=walletService.validBankaccount(bankaccountNo);
							try
							{
								if(!verifyaccount)
									throw new InvalidAccountException(validaccountNo,accountNolength);
							}
							catch(InvalidAccountException e)
							{
								System.out.println(e.getMessage());
							}
		
								double bankamount=walletService.checkBankamount(bankaccountNo);
										try
										{
										if(bankamount<1000)
											throw new LowBalanceException("Low Balance!");
										else if(amount>bankamount)
											throw new LowBalanceException("Insufficent Balance!");
										}
										catch(LowBalanceException e)
										{
											System.out.println(e.getMessage());
											System.out.println("Choose Other Options");
											break;
										}
										
										walletService.updateBankamout(bankaccountNo, amount);
										walletService.updatewalletamount(walletId, amount);
										System.out.println("Sucessfully Added Rs."+amount+" to your wallet.");
										System.out.println("Updated wallet amount: "+walletService.getwalletamount(walletId));
										System.out.println("Available Balance in your Bank Account: "+walletService.checkBankamount(bankaccountNo));
										System.out.println("\n");
									
											flag=false;
										break;
							}
							
						}
						
					
						catch(Exception e)
						{
							System.out.println("Please Enter the account number again");
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
								boolean cardandcvv=walletService.cardandcvv(debitcardNo, cvv);
								try
								{
								if(!cardandcvv)
									throw new CvvNotMatchException("Wrong CVV! provide correct CVV!");
								break;
								}
								catch(CvvNotMatchException e)
								{
									System.out.println(e.getMessage());
									
								}
								
							}
							boolean validcardNo=Validations.validateId(debitcardNo);
							boolean cardNolength=Validations.debitcardlength(debitcardNo);
								if(!validcardNo)
									System.out.println("Card number should contains only integer.");
							
						if(validcardNo && cardNolength)
							{
								boolean verifycard=walletService.validcard(debitcardNo);
								try
								{
									if(!verifycard)
										throw new DebitcardNotFoundException("Please enter valid card Number.");
									
								}
								catch(DebitcardNotFoundException e)
								{
									System.out.println(e.getMessage());
								}
							
									String cardbankaccountNo=walletService.getBankAccountNo(debitcardNo);
									double bankamount=walletService.checkBankamount(cardbankaccountNo);
									try {
										if(bankamount<1000)
											throw new LowBalanceException("Low Balance!");
										else if(amount>bankamount)
											throw new LowBalanceException("Insufficent Balance");
									}
									catch(LowBalanceException e)
									{
										System.out.println(e.getMessage());
										System.out.println("Choice Other Choices.");
										break;
									}
										walletService.updateBankamout(cardbankaccountNo, amount);
										walletService.updatewalletamount(walletId, amount);
										System.out.println("Sucessfully Added Rs."+amount+" to your wallet.");
										System.out.println("Updated Wallet Amount: "+walletService.getwalletamount(walletId));
										System.out.println("Updated Bank Infomation:\n");
										System.out.println("Available Balance: "+walletService.checkBankamount(cardbankaccountNo));
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
				
				}while(flag);
				
				System.out.println("Do you want to continue (y/n)");
				System.out.println("Press 'y' to continue and any other key to end.");
				String con;
				Scanner s=new Scanner(System.in);
					con = s.next();
				if(con.equals("y") || con.equals("Y"))
					flag1=true;
				else
				{
					System.out.println("Thank You for using E-Wallet.");
					flag1=false;
				}
		}

			
}//end while loop
}//end main function
}//end class
