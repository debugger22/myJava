/**
 * This class inherits BankAccount class and creates a fixed deposit account for the customer
 * @author Sudhanshu Mishra
 *
 */
public class FDAccount extends BankAccount{
	private double roi;
	private int depositFlag = 0;
	public FDAccount(double money, String name, String address, int months){
		super(money, name, address);
		if(months<=12)
			this.roi = 6;
		else if(months>12 && months<=36)
			this.roi = 7;
		else if(months>36)
			this.roi = 8;
	}
	
	/**
	* This method is created just to override the withdraw method of BankAccount class
	*/
	public void withdraw(double amount){
		System.out.println("No withdrawal allowed for FD account type");
	}
	
	/**
	* This method allows user to deposit an amount in the FD account only once
	*/
	public void deposit(double amount){
		if(depositFlag==0){
			super.deposit(amount);
			depositFlag = 1;
		}
		else{
			System.out.println("You have already deposited/transferred in this account.\nThis is only one time process for FD type of account.");
		}
	}
}
