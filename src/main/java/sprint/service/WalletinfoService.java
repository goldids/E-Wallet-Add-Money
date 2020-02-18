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

}
