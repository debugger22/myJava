
public class AccountTest {
	public static void main(String[] args){
		BankAccount account1 = new BankAccount(5000,"G.M. Mishra","Gorakhpur, Uttar Pradesh, PIN - 273209");
		BankAccount account2 = new BankAccount(2000, "Sudhanshu Mishra", "BITS Pilani Goa Campus, South Goa, Goa, Pin - 403726");
		account1.toString();
		account2.toString();
		System.out.println("\nCalling withdraw...\n");
		account2.withdraw(1000);
		System.out.println("\nSummary of account1");
		account1.toString();
		System.out.println("\nSummary of account2");
		account2.toString();
		System.out.println("\nCalling deposit...\n");
		account2.deposit(4000);
		System.out.println("\nSummary of account1");
		account1.toString();
		System.out.println("\nSummary of account2");
		account2.toString();
		System.out.println("\nCalling transfer...\n");
		account2.transfer(account1,1000);
		System.out.println("\nSummary of account1");
		account1.toString();
		System.out.println("\nSummary of account2");
		account2.toString();
		}
}
