package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/15681"> 트리와 커리 </a>
 */
public class BOJ15681 {

    private static int N;
    private static int R;
    private static int Q;
    private static int[] dp;
    private static boolean[] visited;
    private static List<Integer>[] node;
    private static int[] s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        dp = new int[N + 1];
        node = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        s = new int[Q];
        for (int i = 0; i < N + 1; i++) {
            node[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            node[a].add(b);
            node[b].add(a);
        }
        for (int i = 0; i < Q; i++) {
            s[i] = Integer.parseInt(br.readLine());
        }
        dfs(R, 1);
        for (int i : s) {
            sb.append(dp[i]).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int now, int depth) {
        List<Integer> leaf = node[now];
        visited[now] = true;
        for (int i : leaf) {
            if (visited[i]) {
                continue;
            }
            dfs(i, depth + 1);
            dp[now] += dp[i];
        }
        dp[now] += 1;
    }
}
