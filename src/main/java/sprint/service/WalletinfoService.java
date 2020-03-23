package sprint.service;
import sprint.dao.*;
public class WalletinfoService implements WalletService{
	WalletDAO walletdao = new WalletDAO();
	public double getwalletamount(int walletId)
	{
		return walletdao.getwalletamount(walletId);
	}
	public void updatewalletamount(int walletId,double amount)
	{
		walletdao.updatewalletamount(walletId, amount);
	}
	public boolean verifywalletId(int walletId)
	{
		return walletdao.validwalletId(walletId);
	}
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
	
	DebitcardDAO debitdao=new DebitcardDAO();
	public boolean validcard(String cardNo)
	{
		return debitdao.validcard(cardNo);
	}
	public boolean cardandcvv(String cardno,String cvv)
	{
		return debitdao.cardandcvv(cardno, cvv);
	}
	public String getBankAccountNo(String cardNo)
	{
		return debitdao.getBankAccountNo(cardNo);
	}

}
