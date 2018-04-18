package test.java;

public abstract class Parent {
	private final String title;
	protected Parent(String title) {
		this.title = title;
		out();
	}
	
	public abstract void out();
}
