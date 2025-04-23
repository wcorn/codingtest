package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/2293"> 동전 1 </a>
 */
public class BOJ2293 {

    private static int N;
    private static int M;
    private static int[] arr;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        dp = new int[M * 2];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= M-arr[i]; j++) {
                dp[j + arr[i]] += dp[j];
            }
        }
        System.out.println(dp[M]);
    }
}
