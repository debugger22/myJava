import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
/**
 * This class generates graphical user interface for ATM machine
 * @author Sudhanshu Mishra
 *
 */
public class ATMMachine {
	public static void main(String[] args) {
	    final JFrame frame = new JFrame("ATM Machine");
	    JPanel northPanel = new JPanel();
	    JPanel southPanel = new JPanel();
	    JPanel westPanel = new JPanel();
	    JPanel eastPanel = new JPanel();
	    JPanel centerPanel = new JPanel();
	    JMenuBar menu = new JMenuBar();
	    JMenu menuHelp = new JMenu("Help");
	    JButton westCmd1 = new JButton("Button1");
	    JButton westCmd2 = new JButton("Button2");
	    JButton westCmd3 = new JButton("Button3");
	    JButton eastCmd1 = new JButton("Button1");
	    JButton eastCmd2 = new JButton("Button2");
	    JButton cmdSubmit = new JButton("Submit");
	    JButton eastCmd3 = new JButton("Button3");
	    JLabel northLabel = new JLabel("ATM Machine");
	    JLabel southLabel = new JLabel("An Extension to BankManager Class");
	    JLabel lblAccNo = new JLabel("Account No: ");
	    JLabel lblPIN = new JLabel("Password: ");
	    final JTextField txtAccNo = new JTextField(12);
	    final JTextField txtPIN = new JPasswordField(10);
	    
	    
	    
	    //Styles
	    centerPanel.setBorder(BorderFactory.createEtchedBorder());
	    northLabel.setForeground(Color.GRAY);
	    southLabel.setForeground(Color.GRAY);
	    
	    //Appending respective widgets to respective panels
	    northPanel.add(northLabel);
	    southPanel.add(southLabel);
	    westPanel.add(westCmd1);
	    westPanel.add(westCmd2);
	    westPanel.add(westCmd3);
	    eastPanel.add(eastCmd1);
	    eastPanel.add(eastCmd2);
	    eastPanel.add(eastCmd3);
	    eastPanel.setLayout(new GridLayout(3,1));
	    westPanel.setLayout(new GridLayout(3,1));

	    //centerPanel.setLayout(new GridLayout(3,2));
	    centerPanel.add(lblAccNo);
	    centerPanel.add(txtAccNo);
	    centerPanel.add(lblPIN);
	    centerPanel.add(txtPIN);
	    centerPanel.add(cmdSubmit);
	    centerPanel.setBounds(new Rectangle(200,20,10,10));
	    
	    //Appending respective blocks of the layout to the main frame
	    frame.add(northPanel, BorderLayout.NORTH);
	    frame.add(southPanel, BorderLayout.SOUTH);
	    frame.add(westPanel, BorderLayout.WEST);
	    frame.add(eastPanel, BorderLayout.EAST);
	    frame.add(centerPanel, BorderLayout.CENTER);
	    cmdSubmit.setPreferredSize(new Dimension(100,30));
	    
	    //Designing menu
	    JMenuItem menuItemHelp = new JMenuItem("Help");
	    JMenuItem menuItemAbout = new JMenuItem("About");
	    menuHelp.add(menuItemHelp);
	    menuHelp.add(menuItemAbout);
	    menu.add(menuHelp);
	    menuHelp.setMnemonic(KeyEvent.VK_H);
	    
	    //Setting EventListeners to menu items and buttons
	    menuItemAbout.addActionListener(new ActionListener(){
	 			@Override
				public void actionPerformed(ActionEvent arg0) {
	 				showAbout(frame);
				}
	    	});
	    
	    cmdSubmit.addActionListener(new ActionListener(){
	    	@Override
			public void actionPerformed(ActionEvent arg0) {
 				if(txtAccNo.getText().intern()=="" || txtPIN.getText().intern()==""){
 					System.out.println("Please enter Account number and password to proceed.");
 				}else{
 					//TODO Verification thing will go here
 					frame.setVisible(false);
 					WithdrawWindow wWindow= new WithdrawWindow();
					wWindow.showWindow();
				
 				}
 			}
    	
	    });
	    
	    //Configuring frame
	    frame.setJMenuBar(menu);
	    frame.setSize((int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth()-500,
	    		200);
	    frame.setLocationRelativeTo(null);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	    
	}
	
	/**
	 * This method shows about dialog box
	 * @param frame
	 */
	private static void showAbout(JFrame frame){
		final JDialog dialog = new JDialog(frame, "About");
		JLabel lblPlatform = new JLabel("Developed on JDK v7");
		JLabel lblDeveloper = new JLabel("Developed by: Sudhanshu Mishra");
		JLabel lblLicense = new JLabel("License: Apache v2");
		JPanel mainPanel = new JPanel();
		
		//Styles
		lblLicense.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		lblLicense.setForeground(Color.GRAY);
		lblPlatform.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		lblPlatform.setForeground(Color.GRAY);
		lblDeveloper.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		lblDeveloper.setForeground(Color.GRAY);
		
		//Appending respective widgets to mainPanel
		mainPanel.add(lblLicense);
		mainPanel.add(lblPlatform);
		mainPanel.add(lblDeveloper);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
		
		//Configuring Dialog
		dialog.add(mainPanel, BorderLayout.CENTER);
		dialog.setSize(400,150);
		dialog.setLocationRelativeTo(null);
		dialog.setVisible(true);
		
	}
	
}
