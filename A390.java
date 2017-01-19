package LeetCode;

public class A390 {
	public int lastRemaining(int n) {
		boolean left = true; 
		int remaining = n;
		int step = 1; // nice design!
		int head = 1;
		while (remaining > 1) {
			if (left || remaining % 2 == 1) {
				head = head + step;
			}
			remaining = remaining / 2;
			step = step * 2;
			left = !left;
		}
		return head;

		// one line answer, slower though
		// return n == 1 ? 1 : 2 * (1 + n / 2 - lastRemaining(n / 2));
	}
}
