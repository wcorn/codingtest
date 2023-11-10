package codingtest.search;

import java.io.*;
import java.util.*;

public class BOJ15666 {
    private static int N;
    private static int M;
    private static int[] nums;
    private static StringBuilder sb;
    private static int[] sequence;
    private static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N];
        sequence = new int[M];
        isVisited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        solve();
        System.out.println(sb);
    }

    private static void solve() {
        Arrays.sort(nums);
        dfs(0, 0);
    }

    private static void dfs(int start, int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(sequence[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        int before = -1;
        for (int i = start; i < N; i++) {
            if (before == nums[i])
                continue;
            before = nums[i];
            sequence[depth] = nums[i];
            dfs(i, depth + 1);

        }
    }
}
