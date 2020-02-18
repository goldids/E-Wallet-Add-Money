package sprint.bean;

public class BankAccount {
	private String bankaccountNo;
	private String name;
	private double amount;
	private String phoneNo;
	static int count;
	private String bankName;
	
	public BankAccount(String bankaccountNo, String name, double amount, String phoneNo, String bankName) {
		super();
		this.bankaccountNo = bankaccountNo;
		this.name = name;
		this.amount = amount;
		this.phoneNo = phoneNo;
		this.bankName = bankName;
	}
	
	public String getBankaccountNo() {
		return bankaccountNo;
	}

	public void setBankaccountNo(String bankaccountNo) {
		this.bankaccountNo = bankaccountNo;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public static int getCount() {
		return count;
	}
	public static void setCount(int count) {
		BankAccount.count = count;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	


}
