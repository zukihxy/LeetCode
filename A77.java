package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class A77 {
	/*
	 vector<vector<int>> combine(int n, int k) {
		vector<vector<int>> result;
		int i = 0;
		vector<int> p(k, 0);
		while (i >= 0) {
			p[i]++;
			if (p[i] > n) --i;
			else if (i == k - 1) result.push_back(p);
			else {
			    ++i;
			    p[i] = p[i - 1];
			}
		}
		return result;
	} */
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		int i = 0;
		int[] p = new int[k];
		while (i >= 0) {
			p[i]++;
			if (p[i] > n) --i;
			else if (i == k - 1) {
				List<Integer> a = new ArrayList<Integer>();
				for (int j : p)
					a.add(j);
				result.add(a);
			}
			else {
			    ++i;
			    p[i] = p[i - 1];
			}
		}
		return result;
	}
	
    public static void main(String[] args) {
    	A77 t = new A77();
    	System.out.println(t.combine(4, 2));
    }
}
