package ClassLoaderPackage;

import java.util.ArrayList;

public class MySubClass extends MyAbstractClass {

	@Override
	public void abstractMethod() {
		System.out.println("\nMy abstractMethod implementation");
	}
}

class ArrayClass {
	private ArrayList<Integer> al = new ArrayList<Integer>();

	public ArrayList<Integer> foo(int i) {
		for (int j = 0; j <= i; j++) {
			al.add(j);

		}
		System.out.print(" The array list :" + al);

		return al;
	}
}