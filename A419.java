package LeetCode;

public class A419 {
	public int countBattleships(char[][] board) {
//		if (board.length < 1 || board[0].length < 1)
//            return 0;
//        int result = 0;
//        int line = board.length;
//        int row = board[0].length;
//        for (int i = 0; i < line; i++) {
//            for (int j = 0; j < row; j++) {
//                if (board[i][j] == 'X') {
//                    if (i == 0 || (i>0 && board[i-1][j]=='.')) {
//                        result++;
//                        while (j < board[i].length && board[i][j] == 'X')
//                            j++;
//                    }
//                }
//            }
//        }
//        return result;
		
		int m = board.length; // extract it out may make it faster
        if (m==0) return 0;
        int n = board[0].length;
        
        int count=0;
        
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (board[i][j] == '.') continue;
                if (i > 0 && board[i-1][j] == 'X') continue;
                if (j > 0 && board[i][j-1] == 'X') continue; // horizontal case w/o while loop seem to be better
                count++;
            }
        }
        
        return count;
    }
}
