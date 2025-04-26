package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/2294"> 동전 2 </a>
 */
public class BOJ2294 {

    private static int N;
    private static int K;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dp = new int[K + 1];
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            for (int j = 0; j <= K - num; j++) {
                if (j != 0 && dp[j] == 0) {
                    continue;
                }
                if (dp[j + num] == 0) {
                    dp[j + num] = dp[j] + 1;
                } else {
                    dp[j + num] = Math.min(dp[j] + 1, dp[j + num]);
                }
            }
        }
        if (dp[K] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(dp[K]);
        }
    }
}
