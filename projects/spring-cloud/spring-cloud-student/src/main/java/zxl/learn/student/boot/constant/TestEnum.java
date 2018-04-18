package zxl.learn.student.boot.constant;

public enum TestEnum {
	TEST1("test1", "test1"),
	TEST2("test2", "test2");
	
	TestEnum() {
		
	}
	TestEnum(String name, String age) {
		this.age = age;
		this.name = name;
	}
	
	private String name;
	private String age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	
}
