package LeetCode;

public class A122 {
	public int maxProfit(int[] prices) {
		if (prices.length < 2)
            return 0;
        else if (prices.length == 2)
            if (prices[0] < prices[1])
                return prices[1]-prices[0];
            else return 0;
        boolean has = prices[1]>=prices[0] ? true : false;
        int buy = prices[1]>=prices[0] ? prices[0] : 0;
        int profit = 0;
        for (int i = 1; i < prices.length-1; i++) {
            if (has && prices[i-1]<=prices[i] && prices[i+1]<prices[i]) {
                has = false;
                profit += prices[i]-buy;
            } else if (!has && prices[i-1]>=prices[i] && prices[i+1]>prices[i]) {
                has = true;
                buy = prices[i];
            }
        }
        if (has) profit += prices[prices.length-1]-buy;
        return profit;
    }
	
	public static void main(String[] args) {
		A122 t = new A122();
		System.out.println(t.maxProfit(new int[]{2,1,4,5,2,9,7}));
	}
}
