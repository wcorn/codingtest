package codingtest.tree;

import java.io.*;
import java.util.*;

public class BOJ1922 {
    private static int N, M;
    private static int[] root;
    private static List<Edge> edges;
    private static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ans = 0;
        StringTokenizer st;
        edges = new ArrayList<>();
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        root = new int[N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            edges.add(new Edge(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())));
        }
        solve();
        System.out.println(ans);
    }

    private static void solve() {
        Collections.sort(edges);
        for (int i = 0; i < N; i++) {
            root[i] = i;
        }
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
        public int compareTo(Edge e) {
            return cost - e.cost;
        }
    }
}
