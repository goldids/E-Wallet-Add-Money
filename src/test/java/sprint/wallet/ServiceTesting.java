package sprint.wallet;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.jupiter.api.Test;

import sprint.collectionsutil.CollectionClass;
import sprint.service.BankinfoService;
import sprint.service.DebitcardinfoService;
import sprint.service.WalletinfoService;

public class ServiceTesting {
	 BankinfoService objbankinfoservice=new BankinfoService();
	 DebitcardinfoService objdebitcardservice=new  DebitcardinfoService();
	 WalletinfoService objwalletservice=new WalletinfoService();
	 CollectionClass objcollectionclass = new CollectionClass();
	 
	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 @Test
	 public void checkBankamounttesting()
	 {
		 System.out.println("Enter the account number: ");
		 String accountNo;
		 try {
			accountNo=br.readLine();
			double d=objbankinfoservice.checkBankamount(accountNo);
			double actualamount = objcollectionclass.bankdetails().get(accountNo).getAmount();
			assertEquals("Account Not Found", d, actualamount, 0.02);
			
		} catch (IOException e) {
			System.err.println("Null values not allowed.");
		}
	 }
	 @Test
	 public void validBankaccounttesting()
	 {
		 System.out.println("2. Enter the account number: ");
		 String accountNo;
		 try {
				accountNo=br.readLine();
				boolean d=objbankinfoservice.validBankaccount(accountNo);
				assertEquals("InValid Account Number",true,d);
				
			} catch (IOException e) {
				System.err.println("Null values not allowed.");
			}
	 }
	 @Test
	 public void validcardtesting()
	 {
		 System.out.println("2. Enter the Debit Card number: ");
		 String debitcardNo;
		  try
		  {
			debitcardNo=br.readLine();
			if(!objcollectionclass.cardandBankdetails().containsKey(debitcardNo))
				assertFalse(true,"InValid Card number");
			boolean d=objdebitcardservice.validcard(debitcardNo);
			System.out.println(d);
			assertTrue(d);
			System.out.println(d);
			
		}
		  catch (IOException e)
		  {
			e.printStackTrace();
		}
		
	 }
	 @Test
	 public void cardandcvvtesting()
	 {
		 System.out.println("Enter the Debit Card number: ");
		 String debitcardNo;
		 try
		 {
			 debitcardNo=br.readLine();
			 System.out.println("Enter the CVV: ");
			 String cvv=br.readLine();
			 boolean actual=objdebitcardservice.cardandcvv(debitcardNo, cvv);
			 assertEquals(true, actual);
		 }
		 catch(IOException e)
		 {
			 
		 }
	 }
	 @Test
	 public void getBankAccountNotesting()
	 {
		 System.out.println("Enter the Debit Card number: ");
		 try {
			String debitcardNo=br.readLine();
			
			 String expected=(String)objdebitcardservice.getBankAccountNo(debitcardNo);
			 System.out.println(expected);
			 String actual=(String)objcollectionclass.cardandBankdetails().get(debitcardNo);
			 System.out.println(actual);
			 assertEquals(actual,expected);
			
		} 
		 catch (IOException e) 
		 {
			
			e.printStackTrace();
		}
		 
	 }
	 @Test
	 public void getwalletamounttesting()
	 {
		 System.out.println("Enter the WalletId: ");
		 try 
		 {
			String walletid=br.readLine();
			int wid=Integer.parseInt(walletid);
			double actual = objwalletservice.getwalletamount(wid);
			double expected = objcollectionclass.walletdetails().get(wid).getWalletamount();
			assertEquals(expected,actual,0.02);
		} catch (IOException e)
		 {
			
			e.printStackTrace();
		}
		 
	 }
	 @Test
	 public void verifywalletIdtesting()
	 {
		 System.out.println("Enter walletId: ");
		 try
		 {
			 String walletid=br.readLine();
				int wid=Integer.parseInt(walletid);
			boolean actual = objwalletservice.verifywalletId(wid);
			
			assertEquals(true, actual,"InValid WalletId");
		} 
		 catch (IOException e)
		 {
			
			e.printStackTrace();
		}
	 }
	 
}
