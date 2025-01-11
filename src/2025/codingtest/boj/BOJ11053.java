package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/11053"> 가장 긴 증가하는 부분 수열 </a>
 */
public class BOJ11053 {

    private static int N;
    private static int[] arr;
    private static int[] dp;
    private static int idx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N];
        st = new StringTokenizer(br.readLine());
        idx = 1;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = arr[0];
        for (int i = 1; i < N; i++) {
            if (dp[idx - 1] < arr[i]) {
                dp[idx++] = arr[i];
            } else {
                int index = Arrays.binarySearch(dp, 0, idx, arr[i]);
                dp[index < 0 ? -(index + 1) : index] = arr[i];
            }
        }
        System.out.println(idx);
    }
}
