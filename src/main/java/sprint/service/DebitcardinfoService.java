package sprint.service;
import sprint.dao.*;
public class DebitcardinfoService implements DebitcardService{
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
