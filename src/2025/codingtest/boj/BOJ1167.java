package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/1167"> 트리의 지름 </a>
 */
public class BOJ1167 {

    private static int V;
    private static List<int[]>[] edges;
    private static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        V = Integer.parseInt(br.readLine());
        edges = new ArrayList[V + 1];
        for (int i = 1; i < V + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            edges[n] = new ArrayList<>();
            while (true) {
                int a = Integer.parseInt(st.nextToken());
                if (a == -1) {
                    break;
                }
                int b = Integer.parseInt(st.nextToken());
                edges[n].add(new int[]{a, b});
            }
        }
        int[] a = dijkstra(1);
        int[] b = dijkstra(a[0]);
        System.out.println(b[1]);
    }

    private static int[] dijkstra(int n) {
        int[] dist = new int[V + 1];
        Arrays.fill(dist, INF);
        dist[n] = 0;
        Queue<int[]> pq = new PriorityQueue<>((n1, n2) -> Integer.compare(n1[1], n2[1]));
        pq.add(new int[]{n, 0});
        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            if (dist[temp[0]] == INF) {
                continue;
            }
            for (int[] l : edges[temp[0]]) {
                if (dist[l[0]] > dist[temp[0]] + l[1]) {
                    dist[l[0]] = dist[temp[0]] + l[1];
                    pq.add(new int[]{l[0], dist[l[0]]});
                }
            }
        }
        int index = 1;
        for(int i = 2; i <= V; i++){
            if(dist[index]<dist[i]){
                index = i;
            }
        }
        return new int[]{index,dist[index]};
    }
}
