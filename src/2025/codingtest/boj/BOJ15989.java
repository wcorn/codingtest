package codingtest.boj;

import java.io.*;

/**
 * <a href="https://www.acmicpc.net/problem/15989"> 1, 2, 3 더하기 4 </a>
 */
public class BOJ15989 {

    private static int N;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        dp = new int[10001][4];
        dp[1][1] = 1; // 1
        dp[2][1] = 1; // 1+1
        dp[2][2] = 1; //  2
        dp[3][1] = 1; // 1+1+1
        dp[3][2] = 1; // 1+2
        dp[3][3] = 1; // 3
        for (int i = 4; i <= 10000; i++) {
            dp[i][1] = dp[i - 1][1];
            dp[i][2] = dp[i - 2][1] + dp[i - 2][2];
            dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3];
        }
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            sb.append(dp[num][1] + dp[num][2] + dp[num][3]).append("\n");
        }
        System.out.println(sb);
    }
}
