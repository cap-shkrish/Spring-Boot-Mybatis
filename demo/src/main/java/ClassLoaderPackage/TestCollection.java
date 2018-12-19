package ClassLoaderPackage;

//import java.util.function.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TestCollection {
	public TestCollection() {
		ArrayList<Temp> list = new ArrayList<Temp>();// Creating arraylist
		list.add(new Temp("Jeetho Ravi"));// Adding object in arraylist
		list.add(new Temp("Jeetho Vijay"));// Adding object in arraylist
		list.add(new Temp("Jeetho Ajay"));// Adding object in arraylist
		// Traversing list through Iterator Externally
		Iterator itr = list.iterator();

		System.out.println(list.stream().map(e -> e.getStr()));

		// Traversing list through list Externally
		for (Temp temp : list) {
			System.out.println(temp.getStr());
		}

		// Traversing list through list internally using Lambda
		// (Prameter list) -> (Body of code)
		list.forEach(item -> {
			System.out.println("ForEach Jeetho  " + item.getStr());
		}

		);

	}
}

class Temp {

	public Temp(String str) {
		this.str = str;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	String str = "Shiva Krishnan";
}

class MapInterfaceExample {
	public MapInterfaceExample() {

		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(100, "Amit");
		map.put(101, "Vijay");
		map.put(102, "Rahul");
		for (Map.Entry m : map.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());
		}

	}
}

class TestCollection1 {
	public TestCollection1() {
		// Creating user-defined class objects
		Student s1 = new Student(101, "Sonoo", 23);
		Student s2 = new Student(102, "Ravi", 21);
		Student s3 = new Student(103, "Hanumat", 25);
		// creating arraylist
		ArrayList<Student> al = new ArrayList<Student>();
		al.add(s1);// adding Student class object
		al.add(s2);
		al.add(s3);
		// Getting Iterator
		Iterator itr = al.iterator();
		// traversing elements of ArrayList object
		while (itr.hasNext()) {
			Student st = (Student) itr.next();
			System.out.println(st.rollno + " " + st.name + " " + st.age);
		}

		Map<Integer, Student> map = new HashMap<Integer, Student>();
		map.put(1000, s1);
		map.put(1001, s2);
		map.put(1002, s3);

		for (Map.Entry m : map.entrySet()) {
			Student st = (Student) m.getValue();
			Student s = map.get(m.getKey());
			System.out.println(m.getKey() + " " + st.rollno + " " + st.name + " " + st.age);
			System.out.println(m.getKey() + " " + s.rollno + " " + s.name + " " + s.age);
		}

	}
}

class Student {
	int rollno;
	String name;
	int age;

	Student(int rollno, String name, int age) {
		this.rollno = rollno;
		this.name = name;
		this.age = age;
	}
}
