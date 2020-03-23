package sprint.service;

public interface WalletService {
	double getwalletamount(int walletId);
	void updatewalletamount(int wallletId,double amount);
	double checkBankamount(String accountNo);
	boolean validBankaccount(String accountNo);
	void updateBankamout(String accountNo,double amount);

}
