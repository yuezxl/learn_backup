package test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.alibaba.fastjson.JSON;

import test.bean.Parent;

public class CollectionTest {
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		List<String> copy = new ArrayList<>();
		List<String> copy1 = new ArrayList<>(5);
		
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		
		copy.addAll(list);
		Collections.addAll(copy1, new String[list.size()]);
		Collections.copy(copy1, list);
		
		
		System.out.println(list.toString());
		System.out.println(copy.toString());
		System.out.println(copy1.toString());
		
		System.out.println("--------------------------");
		
		list.remove(0);
		
		System.out.println(list.toString());
		System.out.println(copy.toString());
		System.out.println(copy1.toString());
		
		System.out.println("===============================================");
		
		List<Parent> parentList = new ArrayList<>();
		List<Parent> parentCopy = new ArrayList<>();
		List<Parent> parentCopy1 = new ArrayList<>();
		List<Parent> parentCopy2 = new ArrayList<>();
		List<Parent> parentCopy3 = new ArrayList<>();
		
		
		for(int i = 0; i < 3; i ++) {
			Parent parent = new Parent();
			parent.setAge(222);
			parent.setName("aaaa");
			parentList.add(parent);
		}
		
		for(Parent parent : parentList) {
			parentCopy1.add(parent);
			
			Parent newParent = new Parent();
			//newParent.setName(parent.getName());
			newParent = parent.clone();
			
			parentCopy2.add(newParent);
		}
		
		parentCopy.addAll(parentList);
		Collections.addAll(parentCopy3, new Parent[parentList.size()]);
		Collections.copy(parentCopy3, parentList);
		
		System.out.println(JSON.toJSONString(parentList));
		System.out.println(JSON.toJSONString(parentCopy));
		System.out.println(JSON.toJSONString(parentCopy1));
		System.out.println(JSON.toJSONString(parentCopy2));
		System.out.println(JSON.toJSONString(parentCopy3));
		
		System.out.println("++++++++++++++++++++++++++++++++++++++");
		
		for(int i = 0; i < 3; i ++) {
			parentList.get(i).setName("bbbb");
		}
		System.out.println(JSON.toJSONString(parentList));
		System.out.println(JSON.toJSONString(parentCopy));
		System.out.println(JSON.toJSONString(parentCopy1));
		System.out.println(JSON.toJSONString(parentCopy2));
		System.out.println(JSON.toJSONString(parentCopy3));
		
	}
	
}
