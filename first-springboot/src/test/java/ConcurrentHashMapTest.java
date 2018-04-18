import java.util.concurrent.ConcurrentHashMap;

import com.alibaba.fastjson.JSON;


public class ConcurrentHashMapTest{
	public static void main(String[] args) {
		ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<> ();
		
		map.put("test", "test");
		
		System.out.println(JSON.toJSONString(map));
	}
}
