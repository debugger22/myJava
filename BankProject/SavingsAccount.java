/**
 * This class inherits BankAccount class and creates a savings account for the customer
 * @author Sudhanshu Mishra
 *
 */
public class SavingsAccount extends BankAccount{
	private double roi;
	public SavingsAccount(double money, String name, String address, double roi){
		super(money, name, address);
		this.roi = roi;
	}
	
	public void addInterest(){
		double interest = (super.getBalance()*this.roi)/100;
		super.deposit(interest);
	}
	
}
