package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/15652"> N과 M (4) </a>
 */
public class BOJ15652 {

    private static StringBuilder sb = new StringBuilder();
    private static int N;
    private static int M;
    private static int[] dp;
    private static Set<String> s;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dp = new int[M];
        s = new LinkedHashSet<>();
        dfs(0, 1);
        for(String s : s){
            sb.append(s).append('\n');
        }
        System.out.println(sb.toString());
    }

    private static void dfs(int depth, int now) {
        if (depth == M) {
            StringBuilder t = new StringBuilder();
            for(int i : dp){
                t.append(i).append(' ');
            }
            s.add(t.toString());
            return;
        }
        for (int i = now; i <= N; i++) {
            dp[depth] = i;
            dfs(depth+1,i);
        }
    }
}
