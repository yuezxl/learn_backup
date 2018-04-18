package test.bean;

public class Parent implements Cloneable{
	private Integer id;
	private Integer age;
	private String name;
	
	@Override
	public Parent clone() {
		Parent clone = null;
		try {
			clone = (Parent) super.clone(); 
		} catch (Exception e) {
			throw new RuntimeException(e); // won't happen 
		}
		return clone;
	}
	
	public Parent() {
		this.id = 1;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
