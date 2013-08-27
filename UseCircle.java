
public class UseCircle {
	public static void main(String[] args){
		Circle circle1 = new Circle();
		Circle circle2 = new Circle(0,0,10);
		Circle circle3 = new Circle(2,3);
		
		circle1.setX(10);
		circle1.setRadius(20);
		circle2.translate(10, 20);
		System.out.println("Area of circle1 " + circle1.area());
		
		
		/*
		Circle[] circles = new Circle[5];
		circles[0] = new Circle(0,0,10);
		circles[1] = new Circle(0,0,30);
		circles[2] = new Circle(0,0,20);
		circles[3] = new Circle(0,0,5);
		circles[4] = new Circle(0,0,40);
		
		System.out.println("Radii before sorting");
		for(int i=0;i<circles.length;i++)
			System.out.println(i+1+" -> "+" "+circles[i].getRadius());
		
		Circle swapVar = new Circle();
		for(int i=0;i<circles.length;i++){
			for(int j=1;j<circles.length-i;j++){
				if (circles[j-1].getRadius() > circles[j].getRadius()){
					swapVar = circles[j-1];
					circles[j-1] = circles[j];
					circles[j] = swapVar;
				}
			}
		}
		System.out.println("\nRadii after sorting");
		for(int i=0;i<circles.length;i++)
			System.out.println(i+1+" -> "+" "+circles[i].getRadius());
			*/
	}
}
