package q4;
public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point p1 = new Point(1,1);
		Point p2 = new Point(1,2);
		Point p3 = new Point(3,3);
		Point p4 = new Point(1,1);
		
		ColorPoint cp1 = new ColorPoint (11,11,"rED");
		ColorPoint cp2 = new ColorPoint (22,22,"y");
		ColorPoint cp3 = new ColorPoint (11,11,"z");
		ColorPoint cp4 = new ColorPoint (11,11,"red");
		
		System.out.println(p1.toString());
		System.out.println(p2.toString());
		System.out.println(p3.toString());
		System.out.println(p4.toString());
		
		System.out.println(cp1.toString());
		System.out.println(cp2.toString());
		System.out.println(cp3.toString());
		System.out.println(cp4.toString());
		
		System.out.println("true "+cp1.equals(cp4));
		System.out.println("f "+cp1.equals(cp2));
		System.out.println("f "+cp1.equals(cp3));
		System.out.println("f "+cp1.equals(p4));
		System.out.println("t "+p1.equals(p4));
		System.out.println("f "+p2.equals(p4));
		
		


	}

}
