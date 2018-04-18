package q4;
public class Point {
	private float x;
	private float y;

	public Point(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public void show() {
		System.out.println();
		System.out.print("x:" + x + ", y:" + y);
	}

	public String toString() {
		return this.getX() + ", " + this.getY();
	}

	public boolean equals(Object o) {
		if (o instanceof ColorPoint)
			return false;
		else {
			Point p = (Point) o;
			if (getX() == p.getX() && getY() == p.getY())
				return true;
			else
				return false;
		}
	}
}
