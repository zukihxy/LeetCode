package LeetCode;

import java.util.ArrayList;

public class A260 {
//	public int[] singleNumber(int[] nums) {
//        ArrayList<Integer> once = new ArrayList<Integer>();
//        for (int i = 0; i < nums.length; i++) {
//            if (!once.contains(nums[i]))
//                once.add(nums[i]);
//            else
//            	once.remove((Object)nums[i]);            	
//        }
//        int[] result = new int[2];
//        result[0] = once.get(0);
//        result[1] = once.get(1);
//        return result;
//    }
	public int[] singleNumber(int[] nums) { // brilliant idea with xor!!!
        // Pass 1 : 
        // Get the XOR of the two numbers we need to find
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        // Get its last set bit
        diff &= -diff;
        
        // Pass 2 :
        int[] rets = {0, 0}; // this array stores the two numbers we will return
        for (int num : nums)
        {
            if ((num & diff) == 0) // the bit is not set
            {
                rets[0] ^= num;
            }
            else // the bit is set
            {
                rets[1] ^= num;
            }
        }
        return rets;
    }
}
