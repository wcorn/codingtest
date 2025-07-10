package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/1106"> 호텔 </a>
 */
public class BOJ1106 {

    private static int C;
    private static int N;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        dp = new int[1101];
        Arrays.fill(dp, 1_000_000);
        dp[0] = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            for (int j = b; j < dp.length; j++) {
                dp[j] = Math.min(dp[j], dp[j - b] + a);
            }
        }
        int answer = 1_000_000;
        for (int i = C; i < 1101; i++) {
            answer = Math.min(answer, dp[i]);
        }
        System.out.println(answer);
    }
}
