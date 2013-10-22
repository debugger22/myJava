

import java.awt.*;
import java.awt.event.*;

public class Whiteboard extends SimpleWhiteBoard {
	static final long serialVersionUID = 1L;
	protected FontMetrics fm;
	public void init() {
	    super.init();
	    Font font = new Font("Serif", Font.PLAIN, 20);
	    setFont(font);
	    fm = getFontMetrics(font);
	    addKeyListener(new CharDrawer());  
	}
  
	private class CharDrawer extends KeyAdapter {
	    public void keyTyped(KeyEvent event) {
	      String s = String.valueOf(event.getKeyChar());
	      Graphics d = getGraphics();
	      d.setColor(Color.red);
	      d.drawString(s, lastX, lastY);
	      record(lastX + fm.stringWidth(s), lastY);
	    }
	  }
}
