package LeetCode;

import java.util.Arrays;

public class A462 {
    public int minMoves2(int[] nums) {
    	/*
    	 *  First of all, it is a problem of math. We just need to find the distance between
    	 *  every pair of (i, n-i) and that will be the moves.
    	 */
        Arrays.sort(nums);
        int i = 0, j = nums.length-1;
        int count = 0;
        while(i < j){
            count += nums[j]-nums[i];
            i++;
            j--;
        }
        return count;
    }
}
