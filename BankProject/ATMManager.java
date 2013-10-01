import java.io.*;
/**
 * This class uses BankAccount class to implement ATM management for an account
 * @author mrsud
 *
 */
public class ATMManager {
	public static void main(String[] args){
        BankAccount[] accounts = null;
		try{
        	String serializedFile = "/home/user/workspace/BankAccountProject/src/data/bankAccounts.ser";
			FileInputStream fileIn = new FileInputStream(serializedFile);
	        ObjectInputStream in = new ObjectInputStream(fileIn);
	        accounts = (BankAccount[])in.readObject();
	        in.close();
	        fileIn.close();

        }
        catch(IOException i){
        	 i.printStackTrace();
        }catch(ClassNotFoundException c){
            System.out.println("BankAccount class not found");
            c.printStackTrace();
            return;
        }
        
		String fileName="/home/user/workspace/BankAccountProject/src/data/address.txt";
		FileWriter output = null;
		try {
			output = new FileWriter(fileName);
			BufferedWriter writer = new BufferedWriter(output);
			String address;
			for(int i=0;i<5;i++){
	        	address = accounts[i].personal.address;
	        	//System.out.println(address);
	        	writer.write(address+"\n");	
			}
			writer.close();
			output.close();
			
		}
		catch(IOException e){
			e.printStackTrace();
		} finally {
	      if (output != null) {
	          try {
	            output.close();
	          } catch (IOException e) {
	            e.printStackTrace();
	          }
	      }
		}

		
		
		
		
		
		
		
		/*
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
	*/
	}
}
