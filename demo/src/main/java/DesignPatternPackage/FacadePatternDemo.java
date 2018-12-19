package DesignPatternPackage;

public class FacadePatternDemo {
	public FacadePatternDemo() {
		ShapeMaker shapeMaker = new ShapeMaker();

		shapeMaker.drawCircle();
		shapeMaker.drawRectangle();
		shapeMaker.drawSquare();
	}
}