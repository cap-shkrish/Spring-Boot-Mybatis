package ClassLoaderPackage;

public interface FirstInterface {

	public String hello = "Hello FirstInterface";

	public void poo(String str);

}

@FunctionalInterface
interface SecondInterface {

	public String hello = "Hello SecondInterface";

	public String foo(String str);

}
