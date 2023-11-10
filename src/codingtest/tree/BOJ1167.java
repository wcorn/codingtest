package codingtest.tree;

import java.io.*;
import java.util.*;

public class BOJ1167 {
    private static int V;
    private static List<List<Edge>> nodeList;
    private static boolean[] visited;
    private static int maxNode;
    private static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        nodeList = new ArrayList<>();
        max = 0;
        V = Integer.parseInt(br.readLine());
        for (int i = 0; i <= V; i++) {
            nodeList.add(new ArrayList<>());
        }
        int num;
        List<Edge> temp;
        int nodeNum;
        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            num = Integer.parseInt(st.nextToken());
            temp = nodeList.get(num);
            while (true) {
                nodeNum = Integer.parseInt(st.nextToken());
                if (nodeNum == -1) break;
                temp.add(new Edge(nodeNum, Integer.parseInt(st.nextToken())));
            }
        }
        solve();
        System.out.println(max);
    }

    private static void solve() {
        visited = new boolean[V + 1];
        dfs(1, 0);
        visited = new boolean[V + 1];
        dfs(maxNode, 0);
    }

    private static void dfs(int node, int distance) {
        List<Edge> edges = nodeList.get(node);
        Edge e;
        visited[node] = true;
        if (distance > max) {
            max = distance;
            maxNode = node;
        }
        for (Edge edge : edges) {
            e = edge;
            if (visited[e.nodeNum])
                continue;
            dfs(e.nodeNum, e.distance + distance);
        }
    }

    private static class Edge {
        int nodeNum;
        int distance;

        public Edge(int nodeNum, int distance) {
            this.nodeNum = nodeNum;
            this.distance = distance;
        }
    }
}
