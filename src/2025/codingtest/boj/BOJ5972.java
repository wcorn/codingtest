package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/5972"> 택배 배송 </a>
 */
public class BOJ5972 {

    private static int N;
    private static int M;
    private static List<Edge>[] edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        edges = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            edges[A].add(new Edge(B, C));
            edges[B].add(new Edge(A, C));
        }
        System.out.println(mst());
    }

    private static int mst() {
        int answer = 0;
        boolean[] visited = new boolean[N + 1];
        int[] dist = new int[N + 1];
        Arrays.fill(dist, 100_000_000);
        dist[1] = 0;
        Queue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(n -> n[1]));
        q.add(new int[]{1, 0});
        while (!q.isEmpty()) {
            int[] now = q.poll();
            if (visited[now[0]]) {
                continue;
            }
            visited[now[0]] = true;
            for (Edge e : edges[now[0]]) {
                if (e.value + now[1] < dist[e.num]) {
                    dist[e.num] = e.value + now[1];
                    q.add(new int[]{e.num, dist[e.num]});
                }
            }
        }
        System.out.println(Arrays.toString(dist));
        return dist[N];
    }

    private static class Edge {

        int num;
        int value;

        public Edge(int num, int value) {
            this.num = num;
            this.value = value;
        }
    }
}
