import java.util.Date;

public abstract class GeometricObjectAbstractClass
		implements GeometricObjectInterface, Comparable<GeometricObjectAbstractClass> {
	private String color;
	private Date dateCreated;

	public GeometricObjectAbstractClass() {
		setColor(GeometricObjectInterface.DefaultColor);
		dateCreated = new Date();
	}

	GeometricObjectAbstractClass(String color) {
		setColor(color);
		dateCreated = new Date();
	}

	@Override
	public int compareTo(GeometricObjectAbstractClass o) {
		if (this.getArea() > o.getArea())
			return 1;
		else if (this.getArea() == o.getArea())
			return 0;
		return -1;
	}

	@Override
	public String toString() {
		return "Color=" + color + " Date created=" + dateCreated;
	}

	// *getters and setters*//

	@Override
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
}
