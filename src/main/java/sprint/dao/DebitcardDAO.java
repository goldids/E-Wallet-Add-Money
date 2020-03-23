package sprint.dao;
import sprint.collectionsutil.*;
import sprint.bean.*;
import java.util.Map;

import sprint.bean.*;
public class DebitcardDAO implements DebitcardinfoDAO{
	CollectionClass util = new CollectionClass();
	Map debitmap=util.debitcarddetails();
	public boolean validcard(String cardNo)
	{
		boolean flag=true;
		return (debitmap.containsKey(cardNo))?flag:!flag;

	}
	
	public boolean cardandcvv(String cardno,String cvv)
	{
		boolean flag=true;
		return ((boolean)debitmap.get(cardno).equals(cvv))?flag:!flag;
	}
	public String getBankAccountNo(String cardNo)
	{
		Map bankandCard=util.cardandBankdetails();
		return (String)bankandCard.get(cardNo);
	}
}
