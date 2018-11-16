package ClassLoaderPackage;

public class Car extends Vehicle {
	int numberOfSeats = 8;

	public int getNumberOfSeats() {
		return this.numberOfSeats;
	}

	// For instance, if a constructor is declared protected then only classes in the
	// same package,
	// or subclasses of that class can call that constructor.

	public Car(String licensePlate, int numberOfSeats) {
		super(licensePlate);
		this.numberOfSeats = numberOfSeats;
	}

	public Car(String licensePlate) {
		super(licensePlate);
	}

	public Car() {

	}

	@Override
	public String polymorphicMethod(String str) {
		return "\n This is the Derived class implementation of polymorphicMethod";
	}
}