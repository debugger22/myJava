/**
 * This class uses BankAccount class to implement ATM management for an account
 * @author mrsud
 *
 */
public class ATMManager {
	public static void main(String[] args){
		BankAccount[] bAArray = new BankAccount[1000];
		long testAccNo = Long.parseLong(args[0]);
		String testPass = args[1];
		for(int i=0;i<1000;i++){
			bAArray[i] = new BankAccount(10000,"Sudhanshu Mishra","Goa, India");
		}
		
		int i=0;
		for(i=0;i<1000;i++){
			if(bAArray[i].accountNo==testAccNo){
				if(bAArray[i].myVerifier.password.intern()==testPass.intern()){
					System.out.println("Verification Successfull!");
					bAArray[i].myVerifier.wrongTries = 0;
				}
				else{
					if(bAArray[i].myVerifier.wrongTries==3){
						System.out.println("Err: Wrong password");
						bAArray[i].myVerifier.accountLock();
					}
					else{
						System.out.println("Err: Wrong password");
						bAArray[i].myVerifier.wrongTries += 1;
					}
				}
				break;
			}
		}
		if(i==1000){
			System.out.println("Account not found!");
		}
	}
}
