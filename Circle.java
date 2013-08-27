/**
 * This class creates circle with 3 possible methods
 * Circle(), Circle(x,y) and Circle(x,y, radius)
 * The missing parameters in first two types are automatically set to 0
 * This class has a class level public field PI which is equal to 3.14 by default
 * 
 * @author Sudhanshu Mishra
 *
 */
public class Circle {
	public static double PI = 3.14;
	private int x, y, radius;
	
	public Circle(int x, int y, int radius){
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	public Circle(){
		this(0,0,0);
	}
	
	public Circle(int x, int y){
		this(x,y,0);
	}
	
	/**
	 * This method returns x-coordinate of the circle
	 * @return x-xoordinate
	 */
	public int getX(){
		return this.x;
	}
	
	/**
	 * This method takes an integer as an argument and changes the
	 * x-coordinate of the circle.
	 * This method doesn't return anytghing
	 * @param x
	 */
	public void setX(int x){
		this.x = x;
	}
	
	/**
	 * This method takes no parameter but returns the radius of the circle
	 * @return radius
	 */
	public int getRadius(){
		return this.radius;
	}
	
	/**
	 * This method takes an integer as a parameter and changes
	 * the radius of the circle
	 * This method doesn't return anything
	 * @param radius
	 */
	public void setRadius(int radius){
		this.radius = radius;
	}
	
	/**
	 * This method takes two integers as parameters and shifts the coordinates
	 * of the circle by that amount
	 * This method returns nothing
	 * @param a
	 * @param b
	 */
	public void translate(int a, int b){
		this.x += a;
		this.y += b;
	}
	
	/**
	 * This method takes no parameter but returns area of the circle
	 * It uses the class level field PI for the calculation
	 */
	public double area(){
		return PI * this.radius * this.radius; 
	}


}
