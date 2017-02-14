package LeetCode;

public class A516 {
	/*
	 * My solution: TLE
	 * if the string is long, will go through the string for many times.
	 */
//    private String origin;
//    private int l;
//    public int longestPalindromeSubseq(String s) {
//        int i = 0;
//        int j = s.length()-1;
//        if (j < 0) return 0;
//        origin = s;
//        l = j;
//        return find(i, j, 0);
//    }
//    
//    private int find(int i, int j, int len) {
//        if (j<0 || i>l) return len;
//        if (origin.charAt(i) == origin.charAt(j)) 
//            return find(i+1, j-1, len+1);
//        else
//            return Math.max(find(i, j-1, len), find(i+1, j, len));
//    }
	
	/*
	 * Discussion:
	 * pay space for time, save the result of subproblems
	 * also enabled iteration instead of recursion
	 */
	public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        
        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i+1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][s.length()-1];
    }
}
