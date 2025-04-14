package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/1260"> DFS와 BFS </a>
 */
public class BOJ1206 {

    private static int N;
    private static int M;
    private static int V;
    private static Edge[] edges;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        edges = new Edge[N + 1];
        for (int i = 0; i < N + 1; i++) {
            edges[i] = new Edge(i);
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edges[a].next.add(b);
            edges[b].next.add(a);
        }
        for (int i = 0; i < N + 1; i++) {
            Collections.sort(edges[i].next);
        }
        dfs(V, new boolean[N + 1]);
        sb.append("\n");
        bfs(V);
        System.out.println(sb);
    }

    private static void dfs(int num, boolean[] visited) {
        if (visited[num]) {
            return;
        }
        sb.append(num).append(" ");
        visited[num] = true;
        for (int i : edges[num].next) {
            dfs(i, visited);
        }
    }

    private static void bfs(int num) {
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(num);
        while (!q.isEmpty()) {
            int n = q.poll();
            if (visited[n]) {
                continue;
            }
            sb.append(n).append(" ");
            visited[n] = true;
            for (int i : edges[n].next) {
                q.add(i);
            }
        }
    }

    private static class Edge {

        int num;
        List<Integer> next;

        public Edge(int num) {
            this.num = num;
            this.next = new ArrayList<>();
        }
    }
}
