
public class lockedBank {
	
	private float balance;
	
	public lockedBank() {
		balance = 0;
	}
	
	public synchronized void deposit(float amt) throws InterruptedException {
		wait();
		balance += amt;
		notifyAll();
	}
	
	public synchronized void withdraw(float amt) throws InterruptedException {
		wait();
		balance -= amt;
		notifyAll();
	}
	
	
	
	public float getBalance() {
		return balance;
	}
}
