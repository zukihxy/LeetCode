package LeetCode;

public class A59 {
    public int[][] generateMatrix(int n) {
    	int x = 0;
        int y = 0; 
        int xstep = 1;
        int ystep = 0;
        int[][] result = new int[n][n];
        for (int i = 1; i <= n*n; i++) {
            result[y][x] = i;
            if (x+xstep>=0 && x+xstep<n && y+ystep>=0 && y+ystep<n && result[y+ystep][x+xstep]==0) {
                x += xstep;
                y += ystep;
            } else {
                if (xstep==1 && ystep==0) {
                    xstep = 0;
                    ystep = 1;
                } else if (xstep==0 && ystep==1) {
                    xstep = -1;
                    ystep = 0;
                } else if (xstep==-1 && ystep==0) {
                    xstep = 0;
                    ystep = -1;
                } else if (xstep==0 && ystep==-1) {
                    xstep = 1;
                    ystep = 0;
                }
                x += xstep;
                y += ystep;
            }
        }
        return result;
    }
    
    // a python solution to rotate the matrix and add one roll
//    def generateMatrix(self, n):
//        A, lo = [], n*n+1
//        while lo > 1:
//            lo, hi = lo - len(A), lo
//            A = [range(lo, hi)] + zip(*A[::-1])
//        return A
    
    public static void main(String[] args) {
    	A59 t = new A59();
    	System.out.println(t.generateMatrix(3));
    }
}
