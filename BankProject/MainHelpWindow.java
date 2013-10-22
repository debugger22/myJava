import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
/**
 * This class generates user interface for main help 
 * @author Sudhanshu Mishra
 *
 */
public class MainHelpWindow {
	
	public MainHelpWindow() {
		final JFrame frame = new JFrame("Need Help?");
		JPanel northPanel = new JPanel();
		JPanel centerPanel = new JPanel();
		JPanel southPanel = new JPanel();
	    JLabel northLabel = new JLabel("What are you looking for?");
	    JLabel southLabel = new JLabel("");
	    JButton cmdWithdrawHelp = new JButton("Withdraw Help");
	    JButton cmdTransferHelp = new JButton("Transfer Help");
	    JButton cmdShowBalanceHelp = new JButton("Show Balance Help");
	    JButton cmdQuickWithdrawHelp = new JButton("Quick Withdraw Help");
	    JButton cmdExitHelp = new JButton("Exit Help");
	    
	    //Styles
	    southPanel.setBorder(BorderFactory.createEtchedBorder());
	    northLabel.setForeground(Color.GRAY);
	    southLabel.setForeground(Color.GRAY);
	    
	    //Appending respective widgets to respective panels
	    northPanel.add(northLabel);
	    southPanel.add(southLabel);

	    centerPanel.setLayout(new GridLayout(5,1));
	    centerPanel.add(cmdWithdrawHelp);
	    centerPanel.add(cmdTransferHelp);
	    centerPanel.add(cmdShowBalanceHelp);
	    centerPanel.add(cmdQuickWithdrawHelp);
	    centerPanel.add(cmdExitHelp);
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
	    
	    cmdWithdrawHelp.addActionListener(new ActionListener(){
	    	@Override
	    	public void actionPerformed(ActionEvent arg0) {
				WithdrawHelpWindow whWindow= new WithdrawHelpWindow();
				whWindow.main();
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
