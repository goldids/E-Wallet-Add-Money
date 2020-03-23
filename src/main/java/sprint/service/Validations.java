package sprint.service;


public interface Validations {
	public static boolean validateId(String data)
	{
		String codepattern="[1-9]";
		String temp1="";
		temp1=temp1+data.charAt(0);
		if(temp1.matches(codepattern))
		{
		codepattern = "[0-9]";
		boolean flag=false;
		for(int i=1;i<data.length()-1;i++)
		{
				String temp="";
			temp=temp+data.charAt(i);
			
			return (!temp.matches(codepattern))?flag:!flag;
		}
		return true;
		}
		return false;
			
	}
	public static boolean walletlength(String walletId)
	{
		int length=4;
		int walletIdsize=walletId.length();
		boolean flag=true;
		return (length==walletIdsize)?flag:!flag;
	}
	public static boolean bankaccountlength(String accountNo)
	{
		int length=11;
		int accountNosize=accountNo.length();
		boolean flag=true;
		return (length==accountNosize)?flag:!flag;
			
	}
	public static boolean debitcardlength(String debitcard)
	{
		int length=16;
		int debitcardsize=debitcard.length();
		boolean flag=true;
		return (length==debitcardsize)?flag:!flag;
		
	}
	public static boolean phoneNolength(String phoneNo)
	{
		int length=10;
		int phoneNolength=phoneNo.length();
		boolean flag=true;
		return (length==phoneNolength)?flag:!flag;

	}
	public static boolean amount(String amount)
	{
		boolean flag=true;
		return amount.equals("0")?flag:!flag;
			
	}
}
