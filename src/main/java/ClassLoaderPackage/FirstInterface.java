package ClassLoaderPackage;

public interface FirstInterface {

	public String hello = "Hello";

	public void poo(String str);

}

@FunctionalInterface
interface SecondInterface {

	public String hello = "Hello";

	public String foo(String str);

}
