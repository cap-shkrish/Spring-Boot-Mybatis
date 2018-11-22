package SpringBootDemo.Services;

import org.apache.ibatis.jdbc.SQL;
import org.springframework.boot.env.RandomValuePropertySource;

import SpringBootDemo.Beans.Person;

public class MybatisUtility {

	public String getPersonByName(String name) {
		return new SQL() {
			{
				SELECT("*");
				FROM("personal");
				if (name != null && !name.isEmpty()) {
					WHERE("first_name like #{name} || '%'");
				}
				ORDER_BY("first_name");
			}
		}.toString();
	}
	
	public String insertPersonSql(Person person) {
		  return new SQL() {{
		    INSERT_INTO("PERSON");
		    VALUES("person_id", "#{person_id}");
		    VALUES("first_Name, LAST_NAME, age, phone, email",
		    		"#{first_name}, #{last_name}, #{age}, #{phone}, #{email}");
		    VALUES("addressId", "5");
		  }}.toString();
		}

}