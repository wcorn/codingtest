package codingtest.graph;

import java.io.*;
import java.util.*;

public class BOJ2887 {
    private static int N;
    private static List<Planet> list;
    private static List<Node> list2;
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int total = 0;
        list = new ArrayList<>();
        list2 = new ArrayList<>();
        N = Integer.parseInt(br.readLine());
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Planet(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        list.sort(Comparator.comparingInt(o -> o.x));
        for (int i = 0; i < N - 1; i++) {
            list2.add(new Node(list.get(i).num, list.get(i + 1).num, Math.abs(list.get(i).x - list.get(i + 1).x)));
        }
        list.sort(Comparator.comparingInt(o -> o.y));
        for (int i = 0; i < N - 1; i++) {
            list2.add(new Node(list.get(i).num, list.get(i + 1).num, Math.abs(list.get(i).y - list.get(i + 1).y)));
        }
        list.sort(Comparator.comparingInt(o -> o.z));
        for (int i = 0; i < N - 1; i++) {
            list2.add(new Node(list.get(i).num, list.get(i + 1).num, Math.abs(list.get(i).z - list.get(i + 1).z)));
        }
        Collections.sort(list2);
        for (Node node : list2) {
            if (find(node.start) != find(node.end)) {
                total += node.value;
                union(node.start, node.end);
            }
        }
        System.out.println(total);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x < y) {
            int tmp = x;
            x = y;
            y = tmp;
        }
        parent[y] = x;
    }

    public static int find(int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }

    private static class Planet {
        int num;
        int x;
        int y;
        int z;

        public Planet(int num, int x, int y, int z) {
            this.num = num;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    private static class Node implements Comparable<Node> {
        int start;
        int end;
        int value;

        public Node(int start, int end, int value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }
}
