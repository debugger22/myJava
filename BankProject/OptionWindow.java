import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
/**
 * This class generates graphical user interface for ATM machine menu
 * @author Sudhanshu Mishra
 *
 */
public class OptionWindow {
	
	public OptionWindow() {
		final JFrame frame = new JFrame("Login Successful!");
		JPanel northPanel = new JPanel();
		JPanel centerPanel = new JPanel();
		JPanel southPanel = new JPanel();
	    JLabel northLabel = new JLabel("What would you like to do?");
	    JLabel southLabel = new JLabel("");
	    JButton cmdWithdraw = new JButton("Withdraw");
	    JButton cmdTransfer = new JButton("Transfer");
	    JButton cmdShowBalance = new JButton("Show Balance");
	    JButton cmdQuickWithdraw = new JButton("Quick Withdraw");
	    JButton cmdHelp = new JButton("Help");
	    
	    //Styles
	    southPanel.setBorder(BorderFactory.createEtchedBorder());
	    northLabel.setForeground(Color.GRAY);
	    southLabel.setForeground(Color.GRAY);
	    
	    //Appending respective widgets to respective panels
	    northPanel.add(northLabel);
	    southPanel.add(southLabel);

	    centerPanel.setLayout(new GridLayout(5,1));
	    centerPanel.add(cmdWithdraw);
	    centerPanel.add(cmdTransfer);
	    centerPanel.add(cmdShowBalance);
	    centerPanel.add(cmdQuickWithdraw);
	    centerPanel.add(cmdHelp);
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
	    cmdWithdraw.addActionListener(new ActionListener(){
	    	@Override
	    	public void actionPerformed(ActionEvent arg0) {
				WithdrawWindow wWindow= new WithdrawWindow();
				frame.dispose();
			}
 	    });
	    
	    cmdHelp.addActionListener(new ActionListener(){
	    	@Override
	    	public void actionPerformed(ActionEvent arg0) {
				MainHelpWindow mhWindow= new MainHelpWindow();
				frame.dispose();
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
