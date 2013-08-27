/**
 * This class creates a rectangle with given coordinates, height and width.
 * It can be initialized in three ways Rectangle(), Rectangle(x, y, height,width) and Rectangle(x, y, height)
 * Date - 27-08-2013
 * @author Sudhanshu Mishra
 *
 */
public class Rectangle {
	public static int border=1;
	private int x, y, height, width;
	
	public Rectangle(int x, int y, int height, int width){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public Rectangle(){
		this(0,0,0,0);
	}
	
	public Rectangle(int x, int y, int height){
		this(x,y,height,height);
	}
	
	/**
	 * This method takes no argument and returns width of the rectangle
	 */
	public int getWidth(){
		return this.width;
	}
	
	/**
	 * This method takes no argument and returns height of the rectangle
	 */
	public int getHeight(){
		return this.height;
	}
	
	/**
	 * This method takes width as a parameter and changes the width of the rectangle
	 * @param width
	 */
	public void setWidth(int width){
		this.width = width;
	}
	
	/**
	 * This method takes height as a parameter and changes the height of the rectangle
	 * @param height
	 */
	public void setHeight(int height){
		this.height = height;
	}
	
	/**
	 * This method takes coordinates as parameters and shifts the rectangle with those coordinates
	 * This method returns nothing
	 * @param xcoord
	 * @param ycoord
	 */
	public void Translate(int xcoord, int ycoord){
		this.x += xcoord;
		this.y += ycoord;
	}
}
