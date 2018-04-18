package q2q5;
public class Tester {
	public static int diff(Box a, Box b) {
		return a.area() - b.area();
	}

	public static int diff(Rect a, Rect b) {
		return a.area() - b.area();
	}

	public static int diff(Box a, Rect b) {
		return a.area() - b.area();
	}

	public static int diff(Rect a, Box b) {
		return a.area() - b.area();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rect a = new Rect();
		a.setLength(10);
		a.setWidth(20);
		Box b = new Box(10, 20, 30);

		System.out.println(a.area());
		System.out.println(b.area());

		System.out.println("aa" + diff(a, a));
		System.out.println("ab" + diff(a, b));
		System.out.println("bb" + diff(b, b));
		System.out.println("ba" + diff(b, a));

	}
}
