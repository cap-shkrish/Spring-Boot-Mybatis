package ClassLoaderPackage;

public class Person {

	private String firstName = "";
	private String lastName = "";
	private int birthYear = 0;

	public Person(String first, String last, int year) {

		firstName = first;
		lastName = last;
		birthYear = year;
	}

	// One constructor calling another constructor
	public Person(String first, String last) {
		this(first, last, -1);
	}

}