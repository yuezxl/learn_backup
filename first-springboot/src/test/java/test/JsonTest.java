package test;

import net.sf.json.JSONObject;



public class JsonTest {
	public static void main(String[] args) {
		/*String url = "http://diviner.jd.com/diviner?pin=%s&lid=%s&lim=%s&sp=&hi=&fe=&fne=&ro=&ec=gbk";
		url = String.format(url, "yue_zxl","2","-1");
		System.out.println(url);*/
		
		JSONObject jsonObject = new JSONObject();
		Object obj = jsonObject.get("a");
		if(null != obj) {
			System.out.println("fgsdfgdsf");
		} else {
			System.out.println("dfaef");
		}
	}
}
