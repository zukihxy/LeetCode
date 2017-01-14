package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class A451 {
//    public String frequencySort(String s) {
//    	Map<Character, Integer> map = new HashMap<Character, Integer>();
//    	for (int i = 0; i < s.length(); i++) {
//    		int val = 1;
//            if (map.containsKey(s.charAt(i))) {
//            	val = map.get(s.charAt(i)) + 1;
//            }
//            map.put(s.charAt(i), val);
//        }
//    	// sort with build in method (TLE)
////    	List<Map.Entry<Character, Integer>> list =  new LinkedList<Map.Entry<Character, Integer>>( map.entrySet() );  
////        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>()  {  
////        	public int compare( Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2 ) {  
////                    return -(o1.getValue()).compareTo( o2.getValue() );  
////                }  
////            } );
////        String result = "";
////        for (Map.Entry<Character, Integer> l : list) {
////        	for (int i = 0; i < l.getValue(); i++) {
////        		result += l.getKey();
////        	}
////        }
////        return result;
//    	
//    	// sort with bucket
//    	String[] bucket = new String[s.length()+1];
//    	for (int i = 0; i < bucket.length; i++)
//    		bucket[i] = "";
//    	for (Map.Entry<Character, Integer> e : map.entrySet()) {
//    		for (int i = 0; i < e.getValue(); i++)
//    			bucket[e.getValue()] += e.getKey();
//    	}
//    	String result = "";
//    	for (int i = s.length(); i >= 0; i--)
//    		result += bucket[i];
//    	return result;
//    }
    
    public String frequencySort(String s) {
        if (s == null) {
            return null;
        }
        Map<Character, Integer> map = new HashMap();
        char[] charArray = s.toCharArray();
        int max = 0;
        for (Character c : charArray) {
            if (!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.put(c, map.get(c) + 1);
            max = Math.max(max, map.get(c));
        }

        String[] array = buildArray(map, max);
        return buildString(array);
    }

    private String[] buildArray(Map<Character, Integer> map, int maxCount) {
        String[] array = new String[maxCount + 1];
        for (Character c : map.keySet()) {
            int count = map.get(c);
            if (array[count] == null) {
                array[count] = "";
            }
            for (int j = 0; j < count; j++) 
                array[count] += c;
        }
        return array;
    }

    private String buildString(String[] array) {
    	String result = "";
        for (int i = array.length - 1; i > 0; i--) {
            String list = array[i];
            if (list != null) {
                result += array[i];
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
    	A451 test = new A451();
    	System.out.println(test.frequencySort("ababababababababbbbbbbbbbbbbbbbbbbbbbbbbbbaaaaaaaaaaaaaaaaaaabababababababababa"
    			+ "abababababababababababababababbababbbababababababababbbabababaa"));
    }
}
