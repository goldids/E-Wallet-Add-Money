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
		if(debitmap.containsKey(cardNo))
			return true;
		return false;
	}
	
	public boolean cardandcvv(String cardno,String cvv)
	{
		if((boolean)debitmap.get(cardno).equals(cvv))
			return true;
		return false;
	}
	public String getBankAccountNo(String cardNo)
	{
		Map BankandCard=util.cardandBankdetails();
		return (String)BankandCard.get(cardNo);
	}
}
