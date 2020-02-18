package sprint.service;

public interface DebitcardService {
	boolean validcard(String cardNo);
	boolean cardandcvv(String cardno,String cvv);
	String getBankAccountNo(String cardNo);

}
