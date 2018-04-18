package test;

public class ArrTest {
	
	public static void main(String[] args) {
		Item[] items = new Item[5];
		
		for(int i = 0; i < 5; i++) {
			String key = String.valueOf(i);
			String value = String.valueOf(i + 1);
			Item item = new Item(key, value);
			items[i] = item;
		}
		
		System.out.println("1---------------");
		for(Item item : items) {
			System.out.println(item.toString());
		}
		System.out.println("2---------------");
		for(Item item : items) {
			Item itemTmp = new Item("tmp", "tmp");
			item = itemTmp;
			System.out.println(item.toString());
		}
		System.out.println("3---------------");
		for(Item item : items) {
			System.out.println(item.toString());
		}
		System.out.println("4---------------");
		
		for(int i = 0; i < 5; i++) {
			String key = String.valueOf(i + 10);
			String value = String.valueOf(i + 10);
			Item item1 = items[i];
			Item item = new Item(key, value);
			item1 = item;
		}
		
		System.out.println("5---------------");
		for(Item item : items) {
			System.out.println(item.toString());
		}
		
		
		
	}
	
	static class Item {
		private String key;
		private String value;
		
		Item(String key, String value) {
			this.key = key;
			this.value = value;
		}
		
		public String getKey() {
			return key;
		}
		public void setKey(String key) {
			this.key = key;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
		
		public String toString() {
			return this.key + "-" + this.value;
		}
	}
}
