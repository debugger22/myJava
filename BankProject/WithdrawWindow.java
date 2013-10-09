import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.KeyEvent;
//import java.awt.event.ActionListener;

import javax.swing.*;

public class WithdrawWindow {
    final JFrame frame = new JFrame("Withdraw Cash");
    JPanel centerPanel = new JPanel();

	public WithdrawWindow() {
	    JButton cmd500 = new JButton("500");
	    JButton cmd1000 = new JButton("1000");
	    JButton cmd2000 = new JButton("2000");
	    JButton cmd3000 = new JButton("3000");
	    JButton cmd5000 = new JButton("5000");
	    JButton cmd10000 = new JButton("10000");
	    JLabel lblChooseAmt = new JLabel("Choose amount to be withdrawn: ");
	    
	    
	    
	    //Styles
	    lblChooseAmt.setForeground(Color.GRAY);
	    
	    //Appending respective widgets to respective panels
	    centerPanel.add(lblChooseAmt);
	    centerPanel.add(cmd500);
	    centerPanel.add(cmd1000);
	    centerPanel.add(cmd2000);
	    centerPanel.add(cmd3000);
	    centerPanel.add(cmd5000);
	    centerPanel.add(cmd10000);

	    centerPanel.setBounds(new Rectangle(200,20,10,10));
	    int top=60;
		int left=50;
		int bottom=0;
		int right=100;
		centerPanel.setBorder(BorderFactory.createEmptyBorder(top, left, bottom, right));
	    
	    //Appending respective blocks of the layout to the main frame
	    frame.add(centerPanel, BorderLayout.CENTER);
	    
	    	    
	    //Configuring frame
	    frame.setSize((int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth()-500,
	    		200);
	    frame.setLocationRelativeTo(null);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	}

	public void showWindow(){
	    frame.setVisible(true);
	}
}
