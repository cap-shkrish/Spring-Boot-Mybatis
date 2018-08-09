package RESTTemplateDemo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Student;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		getStudents();
		updateStudent();
		createStudent();
		putStudent();
		deleteStudent();
		getStudentByName();

	}
	
	private static void getStudents()
	{
		    final String uri = "http://localhost:8080/studentJson";
		     
		    RestTemplate restTemplate = new RestTemplate();
		     
		    HttpHeaders headers = new HttpHeaders();
		    headers.setContentType(MediaType.APPLICATION_JSON);
		    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		    HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		     
		    ResponseEntity<List> result = restTemplate.exchange(uri, HttpMethod.GET, entity, List.class);
		     
		    System.out.println(result);
		
	}
	
	private static void updateStudent()
	{
	    final String uri = "http://localhost:8080/updateStudent";
	 
	    Student student = new Student(32, "Zamatron", "201-333-9999", "update@abaqus.com" ); 
	    student.setId(32);//Set id to be updated
	 
	    RestTemplate restTemplate = new RestTemplate();
	    //Student result = restTemplate.postForObject( uri, student, Student.class);
	    //Changed the signature to return a list of students instead of a student
	    List<Student> result = restTemplate.postForObject( uri, student, List.class);
	    System.out.println(result);
	 
	    
	}
	
	private static void createStudent()
	{
	    final String uri = "http://localhost:8080/createStudent";
	 
	    Student student = new Student(80, "Zamatron", "901-222-9999", "create@abaqus.com" ); 
	 
	    RestTemplate restTemplate = new RestTemplate();
	    Student result = restTemplate.postForObject( uri, student, Student.class);
	 
	    System.out.println(result);
	}
	
	private static void putStudent()
	{
	    final String uri = "http://localhost:8080/putStudent";
	     	     
	    Student student = new Student(22, "KallaruKai", "601-222-9999", "put@abaqus.com" ); 
	    student.setId(20);//Set id to be updated
	     
	    RestTemplate restTemplate = new RestTemplate();
	    restTemplate.put(uri, student);
	}
	
	private static void deleteStudent()
	{
	    final String uri = "http://localhost:8080/deleteStudent/{id}";
	     
	    Map<String, Integer> params = new HashMap<String, Integer>();
	    params.put("id", 19);
	     
	    RestTemplate restTemplate = new RestTemplate();
	    restTemplate.delete(uri, params);
	}
	
	private static void getStudentByName()
	{
	    final String uri = "http://localhost:8080/studentByName/{name}";
	     
	    Map<String, String> params = new HashMap<String, String>();
	    params.put("name", "Zamatron");
	     
	    RestTemplate restTemplate = new RestTemplate();
	    restTemplate.getForEntity(uri, List.class, params);
	}
}
