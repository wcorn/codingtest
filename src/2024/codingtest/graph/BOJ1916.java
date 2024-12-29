package codingtest.graph;

import java.io.*;
import java.util.*;

public class BOJ1916 {
    static int N;
    static int[][] map;
    static boolean[] visited;
    static int[] dist;
    static int start;
    static int end;
    static int inf = 100000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        dist = new int[N];
        map = new int[N][N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(i==j){
                    map[i][j] = 0;
                    continue;
                }
                map[i][j] = inf;
            }
            dist[i] = inf;
        }
        int a;
        int b;
        int weight;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken()) - 1;
            b = Integer.parseInt(st.nextToken()) - 1;
            weight = Integer.parseInt(st.nextToken());
            map[a][b] = Math.min(map[a][b],weight);
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken())-1;
        end = Integer.parseInt(st.nextToken())-1;
        dist[start] = 0;
        solve();
        if(start==end)
            System.out.println(0);
        else
            System.out.println(dist[end]);
    }

    private static void solve() {
        if (N >= 0) System.arraycopy(map[start], 0, dist, 0, N);
        visited[start] = true;
        int current;
        for (int i = 0; i < N - 2; i++) {
            current = getSmallIndex();
            visited[current] = true;
            for (int j = 0; j < N; j++) {
                if (!visited[j]) {
                    if (dist[current] + map[current][j] < dist[j]) {
                        dist[j] = dist[current] + map[current][j];
                    }
                }
            }
        }
    }

    private static int getSmallIndex() {
        int min = inf;
        int index = 0;
        for (int i = 0; i < N; i++) {
            if (dist[i] < min && !visited[i]) {
                min = dist[i];
                index = i;
            }
        }
        return index;
    }
}
