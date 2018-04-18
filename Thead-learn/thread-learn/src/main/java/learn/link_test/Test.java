package learn.link_test;

public class Test {
	public static void main(String[] args) {
		/*ListNode l1 = int2ListNode(99999991);
		ListNode l2 = int2ListNode(9);
		outPutListNode(l1);
		System.out.println("");
		outPutListNode(l2);
		System.out.println("");
		System.out.println(ListNode2Int(l1));
		ListNode result = addListNode(l1, l2);
		System.out.println("");
		outPutListNode(result);*/
		
		
		ListNode l1 = int2ListNode(342);
		ListNode l2 = int2ListNode(465);
		outPutListNode(add(l1,l2));
	}
	
	public static ListNode add(ListNode l1, ListNode l2) {
		ListNode l = new ListNode(0), ln = l;
		int out = 0;
		while(l1 != null || l2 != null || out > 0) {
			int a = l1 == null? 0: l1.val, b = l2 == null? 0 : l2.val, c;
			c = a + b + out;
			out = c / 10;
			l.next = new ListNode(c % 10);
			l = l.next;
			l1 = l1 == null ? null : l1.next;
			l2 = l2 == null ? null : l2.next;
		}
		return ln.next;
	}
	
	private static ListNode addListNode(ListNode l1, ListNode l2) {
		return int2ListNode(ListNode2Int(l1) + ListNode2Int(l2));
	}
	
	private static int ListNode2Int(ListNode l) {
		int result = 0;
		for(int i =0; l!=null; i ++) {
			result = result + (int) (l.val*(Math.pow(10, i)));
			l = l.next;
		}
		return result;
	}
	
	private static ListNode int2ListNode(int result) {
		int i = String.valueOf(result).length();
		ListNode l = null;
		for(i = String.valueOf(result).length(); i > 0; i--) {
			if(l == null) {
				l = new ListNode(result / (int) (Math.pow(10, i-1)));
			} else {
				ListNode tmp = l;
				l = new ListNode(result / (int) (Math.pow(10, i-1)));
				l.next = tmp;
			}
			result = result % ((int) (Math.pow(10, i-1)));
		}
		return l;
	}
	
	public static void outPutListNode(ListNode l) {
		while(l != null) {
			if(l.next != null) {
				System.out.print(l.val + "-->");
			} else {
				System.out.print(l.val);
			}
			l = l.next;
		}
	}
}
