import java.io.*;

public class MyFileReader {
	public static void main(String[] args){
		String data = "";
		String fileName="/home/user/workspace/BankAccountProject/src/data/bankAccountDetailsFile";
		String serializedFile = "/home/user/workspace/BankAccountProject/src/data/bankAccounts.ser";
		String line = "";
		FileReader file = null;
		int noOfAccounts=0;
		BankAccount[] bAArray = null;
		
		try {
		file = new FileReader(fileName);
	      BufferedReader reader = new BufferedReader(file);
	      int count=0;
	      while ((line = reader.readLine()) != null) {
	    	  count ++;
	    	  if(count==1){
	    		  noOfAccounts = Integer.parseInt(line);
	    		  bAArray = new BankAccount[noOfAccounts];
	    	  }
	    	  else{
	    		  String[] parts = line.split("::");
	    		  bAArray[count-2] = new BankAccount(Integer.parseInt(parts[0]),parts[1],parts[2]);
	    	  }
	    	}
	    } catch (FileNotFoundException e) {
	      throw new RuntimeException("File not found");
	    } catch (IOException e) {
	      throw new RuntimeException("IO Error occured");
	    } finally {
	      if (file != null) {
	        try {
	          file.close();
	        } catch (IOException e) {
	          e.printStackTrace();
	        }
	      }
	    }
	    
	    //Now serializing here
	    try
	      {
		    FileOutputStream fileOut = new FileOutputStream(serializedFile);
		    ObjectOutputStream out = new ObjectOutputStream(fileOut);
		    //for(int i=0;i<noOfAccounts;i++){
		    	//out.writeObject(bAArray[i]);
		    //}
		    out.writeObject(bAArray);
		    out.close();
		    fileOut.close();
	      }catch(IOException i)
	      {
	          i.printStackTrace();
	      }
	}
}
