
public class bank {
	
	private float balance;
	
	public bank () {
		balance = 0;
	}
	
	public void deposit(float amt) {
		balance += amt;
	}
	
	public void withdraw(float amt) {
		balance -= amt;
	}
	
	
	
	public float getBalance() {
		return balance;
	}
}
