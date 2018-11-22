package SpringBootDemo.Services;

import org.apache.ibatis.jdbc.SQL;

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

}