package SpringBootDemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import SpringBootDemo.Beans.Student;
import SpringBootDemo.Services.StudentMapper;

@RestController
@SpringBootApplication
@ComponentScan(basePackages = {"SpringBootDemo"})
@EntityScan("SpringBootDemo")
public class SpringBootDemoApplication {
	
    @Autowired
    private StudentMapper studentMapper;
	
	

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}
	
	@RequestMapping("/")
	String home() {
		
        Student s = studentMapper.getById(1);
        System.out.println("student name:"+s.getName());//for console output
        List<Student> students = studentMapper.callByAge(77);
        
         

        for (Student record : students) {
            System.out.print("ID : " + record.getId() );
            System.out.print(", Name : " + record.getName() );
            System.out.print(", Age : " + record.getAge());
            System.out.print(", Phone : " + record.getPhone());
            System.out.println(", Email : " + record.getEmail());
         }
        
        
        
		GetByAgeAndFindByIDTest();

         
         return students.toString();

        

	}
	
	
	   public  void GetByAgeAndFindByIDTest()
	   {
			  
		   System.out.print("Inside GetByAgeAndFindByIDTest \n\n "  ); 
		      Student student = studentMapper.findById(25);
			  
		      //Print the student details
	          System.out.print("ID : " + student.getId() );
	          System.out.print(", Name : " + student.getName() );
	          System.out.print(", Phone : " + student.getPhone() );
	          System.out.print(", email : " + student.getEmail() );
	          System.out.println(", Age : " + student.getAge());
				
			   System.out.print("\n\n\nInside GetByAgeAndFindByIDTest \n\n "  ); 

	          
		      List<Student> students = studentMapper.getByAge(80);
	          
		      for(Student st : students ){    	  
		    	   	  
		         System.out.println("++++++++++++++details of the student named " + st.getName() + " are "+"+++++++++++++++++++" );
		    	  
		         System.out.print("Id :  "+st.getId());
		         System.out.print("Name :  "+st.getName());
		         System.out.print("Age :  "+st.getAge());        
		         System.out.print("Email :  "+st.getEmail());        
		         System.out.println("Phone :  "+st.getPhone());    	  
		    	 
		      }     
		      
		      System.out.println("\n\n\nTotal Student Records Read Successfully : " + students.size());          

	   }

}
