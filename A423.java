package LeetCode;

import java.util.LinkedHashMap;
import java.util.Map;

public class A423 {
	/*
	 *  1. Map operation is time consuming.
	 *  2. StringBuilder seem to be faster. 
	 *     reason: http://www.cnblogs.com/gis-crazy/archive/2012/08/29/2661477.html
	 */
	
//	public static String originalDigits(String s) {
////		Map<Character, Integer> m = new LinkedHashMap<Character, Integer>();
//		int[] digits = new int[10];
//		String ans = "";
////		for (int i = 0; i < s.length(); i++) {
////			int num = m.getOrDefault(s.charAt(i), 0);
////			m.put(s.charAt(i), num + 1);
////		}
//
//		for (int i = 0; i < s.length(); i++) {
//			char c = s.charAt(i);
//			if (c == 'z') digits[0]++;
//			if (c == 'w') digits[2]++;
//			if (c == 'u') digits[4]++;
//			if (c == 'x') digits[6]++;
//			if (c == 'g') digits[8]++;
//			if (c == 'i') digits[9]++;
//			if (c == 'f') digits[5]++;
//			if (c == 's') digits[7]++;
//			if (c == 'h') digits[3]++;
//			if (c == 'o') digits[1]++;
//		}
////		digits[0] = m.getOrDefault('z', 0);
////		digits[2] = m.getOrDefault('w', 0);
////		digits[8] = m.getOrDefault('g', 0);
////		digits[4] = m.getOrDefault('u', 0);
////		digits[6] = m.getOrDefault('x', 0);
////		// m.put('e', m.getOrDefault('e', 0)-digits[0]-digits[8]-digits[4]);
////		// m.put('r', m.getOrDefault('r', 0)-digits[0]-digits[4]);
////		m.put('o', m.getOrDefault('o', 0) - digits[0] - digits[2] - digits[4]);
////		// m.put('t', m.getOrDefault('t', 0)-digits[2]-digits[8]);
////		m.put('i', m.getOrDefault('i', 0) - digits[8] - digits[6]);
////		m.put('f', m.getOrDefault('f', 0) - digits[4]);
////		m.put('h', m.getOrDefault('h', 0) - digits[8]);
////		m.put('s', m.getOrDefault('s', 0) - digits[6]);
//
//		digits[1] -= digits[0]+digits[2]+digits[4];
//		digits[3] -= digits[8];
//		digits[5] -= digits[4];
//		digits[7] -= digits[6];
//		digits[9] -= digits[5]+digits[6]+digits[8];
////		digits[5] = m.getOrDefault('f', 0);
////		digits[7] = m.getOrDefault('s', 0);
////		digits[3] = m.getOrDefault('h', 0);
////		digits[1] = m.getOrDefault('o', 0);
////
////		m.put('i', m.getOrDefault('i', 0) - digits[5]);
////		digits[9] = m.getOrDefault('i', 0);
//
//		for (int i = 0; i <= 9; i++) {
//			for (int j = 0; j < digits[i]; j++)
//				ans += i;
//		}
//
//		return ans;
//	}

	public String originalDigits(String s) {
	    int[] count = new int[10];
	    for (int i = 0; i < s.length(); i++){
	        char c = s.charAt(i);
	        if (c == 'z') count[0]++;
	        if (c == 'w') count[2]++;
	        if (c == 'x') count[6]++;
	        if (c == 's') count[7]++; //7-6
	        if (c == 'g') count[8]++;
	        if (c == 'u') count[4]++; 
	        if (c == 'f') count[5]++; //5-4
	        if (c == 'h') count[3]++; //3-8
	        if (c == 'i') count[9]++; //9-8-5-6
	        if (c == 'o') count[1]++; //1-0-2-4
	    }
	    count[7] -= count[6];
	    count[5] -= count[4];
	    count[3] -= count[8];
	    count[9] = count[9] - count[8] - count[5] - count[6];
	    count[1] = count[1] - count[0] - count[2] - count[4];
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i <= 9; i++){
	        for (int j = 0; j < count[i]; j++){
	            sb.append(i);
	        }
	    }
	    return sb.toString();
	}
}
