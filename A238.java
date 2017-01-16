package LeetCode;

public class A238 {
	public int[] productExceptSelf(int[] nums) {
		int n = nums.length; // such a brilliant idea o(n) time and no extra space
		int[] res = new int[n];
		res[0] = 1;
		for (int i = 1; i < n; i++) {
			res[i] = res[i - 1] * nums[i - 1];
		}
		int right = 1;
		for (int i = n - 1; i >= 0; i--) {
			res[i] *= right;
			right *= nums[i];
		}
		return res;
	}
}
