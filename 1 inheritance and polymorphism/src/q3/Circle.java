package q3;

public class Circle extends Point {
	private int radius;
	private final double PI = 3.14;

	public Circle(float x, float y, int radius) {
		super(x, y);
		setRadius(radius);
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public float area() {
		return ((float) PI * this.radius * this.radius);
	}

	@Override
	public void show() {
		super.show();
		System.out.print(", radius:" + this.radius);
	}

}
