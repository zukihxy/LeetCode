package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class A442 {
	public List<Integer> findDuplicates(int[] nums) {
		// TLE
//        List<Integer> result = new LinkedList<Integer>();
//        for (int i = 0; i < nums.length; i++) {
//            while (nums[i] != nums[nums[i]-1]) {
//            	// exchange i and nums[i]-1
//            	int temp = nums[i];
//            	nums[i] = nums[nums[i]-1];
//            	nums[temp-1] = temp;
//            }
//            if (i!=nums[i]-1 && !result.contains(nums[i]))
//            	result.add(nums[i]);
//        }
//        return result;
		List<Integer> res = new ArrayList<Integer>(); // use negative as a mark
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i])-1;
            if (nums[index] < 0)
                res.add(Math.abs(index+1));
            nums[index] = -nums[index];
        }
        return res;
    }
	
	public static void main(String[] args) {
		A442 t = new A442();
		int[] nums = {4,3,2,7,8,2,3,1};
		List<Integer> ans = t.findDuplicates(nums);
		for (int a:ans)
			System.out.println(a);
	}
}
