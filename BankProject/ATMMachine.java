import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
/**
 * This class generates graphical user interface for ATM machine
 * @author Sudhanshu Mishra
 *
 */
public class ATMMachine {
	private static int attemptCount=0;
	
	public static void main(String[] args) {
		final JFrame frame = new JFrame("ATM Machine");
	    JPanel northPanel = new JPanel();
	    JPanel southPanel = new JPanel();
	    JPanel centerPanel = new JPanel();
	    JMenuBar menu = new JMenuBar();
	    JMenu menuHelp = new JMenu("Help");
	    JButton cmdSubmit = new JButton("Submit");
	    JLabel northLabel = new JLabel("ATM Machine");
	    final JLabel southLabel = new JLabel("An Extension to BankManager Class");
	    JLabel lblAccNo = new JLabel("Account No: ");
	    JLabel lblPIN = new JLabel("Password: ");
	    final JTextField txtAccNo = new JTextField(12);
	    final JTextField txtPIN = new JPasswordField(10);
	    
	    
	    
	    
	    //Styles
	    southPanel.setBorder(BorderFactory.createEtchedBorder());
	    northLabel.setForeground(Color.GRAY);
	    southLabel.setForeground(Color.GRAY);
	    
	    //Appending respective widgets to respective panels
	    northPanel.add(northLabel);
	    southPanel.add(southLabel);

	    //centerPanel.setLayout(new BorderLayout(10,20));
	    centerPanel.add(lblAccNo);
	    centerPanel.add(txtAccNo);
	    centerPanel.add(lblPIN);
	    centerPanel.add(txtPIN);
	    centerPanel.add(cmdSubmit);
	    centerPanel.setBounds(new Rectangle(200,20,10,10));
	    Border current = centerPanel.getBorder();
	    Border empty = new EmptyBorder(70, 0, 0, 0);
	    if (current == null){
	    	centerPanel.setBorder(empty);
	    }else{
	    	centerPanel.setBorder(new CompoundBorder(empty, current));
	    }
	    
	    
	    //Appending respective blocks of the layout to the main frame
	    frame.add(northPanel, BorderLayout.NORTH);
	    frame.add(southPanel, BorderLayout.SOUTH);
	    frame.add(centerPanel, BorderLayout.CENTER);
	    
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
 					southLabel.setForeground(Color.RED);
 					southLabel.setText("Please enter Account number and password to proceed.");
 					txtAccNo.requestFocus(); 					
 				}else{
 					if(txtAccNo.getText().intern()!="123" || txtPIN.getText().intern()!="456"){
 						if(attemptCount==2)
 							System.exit(0);
 						attemptCount++;
 						southLabel.setForeground(Color.RED);
 						southLabel.setText("Wrong account no. or password. Wrong attempt(s): "+attemptCount);
 						txtAccNo.setText("");
 						txtPIN.setText("");
 						txtAccNo.requestFocus();
 						return;
 					}else{
 						OptionWindow oWindow= new OptionWindow();
 						frame.dispose();
 					}
 				}
 			}
    	
	    });
	    
	    //Configuring frame
	    frame.setJMenuBar(menu);
	    frame.setSize((int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth()-700,
	    		300);
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
