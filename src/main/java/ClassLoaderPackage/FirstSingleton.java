package ClassLoaderPackage;

public class FirstSingleton {
	private static FirstSingleton ourInstance = new FirstSingleton();

	public static FirstSingleton getInstance() {
		return ourInstance;
	}

	private FirstSingleton() {
	}

	public void getAmount(int x) {
		System.out.print("Inside Sigleton Class : " + x);
	}
}
