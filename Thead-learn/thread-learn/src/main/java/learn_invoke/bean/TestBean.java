package learn_invoke.bean;

import java.io.Serializable;

import lombok.Data;

@Data
public class TestBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String privateFiled;
	public String publicFeild;
	protected String protectedFeild;
	
}
