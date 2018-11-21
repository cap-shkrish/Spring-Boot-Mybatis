package SpringBootDemo.Controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import SpringBootDemo.Beans.Address;
import SpringBootDemo.Beans.AddressBean;
import SpringBootDemo.Beans.Person;
import SpringBootDemo.Services.PersonAddressMapper;
import SpringBootDemo.Services.ResultsSetMapper;

@RestController
public class HelloController {
	
	@Value("${message}")
	private String message;
	
	@GetMapping("/hello")
	public String sayHello()
	{
		
/**		Person person = personAddressMapper.selectPerson(3);
		//System.out.println("\npersonAddressMapper.selectPerson(3)\n");
		//System.out.println(person);
		
		List<Person> persons = personAddressMapper.getPersons(2);			
		//System.out.println(persons);
		
		Address address = personAddressMapper.getPersonsForAddress(2);
		System.out.println("\npersonAddressMapper.getPersonsForAddress(2)\n");
		System.out.println(address);
		
		Address address1 = personAddressMapper.getAddressAndPersons(2);
		System.out.println("\npersonAddressMapper.getAddressAndPersons(2)\n");
		System.out.println(address1);
		
		List<AddressBean> addressBean = personAddressMapper.getAddressBean(2);
		System.out.println("\npersonAddressMapper.getAddressBean(2)\n");
		//System.out.println("Array Length = " + addressBean.size() + " \n" + addressBean);
		for (AddressBean ab : addressBean) {
			System.out.println("\n");
			System.out.println(ab.toString());
		}
*/
		Address address = resultsSetMapper.selectAddress(2);
		System.out.println(address);

		List<Person> address3 = resultsSetMapper.callStoredProdForPerson(2);
		System.out.println(address3);

		Address address1 = resultsSetMapper.getAddress(2);
		System.out.println(address1);

		List<Person> address2 = resultsSetMapper.getPersons(2);
		System.out.println(address2);
		
		Person person = resultsSetMapper.getPersonByName("Franz");
		System.out.println(person);
		
		return message;
	}
	
	@Autowired PersonAddressMapper personAddressMapper;
	@Autowired ResultsSetMapper resultsSetMapper;

}
