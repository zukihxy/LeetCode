package LeetCode;

public class A5 {
//	public String longestPalindrome(String s) {
//		if (s.length() < 2)
//			return s;
//		String result = "" + s.charAt(0);
//		int max = 1;
//		for (int i = 1; i < s.length(); i++) {
//			String found = "";
//			if (i+1<s.length() && s.charAt(i-1) == s.charAt(i+1)) {
//				// case of aba
//				found = findPalin(s, i-1, i+1);
//			}
//			if (found.length() > max) {
//				result = found;
//				max = found.length();
//			}
//			if (s.charAt(i) == s.charAt(i-1)) {
//				// case of bb
//				found = findPalin(s, i-1, i);
//			}
//			if (found.length() > max) {
//				result = found;
//				max = found.length();
//			}
//		}
//        return result;
//    }
//	
//	private String findPalin(String s, int start, int end) {
//		String result = s.substring(start, end+1);
//		if (start >= 1 && end < s.length()-1 && s.charAt(start-1) == s.charAt(end+1))
//			result = findPalin(s, start-1, end+1);
//		return result;
//	}
	private int lo, maxLen;
	public String longestPalindrome(String s) {
		int len = s.length();
		if (len < 2)
			return s;
		
	    for (int i = 0; i < len-1; i++) {
	     	findPalin(s, i, i);  //case of aba
	     	findPalin(s, i, i+1); //case of bb
	    }
	    return s.substring(lo, lo + maxLen);
	}

	private void findPalin(String s, int j, int k) {
		while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
			j--;
			k++;
		}
		if (maxLen < k - j - 1) {
			lo = j + 1;
			maxLen = k - j - 1;
		}
	}
		
	public static void main(String[] args) {
		A5 test = new A5();
//		System.out.println(test.longestPalindrome("babad")); //aba
//		System.out.println(test.longestPalindrome("cbba")); //bb
//		System.out.println(test.longestPalindrome("ccc")); //ccc
		System.out.println(test.longestPalindrome("bb")); //bb
//		System.out.println(test.longestPalindrome("a")); //a
	}
}
