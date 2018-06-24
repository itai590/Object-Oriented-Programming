package q1q2;

import java.util.InputMismatchException;

public class Fish extends Animal {
	private final String[] types = { "Shark", "Whale", "Goldfish" };
	private final String[] dangerousTypes = { "Shark", "Whale" };
	private String type;

	public Fish(String name, String type) {
		super(name);
		setType(type);
		// TODO Auto-generated constructor stub
	}

	public String getType() {
		return type;
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
				throw new InputMismatchException("Invalid Fish Type:" + type);
		} catch (InputMismatchException ex) {
			System.err.println(ex.getMessage());
			System.exit(0);
		}

		this.type = type.substring(0, 1).toUpperCase() + type.substring(1);
	}

	@Override
	public String toString() {
		return "Fish: " + super.getName() + " ( type: " + getType() + " )";
	}

	@Override
	public boolean isDangerous() {
		for (int i = 0; i < this.dangerousTypes.length; i++) {
			if (getType().equalsIgnoreCase(this.dangerousTypes[i])) return true;
		}
		return false;
	}

	@Override
	public String say() {
		// TODO Auto-generated method stub
		return null;
	}
}
