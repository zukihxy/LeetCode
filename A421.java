package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class A421 {
	/*
	 *  wrong answer: since what we need to find is not the max 
	 *                number, but the max index of 1.
	 */
//    public int findMaximumXOR(int[] nums) {
//        int max = 0;
//        for (int i = 0; i < nums.length; i++) 
//            if (max<nums[i])
//                max = nums[i];
//        int result = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (result<(nums[i]^max))
//                result = nums[i]^max;
//        }
//        return result;
//    }
	
	/*
	 *  from discussion
	 *   In first iteration, if you found that a, d, e, h, u differs on the MSB(most significant bit), 
	 *   so you are sure your final result's MSB is set. Now in second iteration, 
	 *   you try to see if among a, d, e, h, u there are at least two numbers make the 2nd MSB differs, 
	 *   if yes, then definitely, the 2nd MSB will be set in the final result.
	 */
	public int findMaximumXOR(int[] nums) {
        int max = 0, mask = 0;
        for(int i = 31; i >= 0; i--){
            mask = mask | (1 << i);
            Set<Integer> set = new HashSet<>();
            for(int num : nums){
                set.add(num & mask);
            }
            int tmp = max | (1 << i);
            for(int prefix : set){
                if(set.contains(tmp ^ prefix)) {
                    max = tmp;
                    break;
                }
            }
        }
        return max;
    }
}
