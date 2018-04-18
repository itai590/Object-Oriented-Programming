package q3;
public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point p1=new Point(2,3);
		Circle c1=new Circle (10,15,13);
		p1.show();
		p1.show();
		c1.show();
		c1.setRadius(8);
		c1.setX(7);
		c1.setY(6);
		c1.show();
		System.out.println("\narea:"+c1.area());
	}
}
