package DesignPatternPackage;

public class ProxyPatternDemo {
	public ProxyPatternDemo() {

		Image image = new ProxyImage("test_10mb.jpg");

		// image will be loaded from disk
		image.display();
		System.out.println("");

		// image will not be loaded from disk
		image.display();
	}
}
