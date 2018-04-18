package q6;
import java.util.ArrayList;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList <Object> a = new ArrayList<Object>();
		a.add(new Student("James Bond", 7));
		a.add(new Square(10));
		a.add(new Student("Elvis is alive!", 99));
		a.add(new Square(20));
		a.add(new Square(30));
		
		for(int i=0;i<a.size();i++) {
			System.out.println(a.get(i).toString());
		}



	}
}
