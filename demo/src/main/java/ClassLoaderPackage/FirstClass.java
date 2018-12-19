package ClassLoaderPackage;

//Final classes cannot be subclassed
public final class FirstClass {

	private static String abc = "Hello World";

	// Overloaded method
	public String foo(String str1, String str2) {

		System.out.print("FirstClass: " + str1 + " " + str2);
		DefaultAccessClass dac = new DefaultAccessClass();

		String str = dac.fooDefault(100);

		return str;
	}

	// final method cannot be overridden by sub classes
	public final void foo() {

		System.out.print("\nFirstClass: Default foo() implementation\n");

	}

	DataClass dc = null;

	public void foo(DataClass dc) throws MyGenericException {
		// try {
		if (dc == null)
			throw new MyGenericException("\nDataclass is NULL. Please instantiate a dataclass and pass it. \n");
		this.dc = dc;
		// }

		// catch (MyGenericException mge)
		// {
		// System.out.print(mge.getMessage());
		// }

	}

	public FirstClass() {
	}
}

class DefaultAccessClass {
	public DefaultAccessClass() {
	}

	public String fooDefault(int x) {

		System.out.print("\nDefaultAccessClass: " + x);
		return "\nDefaultAccessClass\n";
	}

}
