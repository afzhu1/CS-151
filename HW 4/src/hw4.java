import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class hw4 {
	
	
	 public static void main(String args[]) {
		int n = 100;
		bank account1 = new bank();
		ExecutorService service = Executors.newCachedThreadPool();
		Runnable r1 = depositer(account1, 100, n);
		Runnable r2 = withdrawer(account1, 100, n);
		Runnable c = count(account1);
		service.execute(r1);
		service.execute(r2);
		service.execute(c);
	    service.shutdown();
	}
	 
	 
	 public static Runnable depositer(bank account, float amt, int repetitions) {
		 return () -> 
		 {
			 for(int i = 0; i < repetitions; i++) {
				// System.out.println("Depositing: " + amt);
				 account.deposit(amt);
				 //System.out.println("Current Balance: " + amt);
			 }
		 };
	 }
	 
	 public static Runnable withdrawer(bank account, float amt, int repetitions) {
		 return () -> 
		 {
			 for(int i = 0; i < repetitions; i++) {
				// System.out.println("Withdrawing: " + amt);
				 account.withdraw(amt);
				// System.out.println("Current Balance: " + amt);
			 }
		 };
	 }
	 
	 public static Runnable count(bank account) {
		 return () ->
		 {
			 System.out.println("Final Balance: " + account.getBalance());
		 };
	 }
	 
}
