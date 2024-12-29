package codingtest.tree;

import java.io.*;
import java.util.*;

public class BOJ1647 {
    private static int N;
    private static int M;
    private static List<Edge> edges;
    private static int[] root;
    private static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        edges = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        root = new int[N];
        ans = 0;
        for(int i=0;i<N;i++){
            root[i] = i;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            edges.add(new Edge(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())));
        }
        solve();
        System.out.print(ans);
    }

    private static void solve() {
        int max = 0;
        Collections.sort(edges);
        for (Edge edge : edges) {
            if (find(edge.start) != find(edge.end)) {
                ans += edge.cost;
                max = Math.max(max, edge.cost);
                union(edge.start, edge.end);
            }
        }
        ans -= max;
    }

    private static int find(int x) {
        if (root[x] == x)
            return x;
        return root[x] = find(root[x]);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x < y) {
            int temp = x;
            x = y;
            y = temp;
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
            return this.cost - e.cost;
        }
    }
}
