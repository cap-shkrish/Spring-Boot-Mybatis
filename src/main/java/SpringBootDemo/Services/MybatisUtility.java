package SpringBootDemo.Services;

import org.apache.ibatis.jdbc.SQL;

public class MybatisUtility {

	public String getPersonByName(String name) {
		return new SQL() {
			{
				SELECT("*");
				FROM("personal");
				WHERE("first_name like #{name} || '%'");
			}
		}.toString();
	}

}