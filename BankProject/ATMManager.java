import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
/**
 * This class uses BankAccount class to implement ATM management for an account
 * @author mrsud
 *
 */
public class ATMManager {
	
	public static void main(String[] args){
		Map<String, BankAccount> accountData = new HashMap<String, BankAccount>(); 
		BankAccount[] accounts = null;
		try{
        	String serializedFile = "bankAccounts.ser";		//Reading BankAccounts from Serialized file
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
    	
        String fileName="details.txt";	//Writing details to details.txt
		FileWriter output = null;
		try {
			output = new FileWriter(fileName);
			BufferedWriter writer = new BufferedWriter(output);
			Long accno;
			String pwd;
			for(int i=0;i<5;i++){
	        	accno = accounts[i].accountNo;
	        	pwd = accounts[i].myVerifier.password;
	        	writer.write(accno+" "+pwd+"\n");	
	        	accountData.put(String.valueOf(accounts[i].accountNo), accounts[i]);
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
		
		for (Map.Entry<String, BankAccount> entry : accountData.entrySet()){
		    System.out.println(entry.getKey() + " " + entry.getValue().personal.name);
		}
		
		Map<String, BankAccount> duplicateAddress = new HashMap<String, BankAccount>();
		Set<String> addresses = new HashSet<String>();
		for(int i=0; i<5; i++){
			if(!addresses.add(accounts[i].personal.address)){
				//System.out.println("Duplicate address found");
				duplicateAddress.put(String.valueOf(accounts[i].accountNo), accounts[i]);
			}
		}
		
		String tempAddress;
		Map<String, ArrayList<BankAccount>> duplicateAddressAcc = new HashMap<String, ArrayList<BankAccount>>();
		for(Map.Entry<String, BankAccount> entry : duplicateAddress.entrySet()){
			tempAddress = entry.getValue().personal.address;
			ArrayList<BankAccount> tempAcc = new ArrayList<BankAccount>();
			for(int i=0;i<5;i++){
				if(accounts[i].personal.address.intern()==tempAddress.intern()){
					tempAcc.add(accounts[i]);	
				}			
			}
			duplicateAddressAcc.put(entry.getValue().personal.address, tempAcc);

		}
		

		
		System.out.println("\nAccounts having duplicate address:");
		for (Entry<String, ArrayList<BankAccount>> entry : duplicateAddressAcc.entrySet()){
		    String tempAdd = entry.getKey();
		    for(int i=0; i<entry.getValue().size();i++){
		    	System.out.println(tempAdd + " " + entry.getValue().get(i).accountNo);
		    }
		}
		
		System.out.println("\nAccounts with more than 100000 balance");
		List<BankAccount> goodAccounts = new ArrayList<BankAccount>();
		for(int i=0;i<5;i++){
			if(accounts[i].getBalance()>100000)
				goodAccounts.add(accounts[i]);
		}
		
		for(int i=0;i<goodAccounts.size();i++){
			System.out.println(goodAccounts.get(i).personal.name);
		}
		
		
	
	}
}
