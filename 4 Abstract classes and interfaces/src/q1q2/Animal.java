package q1q2;

public abstract class Animal implements Dangerous {
	private String name;
	private boolean isSleep;

	protected Animal(String name, boolean isSleep) {
		this.name = name;
		this.isSleep = isSleep;
	}

	protected Animal(String name) {
		this.name = name;
	}

	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected boolean isSleep() {
		return isSleep;
	}

	protected void setSleep(boolean isSleep) {
		this.isSleep = isSleep;
	}

	protected String getIsSleepState() {
		if (isSleep)
			return "Sleeping...";
		else
			return "Awake!";
	}

	public abstract String say();

	public abstract String toString() ;
}
