import java.applet.*; 
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.*;

public class OnlineATM extends JApplet{

    
	private static final long serialVersionUID = 1L;
	public void init(){
		this.add(getCustPanel());
	}
	public void start(){
		this.add(getCustPanel());
	}
	
	public void paint(Graphics g){
		
	}
	
	private JPanel getCustPanel() {
	    JPanel panel = new JPanel ();
	    JLabel lblAccNo = new JLabel("Account No: ");
	    JLabel lblPIN = new JLabel("Password: ");
	    final JTextField txtAccNo = new JTextField(12);
	    final JTextField txtPIN = new JPasswordField(10);
	    JButton cmdSubmit = new JButton ("Submit");
        panel.setLayout (new BoxLayout(panel, BoxLayout.X_AXIS));
        cmdSubmit.setPreferredSize (new Dimension(100,20));
        cmdSubmit.setAlignmentX (Component.CENTER_ALIGNMENT);
	    panel.add(lblAccNo);
	    panel.add(txtAccNo);
	    panel.add(lblPIN);
	    panel.add(txtPIN);
	    panel.add(cmdSubmit);
        return panel;
        
	}
	
	
	
}
