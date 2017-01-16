package LeetCode;

import java.util.Stack;

public class A445 {
	public class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) { val = x; }
	 }
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// brute force, 63ms, but there do not seem to be better way...
        Stack<Integer> s1 = new Stack<Integer>();
        ListNode n = l1;
        while (n != null) {
        	s1.push(n.val);
        	n = n.next;
        }
        Stack<Integer> s2 = new Stack<Integer>();
        n = l2;
        while (n != null) {
        	s2.push(n.val);
        	n = n.next;
        }
        ListNode result = new ListNode(0);
        n = null;
        while (true) {
        	int num1 = -1;
        	int num2 = -1;
        	if (!s1.isEmpty())
        		num1 = s1.pop();
        	if (!s2.isEmpty())
        		num2 = s2.pop();
        	if (num1 == -1 && num2 == -1)
        		break;
        	num1 = num1>0 ? num1 : 0;
        	num2 = num2>0 ? num2 : 0;
        	int sum = num1+num2+result.val;
//        	if (sum > 9) {
        		n = new ListNode(sum%10);
        		n.next = result.next;
        		result.next = n;
        		result.val = sum/10;
//        	} else {
//        		n = new ListNode(sum);
//        		n.next = result.next;
//        		result.next = n;
//        		result.val = 0;
//        	}
        }
        if (result.val == 0)
        	result = result.next;
        return result;
    }
	
	public static void main(String[] args) {
		A445 t = new A445();
		ListNode l1 = t.new ListNode(7);
		l1.next = t.new ListNode(2);
		l1.next.next = t.new ListNode(4);
		l1.next.next.next = t.new ListNode(3);
		ListNode l2 = t.new ListNode(5);
		l2.next = t.new ListNode(6);
		l2.next.next = t.new ListNode(4);
		ListNode n = t.addTwoNumbers(l1, l2);
		while (n != null) {
			System.out.println(n.val);
			n = n.next;
		}
		
	}
}
