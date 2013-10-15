import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
/**
 * This class generates user interface for withdrawal form
 * @author Sudhanshu Mishra
 *
 */
public class WithdrawWindow {
    private double balance=20000;

	public WithdrawWindow() {
		final JFrame frame = new JFrame("Withdraw Cash");
	    JPanel northPanel = new JPanel();
	    JPanel southPanel = new JPanel();
	    JPanel centerPanel = new JPanel();
	    JPanel topCentralPanel = new JPanel();
	    JPanel bottomCentralPanel = new JPanel();
	    JButton cmdSubmit = new JButton("Submit");
	    JLabel northLabel = new JLabel("Money Withdrawal Form");
	    final JLabel southLabel = new JLabel("Status Bar");
	    JLabel lblBalance = new JLabel("Balance: ");
	    final JLabel lblBalanceValue = new JLabel(String.valueOf(balance));
	    JLabel lblAmount = new JLabel("Amount to be withdrawn: ");
	    final JTextField txtAmount = new JTextField(10);
	    
	    //Styles
	    northLabel.setForeground(Color.GRAY);
	    southPanel.setBorder(BorderFactory.createEtchedBorder());
	    lblBalanceValue.setForeground(Color.GREEN);
	    
	    //Appending respective widgets to respective panels
	    northPanel.add(northLabel);
	    southPanel.add(southLabel);
	    topCentralPanel.add(lblBalance);
	    topCentralPanel.add(lblBalanceValue);
	    bottomCentralPanel.add(lblAmount);
	    bottomCentralPanel.add(txtAmount);
	    bottomCentralPanel.add(cmdSubmit);
	    centerPanel.add(topCentralPanel);
	    centerPanel.add(bottomCentralPanel);
	    centerPanel.setLayout(new GridLayout(2,1));
	    centerPanel.setBounds(new Rectangle(200,20,10,10));
	    Border current = centerPanel.getBorder();
	    Border empty = new EmptyBorder(40, 0, 0, 0);
	    if (current == null){
	    	centerPanel.setBorder(empty);
	    }else{
	    	centerPanel.setBorder(new CompoundBorder(empty, current));
	    }
	    
	    //Appending respective blocks of the layout to the main frame
	    frame.add(northPanel, BorderLayout.NORTH);
	    frame.add(southPanel, BorderLayout.SOUTH);
	    frame.add(centerPanel, BorderLayout.CENTER);
	        	    
	    //Action Listeners
	    cmdSubmit.addActionListener(new ActionListener(){
	    	@Override
			public void actionPerformed(ActionEvent arg0) {
 				try{
		    		if(txtAmount.getText().intern()==""){
	 					southLabel.setForeground(Color.RED);
	 					southLabel.setText("Please enter amount to be withdrawn");
	 					txtAmount.requestFocus();
	 				}else{
	 					if(Double.parseDouble(txtAmount.getText())<=balance){
	 						balance -= Double.parseDouble(txtAmount.getText());
	 						lblBalanceValue.setText(String.valueOf(balance));
	 						southLabel.setText("Withdrawal successful, Please collect" +
	 								"your money");
	 						southLabel.setForeground(Color.GREEN);
	 					}else{
	 						southLabel.setText("Withdrawal failed");
	 						southLabel.setForeground(Color.RED);
	  					}
	 				}
 				}catch (Exception e){
 					southLabel.setForeground(Color.RED);
 					southLabel.setText("Please enter a valid amount to withdraw");
 					txtAmount.setText("");
 					txtAmount.requestFocus();
 				}
 			}
    	
	    });
	    
	    //Configuring frame
	    frame.setSize((int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth()-700,
	    		300);
	    frame.setLocationRelativeTo(null);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	}
}
