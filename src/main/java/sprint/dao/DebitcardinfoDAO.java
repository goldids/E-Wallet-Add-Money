package sprint.dao;

public interface DebitcardinfoDAO {
	boolean validcard(String cardNo);
	boolean cardandcvv(String cardno,String cvv);
	String getBankAccountNo(String cardNo);
}
