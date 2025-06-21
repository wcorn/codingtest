package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/1916"> 최소비용 구하기 </a>
 */
public class BOJ1916 {

    private static int N;
    private static int M;
    private static List<int[]>[] list;
    private static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        list = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            list[Integer.parseInt(st.nextToken()) - 1].add(
                new int[]{Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken())});
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()) - 1;
        int end = Integer.parseInt(st.nextToken()) - 1;
        System.out.println(dijkstra(start, end));
    }

    private static int dijkstra(int start, int end) {
        int[] dist = new int[N];
        boolean[] visited = new boolean[N];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n[1]));
        pq.add(new int[]{start, 0});
        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            if (visited[temp[0]]) {
                continue;
            }
            visited[temp[0]] = true;
            for (int[] i : list[temp[0]]) {
                if (dist[i[0]] > temp[1] + i[1]) {
                    dist[i[0]] = temp[1] + i[1];
                    pq.add(new int[]{i[0], dist[i[0]]});
                }
            }
        }
        return dist[end];
    }
}
