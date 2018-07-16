public class Circle extends GeometricObjectAbstractClass {
	private double radius;

	public Circle(double radius, String color) {
		super(color);
		this.radius = radius;
	}

	public Circle(double radius) {
		super();
		this.radius = radius;
	}

	// *getters and setters*//
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public double getDiameter() {
		return 2 * radius;
	}

	// *interface implementation*//
	@Override
	public double getArea() {
		return radius * radius * Math.PI;
	}

	@Override
	public double getPerimeter() {
		return 2 * radius * Math.PI;
	}

	@Override
	public String toString() {
		String s = "Radius=" + radius + " ";
		return s + super.toString()+"\n";
	}
	}
