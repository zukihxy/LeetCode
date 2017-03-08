package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class A22 {
//    private static List<String> list = new ArrayList<String>();
//    
//    public List<String> generateParenthesis(int n) {
//        backtrack("()",n);
//        return list;
//    }
//    
//    public void backtrack(String str, int max){
//        if(str.length() == max*2){
//            if (!list.contains(str)) list.add(str);
//            return;
//        }
//        backtrack("("+str+")", max);
//        backtrack(str+"()", max);
//        backtrack("()"+str, max);
//    }
	
	public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }
    
    public void backtrack(List<String> list, String str, int open, int close, int max){
        
        if(str.length() == max*2){
            list.add(str);
            return;
        }
        
        if(open < max)
            backtrack(list, str+"(", open+1, close, max);
        if(close < open)
            backtrack(list, str+")", open, close+1, max);
    }
}
