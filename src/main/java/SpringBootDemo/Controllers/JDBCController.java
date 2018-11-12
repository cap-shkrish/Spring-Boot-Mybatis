package SpringBootDemo.Controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import SpringBootDemo.Beans.Student;
import SpringBootDemo.JDBCTemplateDemo.StudentDAOImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class JDBCController {

	@Autowired StudentDAOImpl studentDAOImpl;
	
	@GetMapping(value = "/jdbc")
	public String jdbc() {
		
	      System.out.println("------Records Creation--------" );
	      studentDAOImpl.create("Zara", 11, "312-448-3367", "testZara@spring.com");
	      studentDAOImpl.create("Nuha", 2, "312-448-3367", "testNuha@spring.com");
	      studentDAOImpl.create("Ayan", 15, "312-448-3367", "testAyan@spring.com");

	      System.out.println("------Listing Multiple Records--------" );
	      List<Student> students = studentDAOImpl.listStudents();
	      
	      for (Student record : students) {
	         System.out.print("ID : " + record.getId() );
	         System.out.print(", Name : " + record.getName() );
	         System.out.println(", Age : " + record.getAge());
	      }

	      System.out.println("----Updating Record with ID = 30 -----" );
	      studentDAOImpl.update(30, 80);

	      System.out.println("----Listing Record with ID = 30 -----" );
	      Student student = studentDAOImpl.getStudent(30);
	      System.out.print("ID : " + student.getId() );
	      System.out.print(", Name : " + student.getName() );
	      System.out.println(", Age : " + student.getAge());
	      
	      studentDAOImpl.count();
	      
	      return "";
	   }
}