package SpringBootDemo.Beans;



public class Person  {
	
	private Integer age;
	private String first_name;
	private String last_name;
	private String phone;
	private String email;
	private Integer id;
	private Address address;
	
	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getAge() {
		return age;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Person [age=" + age + ", first_name=" + first_name + ", last_name=" + last_name + ", phone=" + phone
				+ ", email=" + email + ", id=" + id + ", address=" + address + "]";
	}


	


}