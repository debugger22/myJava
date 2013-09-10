/**
 * This class inherits BankAccount class and creates a checking account for the user
 * A transactional deposit account held at a financial institution that allows for withdrawals and deposits.
 * Money held in a checking account is very liquid, and can be withdrawn using checks,
 * automated cash machines and electronic debits, among other methods.
 * A checking account differs from other bank accounts in that it often allows for numerous withdrawals
 * and unlimited deposits, whereas savings accounts sometimes limit both. 
 * Checking accounts can include business accounts, student accounts and joint accounts along with
 * many other types of accounts which offer similar features.
 * 
 * This checking account has a fixed no of free transactions and if a customer crosses that limit, a certain 
 * amount of fees will be deducted from his/her account.
 * @author Sudhanshu Mishra
 */
public class CheckingAccount extends BankAccount{
	private static final int FREE_TRANS = 2;		//No. of free transactions
	private static final double TRANSACTION_FEES = 100.0;		//Fees per transaction
	private int noOfTransactions = 0;
	
	public CheckingAccount(double initialBalance, String name, String address){
		super(initialBalance,name,address);
	}
	
	/**
	* This method returns the current balance of the checking account
	*/
	public double getBalance(){
			return super.getBalance();
	}
	
	/**
	* This method deposits money in the checking account
	*/
	public void deposit(double amount){
		noOfTransactions++;
		super.deposit(amount);
	}
	
	/**
	* This method withdraws money from the checking account
	*/
	public void withdraw(double amount){
		noOfTransactions++;
		super.withdraw(amount);
	}
	
	/**
	* This method will deduct fees of transactions, if any, from the checking account and reset the
	* number of transactions to 0
	*/
	public void deductFees(){
		if(noOfTransactions > FREE_TRANS)
		{
			double fees = TRANSACTION_FEES * (noOfTransactions - FREE_TRANS);
			super.withdraw(fees);
		}
		noOfTransactions = 0;
	}
}
