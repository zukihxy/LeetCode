package LeetCode;

public class A343 {
	// this is more of a math problem
	// see: 
	//      https://discuss.leetcode.com/topic/43055/why-factor-2-or-3-the-math-behind-this-problem
	public int integerBreak(int n) {
        if(n==2) return 1;
        if(n==3) return 2;
        int product = 1;
        while(n>4){ // larger than 4 will do
            product*=3;
            n-=3;
        }
        product*=n;
        
        return product;
    }
}
