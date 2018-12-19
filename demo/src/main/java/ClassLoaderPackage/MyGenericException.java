package ClassLoaderPackage;

public class MyGenericException extends Exception {

	public MyGenericException() {
	}

	public MyGenericException(String message) {
		super(message);

		System.out.print("\nThis is MyGenericException " + message);
	}

}
