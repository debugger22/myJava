/**
 * This class creates a bank account and provides methods like deposit, withdraw,
 * getBalance and transfer
 * It automatically generates a sequential new account no for every object of the
 * class starting from 180020131111
 * @author Sudhanshu Mishra
 */
public class BankAccount {
	private double balance;
	private static long accNoIndex=180020131111L;
	private long accountNo;
	private int noOfTransactions=0;
	private double minimumBalance = 500;
	
	public BankAccount(double initialBalance){
		this.accountNo = accNoIndex;
		accNoIndex++;
		System.out.println(accountNo);
		this.balance = initialBalance;
	}
	
	public BankAccount(){
		this.balance = 0;
	}
	
	/**
	 * This method takes amount as a parameter and increases the balance of the account
	 * by amount
	 * It does not return anything
	 * @param amount
	 */
	public void deposit(double amount){
		this.balance += amount;
		this.noOfTransactions++;
	}
	
	/**
	 * This method takes amount as a parameter and decreases the balance of the account
	 * by amount
	 * It does not return anything
	 * This method takes care of the minimum balance which should be present in the account 
	 * @param amount
	 */
	public void withdraw(double amount){
		if(this.balance-amount>=this.minimumBalance){
			this.balance -= amount;
		}
		else{
			System.out.println("Insufficient balance!");
		}
		this.noOfTransactions++;
	}
	
	/**
	 * This method returns the current balance present in the account
	 * @return
	 */
	public double getBalance(){
		this.noOfTransactions++;
		return this.balance;
	}
	
	/**
	 * This method takes another account and amount as parameters and transfers
	 * money from current account to the passed(beneficiary) account
	 * This method also accounts for the noOfTransactions because it uses
	 * withdraw and deposit methods of the objects
	 * @param beneficiary
	 * @param amount
	 */
	public void tranfer(BankAccount beneficiary, double amount){
		if(this.balance - amount >=this.minimumBalance){
			this.withdraw(amount);
			beneficiary.deposit(amount);
		}
	}
}
