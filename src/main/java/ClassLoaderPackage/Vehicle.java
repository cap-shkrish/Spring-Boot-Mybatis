package ClassLoaderPackage;

public class Vehicle {
	protected String licensePlate = "AB 1234";

	public void setLicensePlate(String license) {
		this.licensePlate = license;
	}

	public String getLicensePlate() {
		return this.licensePlate;
	}

	protected Vehicle(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	protected Vehicle() {
	}

	public String polymorphicMethod(String str) {
		return "\n This is the Base class implementation of polymorphicMethod";
	}
}