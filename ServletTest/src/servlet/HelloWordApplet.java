package servlet;

import java.applet.Applet;
import java.awt.Graphics;

/**
 * @author zhangxiaoliang
 *
 */
public class HelloWordApplet extends Applet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8032654856689464331L;
	
	public void init() {}
	
	public void stop() {}
	
	public void pain(Graphics g) {
		g.drawString("Hello world", 20, 10);
	} 

}
