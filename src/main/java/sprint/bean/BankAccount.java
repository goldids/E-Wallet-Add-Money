package sprint.bean;
/*
 * Bean class of BankAccount 
 */
public class BankAccount {
	private String bankaccountNo;
	private String name;
	private double amount;
	private String phoneNo;
	private String bankName;
	/*
	 * Constructor for BankAccount to initialize the instance variables:
	 * Here instance variable are bankacccountNo,name,amount,phoneNo,bankName
	 */
	public BankAccount(String bankaccountNo, String name, double amount, String phoneNo, String bankName) {
		super();
		this.bankaccountNo = bankaccountNo;
		this.name = name;
		this.amount = amount;
		this.phoneNo = phoneNo;
		this.bankName = bankName;
	}
	/*
	 * public method to get the Bank Account Number
	 */
	public String getBankaccountNo() {
		return bankaccountNo;
	}
/*
 * public method to update the bank account number
 */
	public void setBankaccountNo(String bankaccountNo) {
		this.bankaccountNo = bankaccountNo;
	}
	/*
	 * public method to get the Bank Account Holder Name
	 */
	public String getName()
	{
		return name;
	}
	/*
	 * public method to update the Bank Account Holder Name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/*
	 * public method to get the Bank Account Name
	 */
	public String getBankName() {
		return bankName;
	}
	/*
	 * public method to update the Bank Account Name
	 */
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
