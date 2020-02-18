package sprint.service;
import sprint.dao.*;
public class BankinfoService implements BankService{
	BankDAO bankdao=new BankDAO();
	public double checkBankamount(String accountNo)
	{
		return bankdao.checkBankamount(accountNo);
	}
	public boolean validBankaccount(String accountNo)
	{
		return bankdao.validBankaccount(accountNo);		
	}
	public void updateBankamout(String accountNo,double amount)
	{
		bankdao.updateBankamout(accountNo, amount);
	}

}
