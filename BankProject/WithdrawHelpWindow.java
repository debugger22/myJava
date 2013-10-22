import javax.swing.*;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.RoundRectangle2D;

public class WithdrawHelpWindow extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void main()
	{
		JFrame frame=new JFrame("withdrawal help page");
		frame.setBackground(Color.green);
		frame.getContentPane().add(new WithdrawHelpWindow());
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(800, 200);
	    frame.setVisible(true);
	}
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	   // g.draw(new Line2D.Double(x1, y1, x2, y2));
	    g.drawRect(0,0,800, 40);
	    g.drawOval(60, 95, 180, 40);
	    g.setColor(Color.black);
	    Font myfont=new Font("ComicSans",Font.BOLD,28);
        g.setFont(myfont);
	    g.drawString("Welcome to our Help Page!", 30, 30);
	    Font textfont=new Font("Times New Roman",Font.PLAIN,15);
	    g.setFont(textfont);
	    g.drawString("On the Withdraw page please enter the amount you want to withdraw in the space provided.",60,60);
	    g.drawString("Please make sure thet the amount is less than your balance.",90,90);
		g.drawString("Thank you!", 120, 120);
	    		
	  }

}
