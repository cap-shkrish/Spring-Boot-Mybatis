package SpringBootDemo.Controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import SpringBootDemo.Beans.Address;
import SpringBootDemo.Beans.Person;
import SpringBootDemo.Beans.Student;
import SpringBootDemo.Services.PersonAddressMapper;

@RestController
public class HelloController {
	
	@Value("${message}")
	private String message;
	
	@GetMapping("/hello")
	public String sayHello()
	{
		
		Person person = personAddressMapper.selectPerson(3);
		System.out.println("\npersonAddressMapper.selectPerson(3)\n");
		System.out.println(person);
		
		List<Person> persons = personAddressMapper.getPersons(2);	
		
		System.out.println("\npersonAddressMapper.getPersons(2)\n");
		System.out.println(persons);
		
		Address address = personAddressMapper.getPersonsForAddress(2);
		System.out.println(address);
		return message;
	}
	
	@Autowired PersonAddressMapper personAddressMapper;

}
