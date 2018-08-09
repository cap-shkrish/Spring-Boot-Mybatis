package ClassLoaderPackage;

public class DataClass {

	String firstName = "";
	String lastName = "";
	int year;

	public void setFirstName(String firstName) {
		this.firstName = firstName;
		System.out.print(this.firstName);
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
		System.out.print(this.lastName);
	}

	public void setYear(int year) {
		this.year = year;
		System.out.print(this.year);
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getYear() {
		return year;
	}
}
