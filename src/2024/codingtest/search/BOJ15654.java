package codingtest.search;

import java.util.*;
import java.io.*;

public class BOJ15654 {
    private static int N;
    private static int M;
    private static int[] nums;
    private static int[] sequence;
    static boolean[] visited;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N];
        sequence = new int[M];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        solve();
        System.out.println(sb);
    }

    private static void solve() {
        Arrays.sort(nums);
        dfs(0);
    }

    private static void dfs(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(sequence[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i <N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sequence[depth] = nums[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}
