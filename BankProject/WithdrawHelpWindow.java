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
public class WithdrawHelpWindow {

	public WithdrawHelpWindow() {
		final JFrame frame = new JFrame("Cash Withdrawal Help");
		
	    //Configuring frame
	    frame.setSize((int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth()-700,
	    		300);
	    frame.setLocationRelativeTo(null);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	}
}
