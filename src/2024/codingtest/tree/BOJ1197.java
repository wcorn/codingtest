package codingtest.tree;

import java.util.*;
import java.io.*;

public class BOJ1197 {
    private static int V;
    private static int E;
    private static int[] root;
    private static List<Edge> edges;
    private static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        root = new int[V];
        edges = new ArrayList<>();
        ans = 0;
        for (int i = 0; i < V; i++) {
            root[i] = i;
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            edges.add(new Edge(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken())));
        }
        solve();
        System.out.println(Arrays.toString(root));
        System.out.println(ans);
    }

    private static void solve() {
        Collections.sort(edges);
        for (Edge edge : edges) {
            if (find(edge.start) != find(edge.end)) {
                ans += edge.cost;
                union(edge.start, edge.end);
            }
        }
    }

    private static int find(int x) {
        if (root[x] == x)
            return x;
        else
            return root[x] = find(root[x]);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x < y) {
            int tmp = x;
            x = y;
            y = tmp;
        }
        root[y] = x;
    }

    private static class Edge implements Comparable<Edge> {
        int start;
        int end;
        int cost;

        public Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return cost - o.cost;
        }
    }
}
