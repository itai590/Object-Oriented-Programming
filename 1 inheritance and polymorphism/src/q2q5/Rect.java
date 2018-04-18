package q2q5;

public class Rect {
	private int length = 0;
	private int width = 0;

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int area() {
		return this.length * this.width;
	}

}