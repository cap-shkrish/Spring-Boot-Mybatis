package SpringBootDemo.Services;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SpringBootDemo.Beans.Student;

@Service
public class DataOperationsService { 

	@Autowired
	private StudentMapper studentMapper;

	public  int GetRowCount()
	{
		int count = studentMapper.getRowCount();	      
		System.out.println("\nNumber of Student Records = "  + " Count: " + count);
		return count;
	}

	public static void main(String args[]) throws IOException {

		DataOperationsService dop = new DataOperationsService();

		dop.GetRowCount();

		//Create a new student object
		Student student = new Student(15, "Uppumara", "401-555-7777", "testa@spring.com" ); 

		dop.Insert(student);  
		dop.GetAll();
		dop.Get(5);
		dop.Delete(6);
		dop.CallStoredProcedure(15);      
		dop.GetRecordByName("Uppumara");

		Student st = new Student(12, "Zamatron", "201-333-9999", "update@abaqus.com" ); 
		st.setId(12);//Set id to be updated
		dop.Update(st);

	}

	public  Student Insert(Student student)
	{
		int id = studentMapper.insert(student);
		System.out.println("record inserted successfully ID:" + id);
		student.setId(id);
		return student;
	}

	public  List<Student> GetAll()
	{

		List<Student> students = studentMapper.getAll();

		for (Student record : students) {
			System.out.print("ID : " + record.getId() );
			System.out.print(", Name : " + record.getName() );
			System.out.print(", Phone : " + record.getPhone() );
			System.out.print(", email : " + record.getEmail() );
			System.out.println(", Age : " + record.getAge());
		}

		System.out.println("Records Read Successfully ");          

		return students;
	}


	public  Student Get(int id)
	{

		Student student = studentMapper.getById(id);

		//Print the student details
		System.out.print("ID : " + student.getId() );
		System.out.print(", Name : " + student.getName() );
		System.out.print(", Phone : " + student.getPhone() );
		System.out.print(", email : " + student.getEmail() );
		System.out.println(", Age : " + student.getAge());


		return student;
	}

	public  void Delete(Integer id)
	{
		studentMapper.deleteById(id);
		System.out.println("Record deleted successfully for ID: " + id);
	}

	public  List<Student> CallStoredProcedure(Integer id)
	{

		System.out.println("Inside CallStoredProcedure callByAge\n" );

		//select a particular student  by  id	
		List<Student> students = studentMapper.callByAge( id);

		for(Student st : students ){    	  

			System.out.println("++++++++++++++details of the student named " + st.getName() + " are "+"+++++++++++++++++++" );

			System.out.print("Id :  "+st.getId());
			System.out.print("Name :  "+st.getName());
			System.out.print("Age :  "+st.getAge());        
			System.out.print("Email :  "+st.getEmail());        
			System.out.println("Phone :  "+st.getPhone());    	  

		}   

		return students;

	}

	public List<Student> CallStoredProcedureNameAge(String name, int age) {
		System.out.println("Inside CallStoredProcedureNameAge callByNameAge\n" );

		Student student = new Student (); 

		student.setAge(age);
		student.setName(name);

		//select a particular student  by  id	
		List<Student> students = studentMapper.callByNameAge(student);

		for(Student st : students ){    	  

			System.out.println("++++++++++++++details of the student named " + st.getName() + " are "+"+++++++++++++++++++" );

			System.out.print("Id :  "+st.getId());
			System.out.print("Name :  "+st.getName());
			System.out.print("Age :  "+st.getAge());        
			System.out.print("Email :  "+st.getEmail());        
			System.out.println("Phone :  "+st.getPhone());    	  

		}   

		return students;	}


	public  List<Student> GetRecordByNameAge(String name, Integer age) {

		Student student = new Student();
		if(!name.isEmpty())
			student.setName(name);
		student.setAge(age);

		List<Student> students = studentMapper.getRecByName_age(student);

		for(Student st : students ){    	  

			System.out.println("++++++++++++++details of the student named " + st.getName() + " are "+"+++++++++++++++++++" );

			System.out.print("Id :  "+st.getId());
			System.out.print("Name :  "+st.getName());
			System.out.print("Age :  "+st.getAge());        
			System.out.print("Email :  "+st.getEmail());        
			System.out.println("Phone :  "+st.getPhone());    	  

		}     

		System.out.println("Total Student Records Read Successfully : " + students.size());          

		return students;
	}
	
	public  List<Student> GetRecordByAge( Integer age) {

		Student student = new Student();
		student.setAge(age);

		List<Student> students = studentMapper.getByAge(age);

		for(Student st : students ){    	  

			System.out.println("++++++++++++++details of the student named " + st.getName() + " are "+"+++++++++++++++++++" );

			System.out.print("Id :  "+st.getId());
			System.out.print("Name :  "+st.getName());
			System.out.print("Age :  "+st.getAge());        
			System.out.print("Email :  "+st.getEmail());        
			System.out.println("Phone :  "+st.getPhone());    	  

		}     

		System.out.println("Total Student Records Read Successfully : " + students.size());          

		return students;
	}



	public  List<Student> GetRecordByName(String name) {

		Student student = new Student();
		student.setName(name);
		List<Student> students = studentMapper.getRecByName(student);

		for(Student st : students ){    	  

			System.out.println("++++++++++++++details of the student named " + st.getName() + " are "+"+++++++++++++++++++" );

			System.out.print("Id :  "+st.getId());
			System.out.print("Name :  "+st.getName());
			System.out.print("Age :  "+st.getAge());        
			System.out.print("Email :  "+st.getEmail());        
			System.out.println("Phone :  "+st.getPhone());    	  

		}     

		System.out.println("Total Student Records Read Successfully : " + students.size());          

		return students;
	}



	public  Student Update(Student student)
	{

		Student st = Get(student.getId());
		System.out.println("Current details of the student are" );
		System.out.println(st.toString());  

		studentMapper.update(student);

		System.out.println("Record updated successfully");   

		//verifying the record 
		Student std = Get( student.getId());
		System.out.println("Details of the student after update operation" );
		System.out.println(std.toString());   

		return std;
	}


}