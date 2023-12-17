package codingtest.tree;

import java.io.*;
import java.util.*;

public class BOJ1967 {
    private static int n;
    private static List<List<Edge>> nodeList = new ArrayList<>();
    private static boolean[] visited;
    private static int maxNode;
    private static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i <= n; i++) {
            nodeList.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            nodeList.get(left).add(new Edge(right, value));
            nodeList.get(right).add(new Edge(left, value));
        }
        solve();
        System.out.println(max);
    }

    private static void solve() {
        visited = new boolean[n + 1];
        dfs(1, 0);
        visited = new boolean[n + 1];
        dfs(maxNode, 0);
    }

    private static void dfs(int node, int distance) {
        List<Edge> edgeList = nodeList.get(node);
        Edge e;
        visited[node] = true;
        if (distance > max) {
            max = distance;
            maxNode = node;
        }
        for (int i = 0; i < edgeList.size(); i++) {
            e = edgeList.get(i);
            if (visited[e.nextNodeNum])
                continue;
            dfs(e.nextNodeNum, e.distance + distance);
        }
    }

    private static class Edge {
        int nextNodeNum;
        int distance;

        public Edge(int nextNodeNum, int distance) {
            this.nextNodeNum = nextNodeNum;
            this.distance = distance;
        }
    }
}
