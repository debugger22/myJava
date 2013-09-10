

public class FDAccountTest {
	public static void main(String[] args){
		SavingsAccount mySavingsAccount = new SavingsAccount(10000, "Sudhanshu Mishra", "Goa, India", 7);
		FDAccount myFDAccount = new FDAccount(20000, "Sudhanshu Mishra", "Goa, India", 14);
		myFDAccount.toString();
		System.out.println("\nTrying the first deposit...");
		myFDAccount.deposit(5000);
		myFDAccount.toString();
		System.out.println("\nTrying to transfer after deposition...");
		mySavingsAccount.transfer(myFDAccount, 2000);
		myFDAccount.toString();
		System.out.println("\nTrying to deposit once again...");
		myFDAccount.deposit(1000);
		myFDAccount.toString();
		System.out.println("\nTrying to withdraw...");		
		myFDAccount.withdraw(1000);
		myFDAccount.toString();
	}
}
