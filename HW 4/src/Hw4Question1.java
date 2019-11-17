import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Hw4Question1 {
	
	
	 public static void main(String args[]) {
		//Unlocked
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
	    
	    //Synchronized
	    ExecutorService service1 = Executors.newCachedThreadPool();
	    lockedBank account2 = new lockedBank();
	    Runnable r3 = depositer(account2, 100, n);
		Runnable r4 = withdrawer(account2, 100, n);
		Runnable c1 = count(account2);
		service1.execute(r3);
		service1.execute(r4);
		service1.execute(c1);
	    service1.shutdown();
	    
	}
	 
	 
	 public static Runnable depositer(bank account, float amt, int repetitions) {
		 return () -> 
		 {
			 for(int i = 0; i < repetitions; i++) {
				 account.deposit(amt);
			 }
		 };
	 }
	 
	 public static Runnable withdrawer(bank account, float amt, int repetitions) {
		 return () -> 
		 {
			 for(int i = 0; i < repetitions; i++) {
				 account.withdraw(amt);
			 }
		 };
	 }
	 
	 public static Runnable count(bank account) {
		 return () ->
		 {
			 System.out.println("Final Unlocked Balance: " + account.getBalance());
		 };
	 }
	 
	 
	 public static Runnable depositer(lockedBank account, float amt, int repetitions) {
		 return () -> 
		 {
			 try {
				 for(int i = 0; i < repetitions; i++) {
					 account.deposit(amt);
				 }
			 } catch (InterruptedException exception) {
				 
			 }
		 };
	 }
	 
	 public static Runnable withdrawer(lockedBank account, float amt, int repetitions) {
		 return () -> 
		 {
			 try {
				 for(int i = 0; i < repetitions; i++) {
					 account.withdraw(amt);
				 }
			 } catch (InterruptedException exception) {
				 
			 }
		 };
	 }
	 
	 public static Runnable count(lockedBank account) {
		 return () ->
		 {
			 System.out.println("Final Synchronized Balance: " + account.getBalance());
		 };
	 }
	 
}
