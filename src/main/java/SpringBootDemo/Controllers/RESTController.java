package SpringBootDemo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import SpringBootDemo.Beans.Student;
import SpringBootDemo.RESTTemplateDemo.RESTDemoService;


@RestController
public class RESTController {
	
    @Autowired
    private RESTDemoService restDemoService;
   
	@GetMapping("/restDemo")
	public List<Student> getStudents()
	{
		ResponseEntity<List> result = restDemoService.getStudents();
        return result.getBody();
    }
	

	
}
