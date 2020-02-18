package sprint.collectionsutil;
import java.util.*;
import sprint.bean.*;
public class CollectionClass {
	private static Map<String,BankAccount> bankinfo= new HashMap<String,BankAccount>();
	static {
		bankinfo.put("95031143280",new BankAccount("95031143280","Devraj",5000.00,"9503114328","SBI"));
		bankinfo.put("70205293790",new BankAccount("70205293790","Goldi D Singh",1000.00,"7020529379","ICICI"));
		bankinfo.put("92264349520",new BankAccount("92264349520","Pooja Singh",500.00,"9226434952","PNB"));
		bankinfo.put("93661702490",new BankAccount("93661702490","Pankaja",9000.00,"9226434952","HDFC"));
		bankinfo.put("95953999560",new BankAccount("95953999560","Ruksana",10000.00,"9595399956","Axis"));
	}
	private static Map<String,String> debitcardinfo=new HashMap<String,String>();
	static {
		debitcardinfo.put("1111222233334444","95031143280");
		debitcardinfo.put("2222333344445555","70205293790");
		debitcardinfo.put("3333444455556666","92264349520");
		debitcardinfo.put("4444333322221111","93661702490");
		debitcardinfo.put("5555333322221111","95953999560");
		
	}
	private static Map<String,String> debitcardinfom=new HashMap<String,String>();
	static {
		debitcardinfom.put("1111222233334444","123");
		debitcardinfom.put("2222333344445555","121");
		debitcardinfom.put("3333444455556666","122");
		debitcardinfom.put("4444333322221111","124");
		debitcardinfom.put("5555333322221111","125");
	}
	private static Map<Integer,WalletAccount> walletinfo=new HashMap<Integer,WalletAccount>();
	static {
		walletinfo.put(1001,new WalletAccount(1001,0.0));
		walletinfo.put(1002,new WalletAccount(1002,300.0));
		walletinfo.put(1003,new WalletAccount(1003,4000.0));
		walletinfo.put(1004,new WalletAccount(1004,2220.0));
		walletinfo.put(1005,new WalletAccount(1005,11110.0));
	}
	public Map<String,BankAccount> bankdetails()
	{
		return bankinfo;
	}
	public Map<String,String> debitcarddetails()
	{
		return debitcardinfom;
	}
	public Map<Integer,WalletAccount> walletdetails()
	{
		return walletinfo;
	}
	public Map<String,String> cardandBankdetails()
	{
		return debitcardinfo;
	}
}
