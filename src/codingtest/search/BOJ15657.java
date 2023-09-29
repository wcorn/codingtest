package codingtest.search;

import java.io.*;
import java.util.*;

public class BOJ15657 {
    static int N;
    static int M;
    static int[] nums;
    private static int[] sequence;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N];
        sequence = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        solve(0,0);
        System.out.println(sb);
    }

    private static void solve(int now, int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(sequence[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = now; i < N; i++) {
            sequence[depth] = nums[i];
            solve(i,depth + 1);
        }
    }
}
