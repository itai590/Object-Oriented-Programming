package q4;

public class ColorPoint extends Point {
	private String color;

	public ColorPoint(float x, float y, String color) {
		super(x, y);
		setColor(color);

	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String toString() {
		return super.toString() + ", " + color;
	}

	public boolean equals(Object o) {
		if (!(o instanceof ColorPoint))
			return false;
		else {
			ColorPoint cp = (ColorPoint) o;
			Point p = new Point(cp.getX(), cp.getY());
			if (super.equals(p) && color.equalsIgnoreCase(cp.getColor()))
				return true;
			else
				return false;
		}
	}
}
