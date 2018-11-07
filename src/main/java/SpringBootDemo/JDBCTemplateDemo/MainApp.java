package SpringBootDemo.JDBCTemplateDemo;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import SpringBootDemo.Beans.Student;


public class MainApp 
{
   public static void main(String[] args) 
   {
      ApplicationContext context = new ClassPathXmlApplicationContext("./Beans.xml");

      StudentDAOImpl studentDAOImpl = 
         (StudentDAOImpl)context.getBean("studentDAOImpl");
      
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
      
    }
}