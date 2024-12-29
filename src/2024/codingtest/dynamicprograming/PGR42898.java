package codingtest.dynamicprograming;

public class PGR42898 {

    public static void main(String[] args) {
        System.out.println(solution(4,3,new int[][]{{2, 2}}));
    }
    public static int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[m][n];
        for (int[] puddle : puddles) {
            dp[puddle[0] - 1][puddle[1] - 1] = -1;
        }
        int a, b;
        for(int i=0;i<m;i++){
            if(dp[i][0]==-1)
                break;
            dp[i][0] = 1;
        }
        for(int i=0;i<n;i++){
            if(dp[0][i]==-1)
                break;
            dp[0][i] = 1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                a = 0;
                b = 0;
                if(dp[i][j]==-1)
                    continue;
                if(dp[i-1][j]!=-1)
                    a = dp[i-1][j];
                if(dp[i][j-1]!=-1)
                    b = dp[i][j-1];
                dp[i][j] = (a+b)%1000000007;
            }
        }
        return dp[m-1][n-1]%1000000007;
    }
}
