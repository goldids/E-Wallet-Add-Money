package sprint.dao;

public interface WalletinfoDAO {
	double getwalletamount(int walletId);
	void updatewalletamount(int walletId,double amount);
}