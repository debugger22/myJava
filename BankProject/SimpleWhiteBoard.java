

import java.awt.*;
import java.awt.event.*;

import javax.swing.JApplet;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class SimpleWhiteBoard extends JApplet {
  /**
	 * 
	 */
private static final long serialVersionUID = 1L;
protected int lastX=0, lastY=0;Graphics g;JMenuItem m1Open;
  public void init() {
    
    
    JMenuBar mb = new JMenuBar();  	//create a menu bar
	JMenu fileMenu = new JMenu ("COLORS"); 	//create a menu
    m1Open = new JMenuItem( "BLUE" );
    JMenuItem m2Open = new JMenuItem( "BLACK" );
    JMenuItem m3Open = new JMenuItem( "RED" );
    JMenuItem m4Open = new JMenuItem( "GREEN" );
	fileMenu.add( m1Open );// add a menu item
	fileMenu.add( m2Open );
	fileMenu.add( m3Open );
	fileMenu.add( m4Open );
	mb.add( fileMenu );
	getContentPane().add(mb,BorderLayout.NORTH);
	setBackground(Color.white);
	 g=getGraphics();
  
     m1Open.addActionListener(new ColorBLUE());
     m2Open.addActionListener(new ColorBLACK());
     m3Open.addActionListener(new ColorRED());
     m4Open.addActionListener(new ColorGREEN());
    addMouseListener(new PositionRecorder());
    addMouseMotionListener(new LineDrawer());

  }
  protected void record(int x, int y) {
    lastX = x; lastY = y;
  }
  
 class ColorBLUE implements ActionListener
 {
	 public void actionPerformed(ActionEvent e)
	 {
		 g.setColor(Color.blue);
	 }
 }
  
 class ColorBLACK implements ActionListener
 {
	 public void actionPerformed(ActionEvent e)
	 {
		 g.setColor(Color.black);
	 }
 }
 class ColorRED implements ActionListener
 {
	 public void actionPerformed(ActionEvent e)
	 {
		 g.setColor(Color.red);
	 }
 }
 class ColorGREEN implements ActionListener
 {
	 public void actionPerformed(ActionEvent e)
	 {
		 g.setColor(Color.green);
	 }
 }
  private class PositionRecorder extends MouseAdapter {
	    public void mouseEntered(MouseEvent event) {// till now this function is useless
	      requestFocus(); // Plan ahead for typing
	      record(event.getX(), event.getY());
	    }

	    public void mousePressed(MouseEvent event) {
	      record(event.getX(), event.getY());
	    }
	  }
  private class LineDrawer extends MouseMotionAdapter {
	    public void mouseDragged(MouseEvent event) {
	      int x = event.getX();
	      int y = event.getY();
	     
	      
	      g.drawLine(lastX, lastY, x, y);
	    
	     
	      
	      record(x, y);
	    }
	  }
	}