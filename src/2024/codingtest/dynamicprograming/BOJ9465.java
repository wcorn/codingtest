package codingtest.dynamicprograming;

import java.io.*;
import java.util.*;

public class BOJ9465 {
    private static int T;
    private static StringBuilder sb;
    private static int[][] sticker;
    private static int[][] dp;
    private static int n;
    private static int[] dx = {-1, 0, 0, 1};
    private static int[] dy = {0, -1, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            n = Integer.parseInt(br.readLine());
            sticker = new int[2][n];
            dp = new int[2][n];
            for (int j = 0; j < 2; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    sticker[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            solve();
        }
        System.out.println(sb);
    }

    private static void solve() {
        if (n == 1) {
            sb.append(Math.max(sticker[0][0], sticker[1][0])).append("\n");
            return;
        }
        dp[0][0] = sticker[0][0];
        dp[1][0] = sticker[1][0];
        dp[0][1] = dp[1][0] + sticker[0][1];
        dp[1][1] = dp[0][0] + sticker[1][1];
        int temp;
        for (int i = 2; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                temp = Math.max(dp[0][i - 2], dp[1][i - 2]);
                temp = Math.max(dp[1 - j][i - 1], temp);
                dp[j][i] = temp + sticker[j][i];
            }
        }
        sb.append(Math.max(dp[0][n - 1], dp[1][n - 1])).append("\n");
    }
}
