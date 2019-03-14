package SpringBootDemo.Controllers;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/helloworld")
public class HelloWorldController {
	@GetMapping( produces="application/json")
	public Map<String, String> GetStudents() throws IOException										
	{				
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("helloworld", " Welcome to my Hello World !! ");		
		return map;
	}  
}
