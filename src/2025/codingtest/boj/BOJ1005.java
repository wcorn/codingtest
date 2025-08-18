package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/1005"> ACM Craft </a>
 */
public class BOJ1005 {

    private static int T;
    private static int N;
    private static int K;
    private static int[] arr;
    private static List<Integer>[] list;
    private static int[] dp;
    private static int num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            dp = new int[N + 1];
            arr = new int[N + 1];
            list = new ArrayList[N + 1];
            for (int j = 1; j < N + 1; j++) {
                list[j] = new ArrayList<>();
            }
            Arrays.fill(dp, -1);
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list[b].add(a);
            }
            num = Integer.parseInt(br.readLine());
            sb.append(find(num)).append("\n");
        }
        System.out.println(sb);
    }

    private static int find(int n) {
        if (dp[n] != -1) {
            return dp[n];
        }
        int max = 0;
        for (int i : list[n]) {
            max = Math.max(max, find(i));
        }
        return dp[n] = max + arr[n];
    }
}
