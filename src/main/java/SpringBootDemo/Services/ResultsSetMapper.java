package SpringBootDemo.Services;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.mapping.StatementType;
import org.springframework.stereotype.Repository;

import SpringBootDemo.Beans.Address;
import SpringBootDemo.Beans.Person;



@Repository
@Mapper
public interface ResultsSetMapper {

	
	@Select(value= "{call getAddressPerson(#{id,jdbcType=INTEGER,mode=IN})}")
	@Options(statementType = StatementType.CALLABLE)
	@ResultMap("userResult")		  
	public List<Person> callStoredProdForPerson(int id);
	
	public Address selectAddress(int id);
	
	@Results(value ={
		     @Result(property = "id", column = "Id"),
			 @Result(property = "personList", column = "id",
			    	 many=@Many(select = "getPerson"))})	
	@Select("select * from address where id=#{addressId}")
			public Address getAddress(Integer addressId);	
	@Select("select * from personal where addressId=#{addressId}")
			public Person getPerson(Integer addressId);
	
	  
	@Results(id = "userResult", value ={
		     @Result(property="person_id", column = "person_id" ),
		     @Result(property="address.id", column = "id"),
		     @Result(property="address.address1", column = "address1"),
		     @Result(property="address.address2", column = "address2"),
		     @Result(property="address.city", column = "city"),
		     @Result(property="address.state", column = "state"),
		     @Result(property="address.country", column = "country"),
		     @Result(property="address.postalcode", column = "postalcode"),
		     })		  
	@Select("select * from Address A left outer join Personal P on A.id = P.addressId where A.id = #{id}")
			public List<Person> getPersons(Integer id);
	
	@SelectProvider(type=MybatisUtility.class, method="getPersonByName")
	public List<Person> getPersonByName(String name);	
	
	@Results(value ={
		     @Result(property = "id", column = "Id"),
		     })	
	@SelectProvider(type=MybatisUtility.class, method="insertPersonSql")
	public Integer InsertPerson(Person person);	
	
	@Insert("INSERT INTO Person (person_id,first_name,last_name, AGE, phone, email, addressId) VALUES(#{person_id},#{first_name},#{last_name},#{age},#{phone},#{email},'5')")
	public int InsertPerson2(Person person);


}
