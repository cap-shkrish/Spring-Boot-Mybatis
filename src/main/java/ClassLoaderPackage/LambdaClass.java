package ClassLoaderPackage;

import java.util.function.Function;

public class LambdaClass {

	public LambdaClass() {

		// Anonymous Class Implementation of an Interface
		FirstInterface FI = new FirstInterface() {
			@Override
			public void poo(String str) {
				System.out.println(str);
			}
		};

		FI.poo("MyTeam 1111\n");

		// or Lambda Expression Implementation of an Interface

		FirstInterface function = (string) -> {
			System.out.println(string);
		};

		function.poo("MyTeam 22222\n");

		SecondInterface lambdafunction = (string) -> {
			System.out.println("Inside Lambda function \n");
			return string;
		};

		System.out.println(lambdafunction.foo("Second Interface Lambda\n"));

		// Anytime you want to implement the single functional interface, use lambda as
		// follows

		Runnable runnable = () -> {
			System.out.println("I am the run implementation\n");
		};
		Thread thread = new Thread(runnable);
		thread.run();

		Function<Integer, Double> CToF = (x) -> {
			return Double.valueOf(x * 9 / 5 + 32);
		};
		System.out.println(" Centigrade to Fahrenheit: " + CToF.apply(100));

		// String to an integer
		Function<String, Integer> stringToInt = x -> Integer.valueOf(x);
		System.out.println(" String to Int: " + stringToInt.apply("4"));

	}
}
