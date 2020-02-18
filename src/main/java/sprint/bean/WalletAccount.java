package sprint.bean;

public class WalletAccount {
	private int walletId;
	private double walletamount;
	public WalletAccount(int walletId,double walletamount) {
		super();
		this.walletamount = walletamount;
		this.walletId=walletId;
	}
	public int getWalletId() {
		return walletId;
	}
	public void setWalletId(int walletId) {
		this.walletId = walletId;
	}
	public double getWalletamount() {
		return walletamount;
	}
	public void setWalletamount(double walletamount) {
		this.walletamount = walletamount;
	}

}
