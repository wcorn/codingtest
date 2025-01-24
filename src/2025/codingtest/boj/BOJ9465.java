package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/9465"> 스티커 </a>
 */
public class BOJ9465 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        int n;
        int[][] map;
        for (int i = 0; i < T; i++) {
            n = Integer.parseInt(br.readLine());
            map = new int[2][n];
            for (int j = 0; j < 2; j++) {
                st = new StringTokenizer(br.readLine());
                for (int t = 0; t < n; t++) {
                    map[j][t] = Integer.parseInt(st.nextToken());
                }
            }
            int num = solve(n, map);
            sb.append(num).append("\n");
        }
        System.out.print(sb);
    }

    private static int solve(int n, int[][] map) {
        int[][] dp = new int[2][n];
        dp[0][0] = map[0][0];
        dp[1][0] = map[1][0];
        for(int i = 1; i<n; i++){
            dp[0][i] = Math.max(dp[0][i-1],dp[1][i-1]+map[0][i]);
            dp[1][i] = Math.max(dp[1][i-1],dp[0][i-1]+map[1][i]);
        }
        return Math.max(dp[0][n-1],dp[1][n-1]);
    }
}
