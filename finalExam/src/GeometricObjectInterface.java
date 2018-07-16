import java.util.Date;

public interface GeometricObjectInterface {
	final static String DefaultColor = "Black";

	public Date getDateCreated();

	public double getArea();

	public double getPerimeter();

	public String getColor();
}