package codingtest.search;

import java.util.*;
import java.io.*;

public class BOJ15650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        System.out.println(solve(N, M));
    }

    private static String solve(int N, int M) {
        StringBuilder sb = new StringBuilder();
        int[] sequence = new int[M];
        dfs(1, 0, N, M, sb, sequence);
        return sb.toString();
    }

    private static void dfs(int now, int depth, int N, int M, StringBuilder sb, int[] sequence) {
        if (depth == M) {
            for (int i : sequence) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = now; i <= N; i++) {
            sequence[depth] = i;
            dfs(i + 1, depth + 1, N, M, sb, sequence);
        }
    }
}
