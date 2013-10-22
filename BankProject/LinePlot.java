import java.applet.*; 
import java.awt.*;
import java.io.*;

import javax.swing.JOptionPane;
	
public class LinePlot extends Applet{
	
    private static final long serialVersionUID = 1L;
	int width, height;
	int m,c;   
	
	public void init(){ 
		try{
			//BufferedReader ob=new BufferedReader (new InputStreamReader(System.in));
		    //System.out.println("ENTER NUMBER M:");
		    //m=Integer.parseInt(ob.readLine());
		    //System.out.println("ENTER NUMBER C:");
		    //c=Integer.parseInt(ob.readLine());
		    String tempM = JOptionPane.showInputDialog("Enter m");
			String tempC = JOptionPane.showInputDialog("Enter c");
			m = Integer.parseInt(tempM);
			c = Integer.parseInt(tempC);
		   }
		catch(Exception e){
		
		}
		
		width = getSize().width;      
		height = getSize().height;    
		setBackground( Color.black );  
	}   
	
	public void paint(Graphics g){    
		g.setColor( Color.gray);      
		
		int x=width/10;
		for(int i=1;i<=20;i++){
        	g.drawLine( x*i, 0, x*i, height );
        }
		
		int y=height/10;
		for(int i=1;i<=10;i++){
			g.drawLine(0,y*i,width,y*i);
		}
		
		g.setColor(Color.orange);
		
		int xco;
		int yco;
		for(int i=0;i<10;i++){
			yco = i*x;
			for(int j=0;j<10;j++){
				xco = j*y;
				g.drawString(String.valueOf(yco)+", "+String.valueOf(xco),yco+5,xco+15);
			}
			
		}
		
		g.setColor(Color.red);
		
		
		if(c!=0){
			g.drawLine(0, (int)c, (int)c/m, 0);
		}
		else{
			g.drawLine(width,height,  (width/2)+(x*3), (height/2)-(m*(y*3)));
		}
		
		
	}
}
