package q1q2;

public class Cat extends Animal {

	public Cat(String name, boolean isSleep) {
		super(name, isSleep);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String say() {
		if (super.isSleep())
			return "..Shhh .. the cat is sleeping now.";
		return "Miahoo, Miahoo";
	}

	@Override
	public String toString() {
		return "Cat: " + super.getName() + ", " + super.getIsSleepState();

	}

	@Override
	public boolean isDangerous() {
		// TODO Auto-generated method stub
		return false;
	}
}
