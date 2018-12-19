package ClassLoaderPackage;

public class FirstInterfaceImpl implements FirstInterface {

	@Override
	public void poo(String str) {
		System.out.print("\nMy FirstInterfaceImpl : " + str);
		return;
	}
}
