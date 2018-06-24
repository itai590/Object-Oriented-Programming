package q1q2;

import java.lang.Object;
import java.util.Arrays;

public class AnimalMain {
	public static void singAlong(Animal[] zoo) {
		for (int i = 0; i < zoo.length; i++) {
			System.out.println("\n" + zoo[i].toString());
			if (!(zoo[i] instanceof Fish))
				System.out.println(zoo[i].say());
			System.out.println("isDangerous = " + zoo[i].isDangerous());
			System.out.println("YearOfDecision= " + zoo[i].getYear());
		}
	}

	public static void dogSort(Dog[] dogs) {

		System.out.println("Original array: ");
		System.out.println(Arrays.toString(dogs));
		Arrays.sort(dogs);
		System.out.println("Array a after the sort: ");
		System.out.println(Arrays.toString(dogs));

	}

	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		Animal[] myZoo = new Animal[7];
		Dog[] myDogs = new Dog[5];

		myZoo[0] = new Dog("Tony", false, "Poodel");
		myZoo[1] = new Cat("Mitzi", false);
		// myZoo[2]= new Cat("Pootzi Mootzi",true);
		myZoo[2] = new Dog(" Bulldogile", true, "Bulldog");
		myZoo[3] = new Fish("Dagi", "Shark");
		myZoo[4] = new Dog("Staffi", false, "Amstaf");
		myZoo[5] = new Fish("Goldi", "Goldfish");
		myZoo[6] = new Fish("Dagchick", "Whale");

		myDogs[0] = new Dog("Tony", false, "Poodel");
		myDogs[1] = new Dog("Bulldogile", true, "bulldog");
		myDogs[2] = new Dog("Staffi", false, "Amstaf");
		myDogs[3] = new Dog("Tony", false, "Rottweiler");
		myDogs[4] = new Dog("Bulldogile", true, "Poodel");

		singAlong(myZoo);
		dogSort(myDogs);
		
		
		Dog d1= new Dog("Tony", false, "Poodel");
		Dog d2= (Dog) d1.clone();
		System.out.println(d1);
		System.out.println(d2);
		System.out.println("After setType:");
		d1.setType("Amstaf");
		System.out.println(d1);
		System.out.println(d2);
	}

}
