package zxl.learn.student.boot.constant;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.BeanUtils;

public class Test {
	public static void main(String[] args) throws NoSuchAlgorithmException {
		/*System.out.println(TestEnum.TEST1.getName());
		TestEnum.TEST1.setName("dsafdsafs");
		System.out.println(TestEnum.TEST1.getName());
		
		String srer = RandomStringUtils.randomAlphanumeric(10);
		System.out.println("-----" + srer);
		
		String str = "id1pageNo1pageSize101wdcVBJI9";
		System.out.println(str.toUpperCase());
		 MessageDigest md = MessageDigest.getInstance("MD5");
		 md.update(srer.toString().getBytes());
		 String sig =new BigInteger(1, md.digest()).toString(16); 
		 System.out.println(sig);
		 
		 Map<Integer, String> map = new HashMap<Integer, String>();
		 Map<Integer, String> map1 = new HashMap<Integer, String>();
		 map.put(1, "1");
		 BeanUtils.copyProperties(map, map1);
		 System.out.println(map.get(1));
		 System.out.println(map1.get(1));*/
		Map<String, String> paraMap = new HashMap<String, String>();
		paraMap.put("batchId", "46788493");
		paraMap.put("sortType", "4");
		paraMap.put("t", "2017-10-26 11:25:00");
		List<String> paraNames = new ArrayList<String>(paraMap.keySet());
		Collections.sort(paraNames);
		StringBuffer buffer = new StringBuffer();
		for(String paraName : paraNames) {
			buffer.append(paraName).append(paraMap.get(paraName));
		}
		System.out.println(buffer.toString());
		System.out.println(buffer.toString() + "93894c610ebd6d817887cee4753a08c5");
		String sig = (buffer.toString() + "93894c610ebd6d817887cee4753a08c5").toUpperCase();
		System.out.println(sig);
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update("93894c610ebd6d817887cee4753a08c5".toUpperCase().getBytes());
		 String sign =new BigInteger(1, md.digest()).toString(16); 
		 System.out.println(sign);
	}
}
