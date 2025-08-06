package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/1535"> 안녕 </a>
 */
public class BOJ1535 {

    private static int N;
    private static int[] a;
    private static int[] b;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        a = new int[N + 1];
        b = new int[N + 1];
        dp = new int[N + 1][100];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < 100; j++) {
                if (j - a[i] >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j - a[i]] + b[i], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[N][99]);
    }
}
