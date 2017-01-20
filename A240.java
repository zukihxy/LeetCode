package LeetCode;

public class A240 {
//    public boolean searchMatrix(int[][] matrix, int target) {
//        int xs = 0;
//        int xe = matrix.length-1;
//        int ys = 0;
//        int ye = matrix[0].length-1;
//        if (xe<0 || ye<0) return false;
//        return pointer(matrix, xs,xe,ys,ye,target);
//    }
//    
//    private boolean pointer(int[][] matrix, int xs, int xe, int ys, int ye, int target) {
//    	if (xs >= xe || ys >= ye)
//    		return false;
//    	if (xs == xe-1 && ys == ye-1 && matrix[xs][ys]!=target && matrix[xs][ye]!=target && matrix[xe][ys]!=target && matrix[xe][ye]!=target)
//    		return false;
//    	if (matrix[xe][ye] < target || matrix[xs][ys] > target)
//        	return false;
//    	int x = (xs+xe)/2;
//    	int y = (ys+ye)/2;
//    	if (matrix[x][y] == target) {
//    		return true;
//    	} else if (matrix[x][y] > target) {
//    		return pointer(matrix, xs,x,ys,y,target) || pointer(matrix, x,xe,ys,y,target) || pointer(matrix, xs,x,y,ye,target);
//    	} else{
//    		return pointer(matrix, x,xe,y,ye,target) || pointer(matrix, x,xe,ys,y,target) || pointer(matrix, xs,x,y,ye,target);
//    	}
//    }
	
	// simpler solution
	public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1 || matrix[0].length <1) {
            return false;
        }
        int col = matrix[0].length-1;
        int row = 0;
        while(col >= 0 && row <= matrix.length-1) {
            if(target == matrix[row][col]) {
                return true;
            } else if(target < matrix[row][col]) {
                col--;
            } else if(target > matrix[row][col]) {
                row++;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
    	A240 t = new A240();
    	int[][] matrix = {
    	                  {1,   4,  7, 11, 15},
    	                  {2,   5,  8, 12, 19},
    	                  {3,   6,  9, 16, 22},
    	                  {10, 13, 14, 17, 24},
							{18, 21, 23, 26, 30}
    	                  };
    	System.out.println(t.searchMatrix(matrix, 20));
    }
}
