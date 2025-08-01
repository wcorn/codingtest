package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/16928"> 뱀과 사다리 게임 </a>
 */
public class BOJ16928 {

    private static int N;
    private static int M;
    private static int[] dp;
    private static Map<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dp = new int[101];
        map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            map.put(A, B);
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            map.put(A, B);
        }
        Arrays.fill(dp, 1_000_000_000);
        dp[1] = 0;
        dice(1, 0);
        System.out.println(dp[100]);
    }

    private static void dice(int point, int count) {
        dp[point] = count;
        if (map.containsKey(point)) {
            int nextPoint = map.get(point);
            if (dp[nextPoint] > count) {
                dice(nextPoint, count);
            }
            return;
        }
        if (point > 100) {
            return;
        }

        for (int i = 1; i <= 6; i++) {
            int next = point + i;
            if (next > 100) {
                break;
            }
            if (dp[next] > count + 1) {
                dice(next, count + 1);
            }
        }
    }
}
