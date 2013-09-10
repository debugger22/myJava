
public class CheckingAccountTest {
	public static void main(String[] args){
		CheckingAccount myCheckingAccount = new CheckingAccount(20000, "Sudhanshu Mishra", "Goa, India");
		myCheckingAccount.toString();
		myCheckingAccount.deposit(1000);
		myCheckingAccount.toString();
		myCheckingAccount.deposit(1000);
		myCheckingAccount.toString();
		myCheckingAccount.deposit(1000);
		myCheckingAccount.toString();
		myCheckingAccount.withdraw(500);
		myCheckingAccount.toString();		
		myCheckingAccount.deductFees();
		myCheckingAccount.toString();		
	}
}
