package com.example.demo.Controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Student;

@CrossOrigin
@RestController
public class StudentService
{	
	@Autowired
	private DataOperations dop;   
		
	
	@GetMapping(value="/getString", produces="application/json")
    public String GetString() 
    {
        System.out.println(" Inside getString \n");
        
        
        return "[{\"name\" : \"Simply Red\""
        		+ "}]"; 
        
        
        //return "{\"name\" : \"Simply Red\"}"; 
        //return "Simply Red";
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

	
	@GetMapping(value="/studentCount", produces="application/json")
    public String GetStudentCount() throws IOException
    {
        int st = dop.GetRowCount();
        
        return "[{\"count\" : " + st +"}]";
    }  
	
	@GetMapping(value="/studentJson", produces="application/json")
    public List <Student> GetAllStudentsJSON() throws IOException
    {
        List <Student> st = dop.GetAll();
        
        return st;
    }  
	
	   
	   @GetMapping(value="/studentByName/{name}", produces="application/json")
	    public List <Student> GetStudentByName(@PathVariable("name") String name) throws IOException
	    {
  			System.out.println("Inside  getStudentByName Pathvariable " + name);

	    	List <Student> st = dop.GetRecordByNameID(name, 5); //Value 5 is never used for this example
	        
	        return st;
	    }
	   
	   @GetMapping(value="/studentByAge/{age}", produces="application/json")
	    public List <Student> GetStudentByAge(@PathVariable("age") int age) throws IOException
	    {
 			System.out.println("Inside  getStudentByAge Pathvariable " + age);

	    	List <Student> st = dop.GetRecordByNameAge("", age);
	        
	        return st;
	    }
	   
	   @GetMapping(value="/studentByNameAge/{name}/{age}", produces="application/json")
	    public List <Student> GetStudentByNameAge(@PathVariable("name") String name, @PathVariable("age") int age) throws IOException
	    {
 			System.out.println("Inside  getStudentByAge Pathvariable Name: " + name + "Age: " + age);

	    	List <Student> st = dop.GetRecordByNameAge(name, age);
	        
	        return st;
	    }
	   	   
	   @PostMapping(value="/updateStudent", consumes="application/json", produces = "application/json")
	    public List <Student> UpdateStudent(@RequestBody Student student) throws IOException
	    {
   				System.out.println("Inside  UpdateStudent ");

	    		Student st = dop.Update(student);

	    		ArrayList<Student> al = new ArrayList<Student>();
	    		if(st != null)
	    			al.add(st);
	    		
	    		return al;
	    }
	   
	   @PostMapping(value="/createStudent", consumes="application/json", produces = "application/json")
	    public List <Student> CreateStudent(@RequestBody Student student) throws IOException
	    {
   				System.out.println("Inside  CreateStudent ");
	    		Student st = dop.Insert(student);

	    		ArrayList<Student> al = new ArrayList<Student>();
	    		if(st != null)
	    			al.add(st);
	    		
	    		return al;
	    		
	    }

	   
	   @PutMapping(value="/putStudent", consumes="application/json", produces = "application/json")
	    public List <Student> PutStudent(@RequestBody Student student) throws IOException
	    {
	    		Student st = dop.Update(student);
	    		System.out.println("Inside  PutStudent ");

	    		ArrayList<Student> al = new ArrayList<Student>();
	    		if(st != null)
	    			al.add(st);
	    		
	    		return al;
	    }

	   @DeleteMapping(value="/deleteStudent/{id}")
	    public ResponseEntity<String> DeleteStudent(@PathVariable("id") int id) throws IOException
	    {
   			System.out.println("Inside  DeleteStudent ");
	    	dop.Delete(id);

	    	return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	    		
	    }
    
}