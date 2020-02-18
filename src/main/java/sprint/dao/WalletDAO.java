package sprint.dao;
import sprint.collectionsutil.*;
import sprint.bean.*;
import java.util.Map;

public class WalletDAO implements WalletinfoDAO{
	CollectionClass util=new CollectionClass();
	Map walletinfo=util.walletdetails();
	public double getwalletamount(int walletId)
	{
		WalletAccount wallet=(WalletAccount) walletinfo.get(walletId);
		return wallet.getWalletamount();
	}
	public void updatewalletamount(int walletId,double amount)
	{
		WalletAccount wa=(WalletAccount) walletinfo.get(walletId);
		double updatedwalletamount=wa.getWalletamount()+amount;
		wa.setWalletamount(updatedwalletamount);
	}
	public boolean validwalletId(int walletId)
	{
		if(walletinfo.containsKey(walletId))
			return true;
		return false;
	}

}
