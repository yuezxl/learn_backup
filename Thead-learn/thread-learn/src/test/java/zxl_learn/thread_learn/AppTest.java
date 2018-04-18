package zxl_learn.thread_learn;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    
    public static void main(String[] args) {
		String str = "http://api.open.qingting.fm/newsearch/三国演义/type/channel_ondemand?curpage=1&pagesize=10&access_token=OGNkYmEwZjUtZTM3Yi00ODljLThjZWMtNWE5YzBiMjVmNGFi&dsfafds";
		
		int index = str.indexOf("access_token");
		int end = str.substring(index).indexOf("&");
		System.out.println(str.substring(index).indexOf("&"));
		System.out.println(str.substring(index, index + end));
		System.out.println(str.replace(str.substring(index, index + end), "11111"));
		
	}
}
