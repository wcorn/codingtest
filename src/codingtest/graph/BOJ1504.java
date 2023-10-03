package codingtest.graph;

import java.io.*;
import java.util.*;

public class BOJ1504 {
    static int N;
    static int E;
    static int[] dist;
    static boolean[] visited;
    static int[][] map;
    static int v1, v2;
    static int INF = 800_001;

    // 1 -> v1 -> v2 -> N
    // 1 -> v2 -> v1 -> N
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int a, b, c;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(map[i], INF);
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            map[a][b] = c;
            map[b][a] = c;
        }
        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());
        System.out.println(solve());
    }

    private static int solve() {
        int v1cost = dijkstra(1, v1);
        int v2cost = dijkstra(1, v2);
        int v1Tov2 = dijkstra(v1, v2);
        int v1End = dijkstra(v1, N);
        int v2End = dijkstra(v2, N);
        int first = v1cost + v1Tov2 + v2End;
        int second = v2cost + v1Tov2 + v1End;
        if ((v1cost == -1 || v2End == -1) && (v2cost == -1 || v1End == -1) || v1Tov2 == -1) {
            return -1;
        }
        if (v1cost == -1 || v2End == -1) {
            return second;
        } else if (v2cost == -1 || v1End == -1) {
            return first;
        }
        return Math.min(first, second);
    }

    private static int dijkstra(int start, int end) {
        if(start==end)
            return 0;
        dist = new int[N + 1];
        visited = new boolean[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        int current;
        for (int i = 1; i < N; i++) {
            current = getSmallIndex();
            visited[current] = true;
            for (int j = 1; j <= N; j++) {
                if (!visited[j]) {
                    if (dist[current] + map[current][j] < dist[j]) {
                        dist[j] = dist[current] + map[current][j];
                    }
                }
            }
        }
        System.out.println(Arrays.toString(dist));
        System.out.println(Arrays.toString(visited));
        return dist[end] < INF ? dist[end] : -1;
    }

    private static int getSmallIndex() {
        int min = INF;
        int index = 1;
        for (int i = 1; i <= N; i++) {
            if (dist[i] < min && !visited[i]) {
                min = dist[i];
                index = i;
            }
        }
        return index;
    }
}
