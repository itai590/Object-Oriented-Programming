package q1q2;

import java.util.Date;
import java.util.InputMismatchException;

public class Dog extends Animal implements Comparable, Cloneable {
	private final String[] types = { "Rottweiler", "Amstaf", "Bulldog", "Poodel" };
	private final String[] dangerousTypes = { "Rottweiler", "Amstaf", "Bulldog" };
	private String type;

	public Dog(String name, boolean isSleep, String type) {
		super(name, isSleep);
		setType(type);
		// TODO Auto-generated constructor stub
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		type = type.toLowerCase();

		boolean isValidType = false;
		int i = 0;
		while (!isValidType && i < this.types.length) {
			if (types[i].equalsIgnoreCase(type))
				isValidType = true;
			i++;
		}

		try {
			if (!isValidType)
				throw new InputMismatchException("Invalid Dog Type:" + type);
		} catch (InputMismatchException ex) {
			System.err.println(ex.getMessage());
			System.exit(0);
		}

		this.type = type.substring(0, 1).toUpperCase() + type.substring(1);
	}

	@Override
	public String say() {
		if (super.isSleep())
			return "..Shhh .. the dog is sleeping now.";
		return "Hav, Hav";
	}

	@Override
	public String toString() {
		return "\nDog: " + super.getName() + ", " + super.getIsSleepState() + " ( type: " + getType() + " )";

	}

	@Override
	public boolean isDangerous() {
		for (int i = 0; i < this.dangerousTypes.length; i++) {
			if (getType().equalsIgnoreCase(this.dangerousTypes[i]))
				return true;
		}
		return false;
	}

	@Override
	public int compareTo(Object o) {
		if (this.getName().compareTo(((Dog) o).getName()) == 0)
			return this.getType().compareTo(((Dog) o).getType());
		return this.getName().compareTo(((Dog) o).getName());
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		Dog d = new Dog(this.getName(), this.isSleep(), this.getType());
		return d;
	}

}
