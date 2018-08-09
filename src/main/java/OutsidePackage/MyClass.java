package OutsidePackage;

import ClassLoaderPackage.FirstClass;

public class MyClass {

	public int foo(String str1) {

		System.out.print(str1);
		// DefaultAccessClass dac = new DefaultAccessClass();
		// dac.fooDefault(100);

		FirstClass fc = new FirstClass();
		fc.foo("MyClass1", " MyClass2");
		return 10;
	}

	// If this was protected then Main will return error
	public MyClass() {

		Outer outer = new Outer();
		Outer.Inner inner = outer.new Inner();
		inner.printText();
		Level level = Level.HIGH;
		System.out.println(level);
	}
}

enum Level {
	HIGH, MEDIUM, LOW
}

class Outer {

	private String text = "\nI am private!\n";

	public class Inner {

		public void printText() {
			System.out.println(text);
		}
	}
}
