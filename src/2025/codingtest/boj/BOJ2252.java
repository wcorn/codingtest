package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/2252"> 줄 세우기 </a>
 */
public class BOJ2252 {

    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[] dist = new int[N];
        List<Integer>[] list = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            list[a].add(b);
            dist[b]++;
        }
        Queue<Integer> q = new PriorityQueue<>(Comparator.comparingInt(n -> dist[n]));
        for (int i = 0; i < N; i++) {
            if (dist[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int num = q.poll();
            sb.append(num + 1).append(" ");
            for (int i : list[num]) {
                dist[i]--;
                if (dist[i] == 0) {
                    q.add(i);
                }
            }
        }
        System.out.println(sb);
    }
}
