package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/15666"> N과 M (12) </a>
 */
public class BOJ15666 {

    private static int N;
    private static int M;
    private static int[] arr;
    private static int[] dist;
    private static Set<String> s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        dist = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        s = new LinkedHashSet<>();
        recursion(0, 0);
        for (String str : s) {
            sb.append(str).append("\n");
        }
        System.out.println(sb);
    }

    private static void recursion(int depth, int num) {
        if (depth == M) {
            StringBuilder sb = new StringBuilder();
            for (int i : dist) {
                sb.append(i).append(" ");
            }
            s.add(sb.toString());
            return;
        }
        for (int i = num; i < N; i++) {
            dist[depth] = arr[i];
            recursion(depth + 1, i);
        }
    }
}
