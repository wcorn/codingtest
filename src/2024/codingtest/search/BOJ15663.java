package codingtest.search;

import java.io.*;
import java.util.*;

public class BOJ15663 {
    private static int N;
    private static int M;
    private static int[] nums;
    private static StringBuilder sb;
    private static int[] sequence;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N];
        sequence = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        solve(0);
        System.out.println(sb);
    }

    private static void solve(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(sequence[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        int before = 0;
        for (int i = 0; i < N; i++) {
            if (visited[i])
                continue;
            if (before == nums[i])
                continue;
            visited[i] = true;
            sequence[depth] = nums[i];
            before = nums[i];
            solve(depth + 1);
            visited[i] = false;
        }
    }
}
