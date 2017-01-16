package LeetCode;

public class A167 {
    public int[] twoSum(int[] numbers, int target) {
    	// 2ms, can it be better?
        int num = numbers[0]+numbers[numbers.length-1];
        int[] result = {1,numbers.length};
        while (num != target) {
            if (num > target)
                result[1]--;
            else
                result[0]++;
            num = numbers[result[0]-1]+numbers[result[1]-1];
        }
        return result;
    }
}
