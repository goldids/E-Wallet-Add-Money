package sprint.service;

public interface BankService {
	double checkBankamount(String accountNo);
	boolean validBankaccount(String accountNo);
	void updateBankamout(String accountNo,double amount);

}
