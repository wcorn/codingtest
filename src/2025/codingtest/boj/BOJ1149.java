package codingtest.boj;

import java.io.*;
import java.util.*;

public class BOJ1149 {

    private static int N;
    private static int[][] map;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][3];
        dp = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0] = map[0];
        for (int i = 1; i < N; i++) {
            dp[i][0] = map[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = map[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = map[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }
        System.out.println(Math.min(dp[N - 1][0], Math.min(dp[N - 1][1], dp[N - 1][2])));
    }
}
