package com.example.demo.Controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.StudentMapper;

import com.example.demo.Student;

@Service
public class DataOperations { 

	@Autowired
	private StudentMapper studentMapper;
        
    public  int GetRowCount()
    {
 	      //Insert student data      
 	      //int count = session.selectOne("UserMapper.getRowCount");
 	      //int count = session.getMapper(UserMapper.class).getRowCount();
 	      int count2 = studentMapper.getRowCount();
 	      
 	      System.out.println("Number of Student Records = "  + " \nCount: " + count2);

 	      return count2;
    }


	public static void main(String args[]) throws IOException{
      
		DataOperations dop = new DataOperations();
		
		dop.GetRowCount();
      
      //Create a new student object
      Student student = new Student(15, "Uppumara", "401-555-7777", "testa@spring.com" ); 
      
      dop.Insert(student);  
      dop.GetAll();
      dop.Get(5);
      dop.Update(7);
      dop.Delete(6);
      dop.CallStoredProcedure(15);
      
      dop.GetRecordByNameID("Uppumara", 25);
      
	  Student st = new Student(12, "Zamatron", "201-333-9999", "update@abaqus.com" ); 
	  st.setId(12);//Set id to be updated
	  dop.Update(st);


			
   }
   
   public  Student Insert(Student student)
   {
	      //Insert student data      
	      //session.insert("StudentMapper.insert", student);
	      studentMapper.insert(student);
	      System.out.println("record inserted successfully");
	      
	      return student;
   }
   
   public  List<Student> GetAll()
   {
	      
	      //select contact all contacts		
	      //List<Student> students = session.selectList("StudentMapper.getAll");
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
		  
	      //select a particular student  by  id	
	      //Student student = (Student) session.selectOne("StudentMapper.getById", id); 
	      Student student = studentMapper.getById(id);
		  
	      //Print the student details
          System.out.print("ID : " + student.getId() );
          System.out.print(", Name : " + student.getName() );
          System.out.print(", Phone : " + student.getPhone() );
          System.out.print(", email : " + student.getEmail() );
          System.out.println(", Age : " + student.getAge());
			
	      
	      return student;
   }
   
   public  Student Update(Integer id)
   {
	      //select a particular student using id		
	      Student student = Get(id);
	      
	      System.out.println("Current details of the student are" );
	      System.out.println(student.toString());  
	      
	      //Set new values to the mail and phone number of the student
	      student.setEmail("pappad39@gmail.com");
	      student.setPhone("801-999-9999");
	      
	      //Update the student record
	      //session.update("StudentMapper.update",student);
	      studentMapper.update(student);
	      
	      System.out.println("Record updated successfully");   
		  
	      //verifying the record 
	      Student std = Get(id);
	      System.out.println("Details of the student after update operation" );
	      System.out.println(std.toString());   
	      
	      return student;
   }
   
   public  void Delete(Integer id)
   {
		  
	      //Delete operation
	      //session.delete("StudentMapper.deleteById", id);    
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

   
   public  List<Student> GetRecordByNameID(String name, Integer id) {

	      Student student = new Student();
	      student.setName(name);
	      //student.setId(id);
	      //student.setAge(15);
	      
	      //select contact all contacts		
	      //List<Student> student = session.selectList("getRecByName",student);
	      
	      //List<Student> students = session.selectList("getRecByName_Id",student);
	      //List<Student> students = session.selectList("getRecByName_Id_age",student);
	      //List<Student> students = session.getMapper(StudentMapper.class).getRecByName(student);
	      //List<Student> students = session.getMapper(StudentMapper.class).getRecByName_Id(student);
	      List<Student> students = studentMapper.getRecByName_Id_age(student);
	          
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
   
   public  List<Student> GetRecordByNameAge(String name, Integer age) {

	      Student student = new Student();
	      if(!name.isEmpty())
	    	  student.setName(name);
	      //student.setId(id);
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

	      //select a particular student using id		
	      //Student st = (Student) session.selectOne("StudentMapper.getById", student.getId());
	      Student st = Get(student.getId());
	      System.out.println("Current details of the student are" );
	      System.out.println(st.toString());  
	      
	      //Set new values to the mail and phone number of the student
	      
	      //Update the student record
	      //session.update("StudentMapper.update",student);
	      studentMapper.update(student);
	      
	      System.out.println("Record updated successfully");   
		  
	      //verifying the record 
	      //Student std = studentMapper.getById(student.getId());
	      Student std = Get( student.getId());
	      System.out.println("Details of the student after update operation" );
	      System.out.println(std.toString());   
	      
	      return std;
   }


   public  void GetByAgeAndFindByIDTest()
   {
		  
	      //select a particular student  by  id	
	      //Student student = (Student) session.selectOne("StudentMapper.getById", id); 
	      Student student = studentMapper.findById(25);
		  
	      //Print the student details
          System.out.print("ID : " + student.getId() );
          System.out.print(", Name : " + student.getName() );
          System.out.print(", Phone : " + student.getPhone() );
          System.out.print(", email : " + student.getEmail() );
          System.out.println(", Age : " + student.getAge());
			

          
	      List<Student> students = studentMapper.getByAge(80);
          
	      for(Student st : students ){    	  
	    	   	  
	         System.out.println("++++++++++++++details of the student named " + st.getName() + " are "+"+++++++++++++++++++" );
	    	  
	         System.out.print("Id :  "+st.getId());
	         System.out.print("Name :  "+st.getName());
	         System.out.print("Age :  "+st.getAge());        
	         System.out.print("Email :  "+st.getEmail());        
	         System.out.println("Phone :  "+st.getPhone());    	  
	    	 
	      }     
	      
	      System.out.println("Total Student Records Read Successfully : " + students.size());          

   }


   
}