package LeetCode;

public class A413 {
    public int numberOfArithmeticSlices(int[] A) {
        if (A.length < 3)
            return 0;
        int delta = A[1] - A[0];
        int count = 2;
        int result = 0;
        for (int i = 1; i < A.length-1; i++) {
            if (A[i+1] - A[i] != delta) {
                delta = A[i+1] - A[i];
                if (count > 2)
                    result += (count-1)*(count-2)/2;
                count = 2;
            } else 
                count++;
        }
        if (count > 2)
            result += (count-1)*(count-2)/2;
        return result;
    }
}
