package codingtest.exam;


import java.util.*;

class Edge implements Comparable<Edge> {
    int from;
    int to;
    int cost;

    public Edge(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge other) {
        return this.cost - other.cost;
    }
}

public class SWEA17675 {
    static int[] parent;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();

        for (int t = 1; t <= testCase; t++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            parent = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
            }

            List<Edge> edges = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                int c = scanner.nextInt();

                edges.add(new Edge(x, y, c));
            }

            int minCost = getMinimumCost(edges, n);

            System.out.println("#" + t + " " + (minCost == Integer.MAX_VALUE ? -1 : minCost));
        }

        scanner.close();
    }

    private static int getMinimumCost(List<Edge> edges, int n) {
        int minCost = Integer.MAX_VALUE;

        for (int i = 0; i < edges.size(); i++) {
            int totalCost = 0;
            int count = 0;
            Collections.sort(edges);

            for (Edge edge : edges) {
                int fromRoot = find(edge.from);
                int toRoot = find(edge.to);

                if (fromRoot != toRoot) {
                    union(fromRoot, toRoot);
                    totalCost += edge.cost;
                    count++;
                }

                if (count == n - 1) {
                    break;
                }
            }

            if (count == n - 1) {
                minCost = Math.min(minCost, totalCost);
            }

            for (int j = 1; j <= n; j++) {
                parent[j] = j;
            }
        }

        return minCost;
    }

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            parent[rootB] = rootA;
        }
    }
}