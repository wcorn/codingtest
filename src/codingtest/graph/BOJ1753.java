package codingtest.graph;

import java.io.*;
import java.util.*;

public class BOJ1753 {
    private static int V;
    private static int E;
    private static int K;
    private static List<List<Node>> map;
    private static boolean[] visited;
    private static int[] dist;
    private static final int INF = 200_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        map = new ArrayList<>();
        dist = new int[V + 1];
        visited = new boolean[V + 1];
        for (int i = 0; i < V + 1; i++) {
            map.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            map.get(Integer.parseInt(st.nextToken())).add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        solve();
        for (int i = 1; i < V + 1; i++) {
            if (dist[i] == INF)
                sb.append("INF").append("\n");
            else
                sb.append(dist[i]).append("\n");
        }
        System.out.print(sb);
    }

    private static void solve() {
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(K, 0));
        Arrays.fill(dist,INF);
        dist[K] = 0;
        Node current;
        List<Node> next;
        while (!q.isEmpty()) {
            current = q.poll();
            if (visited[current.end])
                continue;
            visited[current.end] = true;
            next = map.get(current.end);
            for (Node node : next) {
                if (dist[node.end] > dist[current.end] + node.weight) {
                    dist[node.end] = dist[current.end] + node.weight;
                    q.add(new Node(node.end, dist[node.end]));
                }
            }
        }
    }


    private static class Node implements Comparable<Node> {
        int end;
        int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node node) {
            return weight - node.weight;
        }
    }
}
