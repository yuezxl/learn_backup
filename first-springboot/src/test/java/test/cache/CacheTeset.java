package test.cache;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.cache.Cache;
import com.cache.CacheManager;

public class CacheTeset {
	 public static void main(String[] args) {  
		 
		 List<Integer> list = new ArrayList<>();
		 Cache cache = new Cache();
		 for(int i = 0; i < 10; i++) {
			 list.add(i);
		 }
		 cache.setKey("test");
		 cache.setValue(list);
		 CacheManager.putCache("test", cache);
		 
		 System.out.println(JSON.toJSONString(CacheManager.getCacheInfo("test")));
		 
//	        System.out.println(CacheManager.getSimpleFlag("alksd"));  
//	        CacheManager.putCache("abc", new Cache());  
//	        System.out.println(CacheManager.getSimpleFlag("abc"));  
//	        CacheManager.putCache("def", new Cache());  
//	        CacheManager.putCache("ccc", new Cache());  
//	        CacheManager.clearOnly("");  
//	        Cache c = new Cache();  
//	        for (int i = 0; i < 10; i++) {  
//	            CacheManager.putCache("" + i, c);  
//	        }  
//	        CacheManager.putCache("aaaaaaaa", c);  
//	        CacheManager.putCache("abchcy;alskd", c);  
//	        CacheManager.putCache("cccccccc", c);  
//	        CacheManager.putCache("abcoqiwhcy", c);  
//	        System.out.println("删除前的大小："+CacheManager.getCacheSize());  
//	        CacheManager.getCacheAllkey();  
//	        CacheManager.clearAll("aaaa");  
//	        System.out.println("删除后的大小："+CacheManager.getCacheSize());  
//	        CacheManager.getCacheAllkey();  
	  
	  
	    }  
}
