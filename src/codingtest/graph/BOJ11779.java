package codingtest.graph;

import java.io.*;
import java.util.*;

public class BOJ11779 {
    private static int n;
    private static int m;
    private static int start;
    private static int end;
    private static List<List<Integer>> list;
    private static int[] dist;
    private static boolean[] visited;
    private static final int INF = 100_000_000;
    private static int[][] map;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        list = new ArrayList<>();
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        map = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
            for (int j = 0; j <= n; j++) {
                map[i][j] = INF;
            }
        }
        int a, b, c;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            map[a][b] = Math.min(map[a][b], c);
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        dist = new int[n + 1];
        visited = new boolean[n + 1];
        solve();
        sb.append(dist[end]).append("\n");
        sb.append(list.get(end).size()).append("\n");
        for (int k = list.get(end).size() - 1; k >= 0; k--) {
            sb.append(list.get(end).get(k)).append(" ");
        }
        System.out.println(sb);
    }

    private static void solve() {
        Arrays.fill(dist, INF);
        dist[start] = 0;
        list.get(start).add(start);
        int index;
        for (int i = 0; i < n; i++) {
            index = minCost();
            visited[index] = true;
            for (int j = 0; j < n + 1; j++) {
                if (dist[index] + map[index][j] < dist[j]) {
                    dist[j] = dist[index] + map[index][j];
                    list.set(j, new ArrayList<>());
                    list.get(j).add(j);
                    list.get(j).addAll(list.get(index));
                }
            }
        }
    }

    private static int minCost() {
        int index = 0;
        for (int i = 1; i < n + 1; i++) {
            if (dist[index] > dist[i] && !visited[i])
                index = i;
        }
        visited[index] = true;
        return index;
    }
}