package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/1504"> 특정한 최단 경로 </a>
 */
public class BOJ1504 {

    private static int N;
    private static int E;
    private static List<int[]>[] list;
    private static final int INF = 100_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        list = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new int[]{b, c});
            list[b].add(new int[]{a, c});
        }
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()) - 1;
        int b = Integer.parseInt(st.nextToken()) - 1;
        int x1 = dijkstra(0, a);
        int x2 = dijkstra(a, N - 1);
        int y1 = dijkstra(0, b);
        int y2 = dijkstra(b, N - 1);
        int mid = dijkstra(a, b);
        int result = Math.min(x1 + y2, y1 + x2) + mid;
        result = result >= INF ? -1 : result;
        System.out.println(result);
    }

    private static int dijkstra(int a, int b) {
        int[] dist = new int[N];
        Arrays.fill(dist, INF);
        dist[a] = 0;
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x[1]));
        pq.add(new int[]{a, 0});
        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            for (int[] t : list[temp[0]]) {
                if (dist[t[0]] > t[1] + temp[1]) {
                    dist[t[0]] = t[1] + temp[1];
                    pq.add(new int[]{t[0], dist[t[0]]});
                }
            }
        }
        return dist[b];
    }
}
