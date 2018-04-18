package learn.link_test;

public class Test1 {
	public static ListNode add(ListNode l1, ListNode l2) {
		ListNode l = new ListNode(0), ln = l;
		int out = 0;
		while(l1 != null || l2 != null) {
			int a = l1 == null? 0: l1.val, b = l2 == null? 0 : l2.val, c;
			c = a + b + out;
			out = c / 10;
			ln.next = new ListNode(c % 10);
			ln = ln.next;
		}
		return l;
	}
}
