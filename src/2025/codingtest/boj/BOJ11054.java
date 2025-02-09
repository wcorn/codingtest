package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/11054"> 가장 긴 바이토닉 부분 수열 </a>
 */
public class BOJ11054 {

    private static int N;
    private static int[] A;
    private static int[] dp1;
    private static int[] dp2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        dp1 = new int[N];
        dp2 = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i]) {
                    dp1[i] = Math.max(dp1[i], dp1[j] + 1);
                }
            }
        }
        for (int i = N - 1; i >= 0; i--) {
            for (int j = N - 1; j >= i; j--) {
                if (A[j] < A[i]) {
                    dp2[i] = Math.max(dp2[i], dp2[j] + 1);
                }
            }
        }
        int answer = 0;
        for (int i = 0; i < N; i++) {
            answer = Math.max(answer, dp1[i] + dp2[i]);
        }
        System.out.println(answer - 1);
    }
}
