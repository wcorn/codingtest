package codingtest.search;

import java.io.*;
import java.util.*;

public class BOJ14502 {
    private static int N;
    private static int M;
    private static int[][] map;
    private static int[][] copy;
    private static int result;
    private static List<Point> virus;
    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        copy = new int[N][M];
        virus = new ArrayList<>();
        result = 0;
        int temp;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                temp = Integer.parseInt(st.nextToken());
                map[i][j] = temp;
                if (temp == 2)
                    virus.add(new Point(i, j));
            }
        }
        solve();
        System.out.println(result);
    }

    private static void solve() {
        dfs(0, 0);
    }

    private static void dfs(int start, int depth) {
        if (depth == 3) {
            copyMap();
            for (Point point : virus)
                bfs(point.x, point.y);
            result = Math.max(result, getSafeArea());
            return;
        }
        for (int i = start; i < N * M; i++) {
            int x = i / M;
            int y = i % M;
            if (map[x][y] != 0)
                continue;
            map[x][y] = 1;
            dfs(start + 1, depth + 1);
            map[x][y] = 0;

        }
    }

    static void copyMap() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copy[i][j] = map[i][j];
            }
        }
    }

    private static int getSafeArea() {
        int safe = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copy[i][j] == 0)
                    safe++;
            }
        }
        return safe;
    }

    private static void bfs(int x, int y) {
        if (copy[x][y] == 0) {
            copy[x][y] = 2;
        }
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (0 > nextX || N <= nextX || 0 > nextY || M <= nextY)
                continue;
            if (copy[nextX][nextY] == 1 || copy[nextX][nextY] == 2)
                continue;
            bfs(nextX, nextY);
        }
    }

    private static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
