package LeetCode;

public class A338 {
    public int[] countBits(int num) {
//    	int[] result = new int[num+1];
//        if (num == 0) {
//        	result[0] = 0;
//        	return result;
//        } else 
//        	result[1] = 1;
//        int power = 2;
//        for (int i = 2; i <= num; i++) {
//        	result[i] = result[i % power] + 1;
//        	if ((i+1) % power == 0)
//        		power = i+1;// w/o Math.pow is faster (3ms)
//        }
//        return result;
    	int[] f = new int[num + 1]; // f[i] = f[i / 2] + i % 2
        for (int i=1; i<=num; i++) 
        	f[i] = f[i >> 1] + (i & 1); // use shift seem to be better
        return f;
    }
    
	public static void main(String[] args) {
		A338 test = new A338();
		System.out.println(test.countBits(4)); //1
	}
}
