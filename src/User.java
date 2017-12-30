
public class User {
	private long balance;
	long pinNum;
	long cardNum;
	User(long balance, long pinNum, long cardNum){
		this.balance = balance;
		this.pinNum = pinNum;
		this.cardNum = cardNum;
	}
	public boolean equals(Object other) {
		if(this == other) {
			return true;
		}
		if(null == other) {
			return false;
		}
		if(!(other instanceof User)) {
			return false;
		}
		User that = (User) other;
		if(that.cardNum == this.cardNum) {
			return true;
		}else {
			return false;
		}
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long arg0) {
		balance = arg0;
	}
}
