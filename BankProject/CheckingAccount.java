/**
 * This class inherits BankAccount class and creates a checking account for the user
 * @author Sudhanshu Mishra
 *
 */
public class CheckingAccount extends BankAccount{
	private static final int FREE_TRANS = 2;
	private static final double TRANSACTION_FEES = 100.0;
	private int noOfTransactions = 0;
	
	public CheckingAccount(double initialBalance, String name, String address){
		super(initialBalance,name,address,"1234");
	}
	
	public double getBalance(){
			return super.getBalance();
	}
	
	public void deposit(double amount){
		noOfTransactions++;
		super.deposit(amount);
	}
	
	public void withdraw(double amount){
		noOfTransactions++;
		super.withdraw(amount);
	}
	
	public void deductFees(){
		if(noOfTransactions > FREE_TRANS)
		{
			double fees = TRANSACTION_FEES * (noOfTransactions - FREE_TRANS);
			super.withdraw(fees);
		}
		noOfTransactions = 0;
	}
}