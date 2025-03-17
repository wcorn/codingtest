package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/14888"> 연산자 끼워넣기 </a>
 */
public class BOJ14888 {

    private static int N;
    private static int[] num;
    private static int[] oper;
    private static int[] dist;
    private static boolean[] visited;
    private static int max;
    private static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        num = new int[N];
        oper = new int[N - 1];
        dist = new int[N - 1];
        visited = new boolean[N - 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        int count = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            int n = Integer.parseInt(st.nextToken());
            for (int j = 0; j < n; j++) {
                oper[count++] = i;
            }
        }
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        dfs(0);
        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(int depth) {
        if (depth == N - 1) {
            int result = calculator();
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }
        for (int i = 0; i < N - 1; i++) {
            if (visited[i]) {
                continue;
            }
            dist[depth] = oper[i];
            visited[i] = true;
            dfs(depth + 1);
            visited[i] = false;
        }
    }

    private static int calculator() {
        int n = num[0];
        for (int i = 0; i < N - 1; i++) {
            if (dist[i] == 0) {
                n += num[i + 1];
            }
            if (dist[i] == 1) {
                n -= num[i + 1];
            }
            if (dist[i] == 2) {
                n *= num[i + 1];
            }
            if (dist[i] == 3) {
                n /= num[i + 1];
            }
        }
        return n;
    }
}
