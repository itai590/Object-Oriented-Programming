package q2q5;

public class Box extends Rect {
	private int high;

	public Box(int length, int width,int high) {
		super.setLength(length);
		setWidth(width);
		setHigh(high);
	}

	@Override
	public int area() {
		// 2(ab+ac+bc)
		int ab = super.area();
		int ac = (super.area() * this.high) / super.getWidth();
		int bc = super.getWidth() * this.high;
		return 2 * (ab + ac + bc);
	}

	public int getHigh() {
		return high;
	}

	public void setHigh(int high) {
		this.high = high;
	}

}
