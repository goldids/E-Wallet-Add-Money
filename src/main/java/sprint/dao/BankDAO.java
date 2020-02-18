package sprint.dao;
import java.util.*;
import sprint.collectionsutil.*;
import sprint.bean.*;
public class BankDAO implements BankinfoDAO{
	CollectionClass util=new CollectionClass();
	Map bankinfo=util.bankdetails();
	public double checkBankamount(String accountNo)
	{
		
		 BankAccount s=(BankAccount) bankinfo.get(accountNo);
		 return s.getAmount();
		
	}
	public boolean validBankaccount(String accountNo)
	{
		boolean flag=true;
		return bankinfo.containsKey(accountNo)?flag:!flag;
	}
	public void updateBankamout(String accountNo,double amount)
	{
		 BankAccount s=(BankAccount) bankinfo.get(accountNo);
		 double finalamount=s.getAmount()-amount;
		 s.setAmount(finalamount);
	}
}