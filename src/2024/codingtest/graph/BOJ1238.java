package codingtest.graph;

import java.util.*;
import java.io.*;

public class BOJ1238 {
    private static int N;
    private static int M;
    private static int X;
    private static int result;
    private static int[][] map;
    private static int[] dist;
    private static boolean[] visited;
    private static final int INF = 1_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        result = 0;
        map = new int[N + 1][N + 1];
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < N + 1; j++) {
                map[i][j] = INF;
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }
        solve();
        System.out.println(result);
    }

    private static void solve() {
        for (int i = 1; i < N + 1; i++) {
            result = Math.max(result, dijkstra(i, X) + dijkstra(X, i));
        }
    }

    private static int dijkstra(int start, int end) {
        dist = new int[N + 1];
        visited = new boolean[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        int index;
        for (int i = 0; i < N; i++) {
            index = getSmallIndex();
            visited[index] = true;
            for (int j = 1; j < N + 1; j++) {
                if (dist[index] + map[index][j] < dist[j]) {
                    dist[j] = dist[index] + map[index][j];
                }
            }
        }
        return dist[end];
    }

    public static int getSmallIndex() {
        int index = 0;
        for (int i = 1; i < N + 1; i++) {
            if (dist[index] > dist[i] && !visited[i])
                index = i;
        }
        visited[index] = true;
        return index;
    }
}
