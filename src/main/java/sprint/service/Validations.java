package sprint.service;

import sprint.dao.BankDAO;

public interface Validations {
	public static boolean validateId(String data)
	{
		String codepattern="[1-9]";
		String temp1="";
		temp1=temp1+data.charAt(0);
		if(temp1.matches(codepattern))
		{
		codepattern = "[0-9]";
		
		for(int i=1;i<data.length()-1;i++)
		{
				String temp="";
			temp=temp+data.charAt(i);
			if(temp.matches(codepattern))
				continue;
			else
				return false;
		}
		return true;
		}
		return false;
			
	}
	public static boolean walletlength(String walletId)
	{
		int length=4;
		int walletIdsize=walletId.length();
		if(length==walletIdsize)
			return true;
		return false;
	}
	public static boolean bankaccountlength(String accountNo)
	{
		int length=11;
		int accountNosize=accountNo.length();
		if(length==accountNosize)
			return true;
		return false;
	}
	public static boolean debitcardlength(String debitcard)
	{
		int length=16;
		int debitcardsize=debitcard.length();
		if(length==debitcardsize)
			return true;
		return false;
	}
	public static boolean phoneNolength(String phoneNo)
	{
		int length=10;
		int phoneNolength=phoneNo.length();
		if(length==phoneNolength)
			return true;
		return false;
	}
	public static boolean amount(String amount)
	{
		if(amount.equals("0"))
			return false;
		return true;
	}
}
