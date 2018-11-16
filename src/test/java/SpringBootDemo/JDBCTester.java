package SpringBootDemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

import SpringBootDemo.Beans.Student;
import SpringBootDemo.RESTTemplateDemo.RESTDemo;



//@ActiveProfiles(AppConfig.PROFILE_LOCAL)
public class JDBCTester {
	
	private Student student = new Student(32, "My Name is Trinity", "201-333-9999", "tester@abaqus.com" );
	private RESTDemo restDemo = new RESTDemo();
	
	@Test
	public void accountIsValid() {
		// setup account with a valid set of beneficiaries to prepare for testing
		restDemo.createStudent(student);
		
	}

	


}
