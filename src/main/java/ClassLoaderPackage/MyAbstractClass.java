package ClassLoaderPackage;

/**
 * If a class has an abstract method, the whole class must be declared abstract.
 * Not all methods in an abstract class have to be abstract methods. An abstract
 * class can have a mixture of abstract and non-abstract methods. Subclasses of
 * an abstract class must implement (override) all abstract methods of its
 * abstract superclass. The non-abstract methods of the superclass are just
 * inherited as they are. They can also be overridden, if needed.
 */
public abstract class MyAbstractClass {

	public abstract void abstractMethod();

	public String defaultImpl(String str) {
		System.out.print("\n Default method Implementation in MyAbstractClass" + str);
		return "Default";
	}
}
