import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import sun.awt.VerticalBagLayout;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;

/**
 * This class uses BankAccount class to implement ATM management for an account
 * @author mrsud
 *
 */
public class ATMManager {
	
	public static void main(String[] args){
		final Map<String, BankAccount> accountData = new HashMap<String, BankAccount>(); 
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
		/*
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
		

		
		//System.out.println("\nAccounts having duplicate address:");
		for (Entry<String, ArrayList<BankAccount>> entry : duplicateAddressAcc.entrySet()){
		    String tempAdd = entry.getKey();
		    for(int i=0; i<entry.getValue().size();i++){
		    	//System.out.println(tempAdd + " " + entry.getValue().get(i).accountNo);
		    }
		}
		
		//System.out.println("\nAccounts with more than 100000 balance");
		List<BankAccount> goodAccounts = new ArrayList<BankAccount>();
		for(int i=0;i<5;i++){
			if(accounts[i].getBalance()>100000)
				goodAccounts.add(accounts[i]);
		}
		
		for(int i=0;i<goodAccounts.size();i++){
			//System.out.println(goodAccounts.get(i).personal.name);
		}

		*/
		
		
//---------------------------------------------------------------LAB EXAM CODE------------------------------------------------------------------
		
		
		
		final JFrame frame = new JFrame("Account Viewer");
		final JPanel centerPanel = new JPanel();
		JPanel westPanel = new JPanel();
		final JPanel southPanel = new JPanel();
		final JPanel centerPanelView = new JPanel();
		JLabel lblAccNoView = new JLabel("Account No: ");
		final JTextField txtAccNoView = new JTextField(12);
		final JButton cmdSubmitView = new JButton("View");
		
		JButton cmdAdd = new JButton("Add");
		JButton cmdView = new JButton("View");
		final JButton cmdSubmit = new JButton("Submit");
		JLabel lblAccNo = new JLabel("Account No: ");
	    final JTextField txtAccNo = new JTextField(12);
	    JLabel lblName = new JLabel("Name: ");
	    final JTextField txtName = new JTextField(12);
	    JLabel lblAddress = new JLabel("Address: ");
	    final JTextField txtAddress = new JTextField(20);
	    JLabel lblBal = new JLabel("Balance: ");
	    final JTextField txtBal = new JTextField(12);
	   
	    //Configuring centerPanel
	    txtAccNo.setSize(20,500);
	    centerPanel.setLayout(new GridLayout(4,2,50,50));
	    
	    centerPanel.add(lblAccNo);
	    centerPanel.add(txtAccNo);
	    centerPanel.add(lblName);
	    centerPanel.add(txtName);
	    centerPanel.add(lblAddress);
	    centerPanel.add(txtAddress);
	    centerPanel.add(lblBal);
	    centerPanel.add(txtBal);
	    centerPanel.setVisible(false);
	    
	    
	    
	    //Configuring westPanel
		westPanel.setLayout(new GridLayout(2,1,100,50));
	    westPanel.add(cmdAdd);
		westPanel.add(cmdView);
		
		//Configuring southPanel
		southPanel.add(cmdSubmit);
		
		
		//Configuring centerPanelView
		centerPanelView.setLayout(new GridLayout(4,2,50,50));
		JLabel lblNameView = new JLabel("Name: ");
		final JLabel lblNameValue = new JLabel();
		JLabel lblAddressView = new JLabel("Address: ");
		final JLabel lblAddressValue = new JLabel();
		JLabel lblBalView = new JLabel("Balance: ");
		final JLabel lblBalValue = new JLabel();
		
		final JLabel lblError = new JLabel();
		southPanel.add(lblError);
		lblError.setForeground(Color.RED);
		/*
		JPanel table = new JPanel();
		table.add(lblNameView);
		table.add(lblNameValue);
		table.add(lblAddressView);
		table.add(lblAddressValue);
		table.add(lblBalView);
		table.add(lblBalValue);
		*/
		
		lblNameValue.setForeground(Color.BLUE);
		lblAddressValue.setForeground(Color.BLUE);
		lblBalValue.setForeground(Color.BLUE);
		centerPanelView.add(lblAccNoView);
		centerPanelView.add(txtAccNoView);
		centerPanelView.add(lblNameView);
		centerPanelView.add(lblNameValue);
		centerPanelView.add(lblAddressView);
		centerPanelView.add(lblAddressValue);
		centerPanelView.add(lblBalView);
		centerPanelView.add(lblBalValue);
		//centerPanelView.add(table);
		centerPanelView.setVisible(false);
		
		//Configuring window
		frame.add(westPanel, BorderLayout.WEST);
	    frame.add(southPanel, BorderLayout.SOUTH);
		frame.setSize((int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth()-700,300);
	    frame.setLocationRelativeTo(null);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
		
	    //Defining ActionListeners 
	    cmdAdd.addActionListener(new ActionListener(){
	    	@Override
			public void actionPerformed(ActionEvent arg0) {
	    		frame.add(centerPanel, BorderLayout.CENTER);
	    		centerPanelView.setVisible(false);
	    		centerPanel.setVisible(true);
	    		southPanel.add(cmdSubmit);
	    		cmdSubmitView.setVisible(false);
	    		cmdSubmit.setVisible(true);
	    		lblError.setVisible(false);
	    		
 			}
	    });
		
	    cmdView.addActionListener(new ActionListener(){
	    	@Override
			public void actionPerformed(ActionEvent arg0) {
	    		frame.add(centerPanelView, BorderLayout.CENTER);
	    		centerPanel.setVisible(false);
	    		centerPanelView.setVisible(true);
	    		southPanel.add(cmdSubmitView);
	    		cmdSubmitView.setVisible(true);
	    		cmdSubmit.setVisible(false);
	    		lblError.setText("");
	    		lblError.setVisible(true);
	    	}
	    });
		
	    
	    cmdSubmit.addActionListener(new ActionListener(){
	    	@Override
			public void actionPerformed(ActionEvent arg0) {
	    		BankAccount tempAcc = new BankAccount(Double.valueOf(txtBal.getText()),txtName.getText(),txtAddress.getText(),"1234");
	    		accountData.put(txtAccNo.getText(), tempAcc);
	    		txtAccNo.setText("");
	    		txtName.setText("");
	    		txtAddress.setText("");
	    		txtBal.setText("");
	    		centerPanel.setVisible(false);
	    		
 			}
	    });
	    
	    cmdSubmitView.addActionListener(new ActionListener(){
	    	@Override
			public void actionPerformed(ActionEvent arg0) {
	    		if(accountData.containsKey(txtAccNoView.getText())){
	    			lblNameValue.setText(accountData.get(txtAccNoView.getText()).personal.name);
	    			lblAddressValue.setText(accountData.get(txtAccNoView.getText()).personal.address);
	    			lblBalValue.setText(String.valueOf(accountData.get(txtAccNoView.getText()).getBalance()));
	    			lblError.setVisible(false);
	    		}else{
	    			lblError.setText("Account No entered is invalid.");
	    			
	    		}
 			}
	    });
	    
	    
	
	
	}
	
	
	
	
}
