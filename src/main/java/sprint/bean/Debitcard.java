package sprint.bean;

public class Debitcard{
	private String cardNo;
	private String cvv;
	public Debitcard(String cardNo, String cvv) {
		this.cardNo = cardNo;
		this.cvv = cvv;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	

}
