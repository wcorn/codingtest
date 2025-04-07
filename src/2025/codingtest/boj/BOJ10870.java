package codingtest.boj;

import java.io.*;

/**
 * <a href="https://www.acmicpc.net/problem/10870"> 피보나치 수 5 </a>
 */
public class BOJ10870 {

    private static int n;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        dp[0] = 0;
        if(n==0){
            System.out.println(0);
            return;
        }
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.println(dp[n]);
    }
}
