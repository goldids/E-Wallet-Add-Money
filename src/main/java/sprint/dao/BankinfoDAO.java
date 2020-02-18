package sprint.dao;

public interface BankinfoDAO {
	double checkBankamount(String accountNo);
	boolean validBankaccount(String accountNo);
	void updateBankamout(String accountNo,double amount);
}
