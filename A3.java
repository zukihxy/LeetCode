package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class A3 {
    public static int lengthOfLongestSubstring(String s) {
// slow version with brute force
//        String result = "";
//        int ret = 0;
//        int max = 0;
//        for (int i = 0; i < s.length(); i++) {
//        	if (result.contains(s.charAt(i)+"")) {
//                if (max<ret)max = ret;
//                result = result.substring(result.indexOf(s.charAt(i))+1,result.length())+s.charAt(i);
//                ret = result.length();
//        	} else {
//                ret++;
//                result += s.charAt(i);        		
//        	}
//        }
//        if (max<ret)max = ret;
    	if (s.length()==0) 
    		return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for (int i=0, j=0; i<s.length(); ++i){
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }
    
	public static void main(String[] args) {
		System.out.println(A3.lengthOfLongestSubstring("bbbb")); //1
		System.out.println(A3.lengthOfLongestSubstring("abcabcbb")); //3
		System.out.println(A3.lengthOfLongestSubstring("pwwkew")); //3
		System.out.println(A3.lengthOfLongestSubstring("dvdf")); //3
		System.out.println(A3.lengthOfLongestSubstring("c")); //1
		System.out.println(A3.lengthOfLongestSubstring("cdd")); //2
		System.out.println(A3.lengthOfLongestSubstring("abba")); //2
		System.out.println(A3.lengthOfLongestSubstring("")); //0
	}
}
