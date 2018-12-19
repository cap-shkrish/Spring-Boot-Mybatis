package ClassLoaderPackage;

import DesignPatternPackage.FacadePatternDemo;
import DesignPatternPackage.FactoryPatternDemo;
import DesignPatternPackage.ProxyPatternDemo;
import DesignPatternPackage.StrategyPatternDemo;
import OutsidePackage.MyClass;

public class Main {

	public static void main(String[] args) {

		// write your code here

		String str = "My Name is ";

		FirstClass firstClass = new FirstClass();
		String str1 = firstClass.foo(str, "Shiva Krishnan");
		System.out.print("\nMain Method calling First Class Calling : " + str1);

		firstClass.foo();

		DataClass dc = new DataClass();
		dc.setFirstName("Shiva");
		dc.setLastName("Krishnan");
		dc.setYear(1970);

		try {
			firstClass.foo(null);
		} catch (MyGenericException mge) {
			System.out.print("Main Method Calling MyGenericException " + mge.getMessage());
		} catch (Exception e) {
			System.out.print("Main Method Calling Exception " + e.getMessage());
		} finally {
			System.out.println("finally block is always executed");
		}

		MyClass myClass = new MyClass();
		myClass.foo("Main Method Calling MyClass \n");

		FirstInterfaceImpl fII = new FirstInterfaceImpl();
		fII.poo("Call the Interface Implementation \n" + FirstInterface.hello + "\n");

		FirstSingleton singleton = FirstSingleton.getInstance();

		singleton.getAmount(1000000);

		MyAbstractClass subClass = new MySubClass(); // Derived class polymorphism
		subClass.abstractMethod();
		subClass.defaultImpl(" Shiva Shiva\n");

		Vehicle car = new Car(); // Derived class polymorphism

		System.out.print(car.getLicensePlate());
		System.out.print(car.polymorphicMethod(""));
		car.setLicensePlate("\nPQRS 1234");
		System.out.print(car.getLicensePlate());

		ArrayClass ac = new ArrayClass();
		ac.foo(20);

		// Design Patterns

		FactoryPatternDemo demo1 = new FactoryPatternDemo();
		FacadePatternDemo demo2 = new FacadePatternDemo();
		ProxyPatternDemo demo3 = new ProxyPatternDemo();
		StrategyPatternDemo demo4 = new StrategyPatternDemo();

		TestCollection collection = new TestCollection();
		TestCollection1 collection1 = new TestCollection1();
		MapInterfaceExample map = new MapInterfaceExample();

		// Lambda Expressions
		LambdaClass lc = new LambdaClass();

	} // Main method ends here

}
