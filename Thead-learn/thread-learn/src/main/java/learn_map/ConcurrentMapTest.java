package learn_map;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentMapTest {
	public static void main(String[] args) {
		ConcurrentHashMap map = new ConcurrentHashMap<>();
		map.put("1", "1");
		
		System.out.println(1 << 30);
	}
}
