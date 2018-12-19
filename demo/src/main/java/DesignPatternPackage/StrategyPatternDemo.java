package DesignPatternPackage;

public class StrategyPatternDemo {

	public StrategyPatternDemo() {
		// You can use a factory pattern (StrategyFactory to create a Strategy object
		// using getStrategy(StrategyEnum:ADD) instead of instantiating here
		Context context = new Context(new OperationAdd());
		System.out.println("10 + 5 = " + context.executeStrategy(10, 5));

		context = new Context(new OperationSubstract());
		System.out.println("10 - 5 = " + context.executeStrategy(10, 5));

		context = new Context(new OperationMultiply());
		System.out.println("10 * 5 = " + context.executeStrategy(10, 5));
	}
}