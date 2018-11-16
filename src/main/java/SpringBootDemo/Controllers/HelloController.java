package SpringBootDemo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import SpringBootDemo.Beans.Address;
import SpringBootDemo.Beans.Person;
import SpringBootDemo.Services.PersonAddressMapper;

@RestController
public class HelloController {
	
	@Value("${message}")
	private String message;
	
	@GetMapping("/hello")
	public String sayHello()
	{
		
		//Address address = personAddressMapper.selectAddress(1);
		//Address address = personAddressMapper.getById(1);
		//Person person = personAddressMapper.selectPerson(2);
		//System.out.println(person.toString());
		Address address = personAddressMapper.getResult(2);
		System.out.println(address.toString());
		return message;
	}
	
	@Autowired PersonAddressMapper personAddressMapper;

}
