package SpringBootDemo.Controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import SpringBootDemo.Beans.Student;
import SpringBootDemo.Services.DataOperationsService;

@CrossOrigin
@RestController
@RequestMapping("/students")
public class StudentServiceController
{	
	@Autowired
	private DataOperationsService dop;   

	//http://localhost:9080/students?id=10&name=Shiva+Krishnan&age=77
	@GetMapping( produces="application/json")
	public List <Student> GetStudents(@RequestParam Map<String, String> queryParams) throws IOException
										
	{
		String id = queryParams.get("id");
		String name = queryParams.get("name");
		String age = queryParams.get("age");
		System.out.println(" ID: " + age + " Name: " + name + " Age: " + age);
		List <Student>  st = new ArrayList <Student>();
		
		if(id != null && !id.isEmpty())
		{
			 Student s = dop.Get(Integer.valueOf(id));
			 st.add(s);
		}
		else if(name != null  && !name.isEmpty())
		{			
			if(age != null && !age.isEmpty())			 
				st = dop.GetRecordByNameAge(name, Integer.valueOf(age));
			else
				st = dop.GetRecordByName(name);
		}
		else if(age != null && !age.isEmpty())			 
			st = dop.GetRecordByAge(Integer.valueOf(age));
		else
			st = dop.GetAll();
		
		return st;
	}  	
	
	
	@PutMapping(value="", consumes="application/json", produces = "application/json")
	public List <Student> UpdateStd(@RequestBody Student student, @RequestParam("id") String id) throws IOException
	{
		System.out.println("Inside  UpdateStudent ");
		student.setId(Integer.valueOf(id));
		Student st = dop.Update(student);
		ArrayList<Student> al = new ArrayList<Student>();
		if(st != null)
			al.add(st);

		return al;
	}

	@DeleteMapping(value="")
	public ResponseEntity<String> DeleteStd(@RequestParam("id") String id) throws IOException
	{
		System.out.println("Inside  DeleteStd ");
		dop.Delete(Integer.valueOf(id));
		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	}

	@PostMapping( consumes="application/json", produces = "application/json")
	public List <Student> CreateStudent(@RequestBody Student student) throws IOException
	{
		System.out.println("Inside  CreateStudent ");
		Student st = dop.Insert(student);
		ArrayList<Student> al = new ArrayList<Student>();
		if(st != null)
			al.add(st);

		return al;
	}

	@GetMapping(value="/{id}", produces="application/json")
	public List <Student> GetStudentById(@PathVariable("id") int id) throws IOException
	{
		Student st = dop.Get(id);
		ArrayList<Student> al = new ArrayList<Student>();
		if(st != null)
			al.add(st);
		return al;
	}  

	@PutMapping(value="/{id}", consumes="application/json", produces = "application/json")
	public List <Student> UpdateStudent(@RequestBody Student student, @PathVariable("id") int id) throws IOException
	{
		System.out.println("Inside  UpdateStudent ");
		student.setId(id);
		Student st = dop.Update(student);
		ArrayList<Student> al = new ArrayList<Student>();
		if(st != null)
			al.add(st);

		return al;
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<String> DeleteStudent(@PathVariable("id") int id) throws IOException
	{
		System.out.println("Inside  DeleteStudent ");
		dop.Delete(id);
		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	}
	
	@GetMapping(value="/count", produces="application/json")
	public Map<String, String> GetStudentCount() throws IOException
	{
		int count = dop.GetRowCount();
		Map map = new HashMap();
		map.put("count", Integer.toString(count));		
		return map;
	}  

	@GetMapping(value="/callStoredProc/{age}", produces="application/json")
	public List<Student> CallStoredProc(@PathVariable("age") int age) throws IOException
	{
		List<Student> st = dop.CallStoredProcedure(age);
		return st;
	}  

	@GetMapping(value="/callStoredProc/{name}/{age}", produces="application/json")
	public List<Student> CallStoredProcNameAge(@PathVariable("name") String name, @PathVariable("age") int age) throws IOException
	{
		List<Student> st = dop.CallStoredProcedureNameAge(name, age);
		return st;
	}  
	


}