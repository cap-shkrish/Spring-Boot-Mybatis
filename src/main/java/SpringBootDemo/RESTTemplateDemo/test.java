package SpringBootDemo.RESTTemplateDemo;

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

import SpringBootDemo.Beans.Student;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		getStudents();
		createStudent();
		deleteStudent();
		getStudentByName("agee");
		updateStudent();
	}
	
	private static String uri = "http://localhost:8080/students";
	
	private static void getStudents()
	{
		    RestTemplate restTemplate = new RestTemplate();
		     
		    HttpHeaders headers = new HttpHeaders();
		    headers.setContentType(MediaType.APPLICATION_JSON);
		    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		    HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		     
		    ResponseEntity<List> result = restTemplate.exchange(uri, HttpMethod.GET, entity, List.class);
		     
		    System.out.println(result.getBody());
		
	}
	
	private static void updateStudent()
	{
	    uri = uri + "/{id}";
	    
	 
	    Student student = new Student(32, "Zamatron", "201-333-9999", "update@abaqus.com" ); 
	    
	    RestTemplate restTemplate = new RestTemplate();
	   	    
	    Map<String, String> params = new HashMap<String, String>();
	    params.put("id", "100"); 
	    params.put("name", ""); //put requires it otherwise it is assuming urivariables is null. BUG !!
	    params.put("age", ""); 	//put requires it otherwise it is assuming urivariables is null. BUG !!
	    params.put("email", ""); //put requires it otherwise it is assuming urivariables is null. BUG !!
	     
	    restTemplate.put(uri, student, params);
	    
	}
	
	private static void createStudent()
	
	{	 
	    Student student = new Student(80, "GamaRation", "601-222-1111", "gamma@abaqus.com" ); 
	    
	    RestTemplate restTemplate = new RestTemplate();
	    List<Student> students = restTemplate.postForObject( uri, student, List.class);	
	    
	    System.out.println(students.toString());
	}	
	
	private static void deleteStudent()
	{
	    uri = uri + "/{id}";
	     
	    Map<String, Integer> params = new HashMap<String, Integer>();
	    params.put("id", 51);
	     
	    RestTemplate restTemplate = new RestTemplate();
	    restTemplate.delete(uri, params);
	}
	
	private static void getStudentByName(String param)
	{
	    Map<String, String> params = new HashMap<String, String>();	    
	    
	    if(param.equalsIgnoreCase("name"))
	    {
	    	params.put("name", "GamaRadiation");
	    	uri = uri +"?name={name}&";	    	
	    }
	    else if(param.equalsIgnoreCase("age"))
	    {
	    	params.put("age", "100");
	    	uri = uri +"?age={age}&";
	    }
	    else if(param.equalsIgnoreCase("id"))
	    {
	    	params.put("id", "104");
	    	uri = uri +"?id={id}&";
	    }
	    else
	    {
	    	params.put("id", "");  
	    	params.put("name", "Uppumara");
	    	params.put("age", "80");
	    	uri = uri +"?name={name}&age={age}&";	    	
	    }
	     
	    RestTemplate restTemplate = new RestTemplate();
	    ResponseEntity<List> result = restTemplate.getForEntity(uri, List.class, params);
	    System.out.println(result.getBody());
	}
}
