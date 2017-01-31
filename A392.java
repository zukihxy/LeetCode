package LeetCode;

public class A392 {
	// subsequence here do not have to be continuous!
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        int indexS = 0, indexT = 0;
        while (indexT < t.length()) {
            if (t.charAt(indexT) == s.charAt(indexS)) {
                indexS++;
                if (indexS == s.length()) return true;
            }
            indexT++;
        }
        return false;
    }
    
    /* good idea about follow up
     * public:
    vector<bool> isSubsequence(vector<string> ss, string t) {
    	vector<string::const_iterator> iters(ss.size());
    	vector<vector<int> > waitingList(26);
    	for(int i = 0; i < ss.size(); i++) {
    		iters[i] = ss[i].begin();
    		waitingList[*iters[i] - 'a'].push_back(i);
    	}
        for(char c : t) {
        	vector<int> updateList = waitingList[c - 'a'];
        	waitingList[c - 'a'].clear();
        	for(int i : updateList) {
        		iters[i]++;
        		waitingList[*iters[i] - 'a'].push_back(i);
        	}
        }
        vector<bool> ans(ss.size());
        for(int i = 0; i < ss.size(); i++) {
        	ans[i] = iters[i] == ss[i].end();
        }
        return ans;
    }*/
}
