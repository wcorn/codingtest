package codingtest.search;

import java.io.*;
import java.util.*;

public class BOJ2206 {
    private static int N;
    private static int M;
    private static int[][] map;
    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {-1, 1, 0, 0};
    private static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s;
        s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        map = new int[N][M];
        visited = new boolean[N][M][2];
        for (int i = 0; i < N; i++) {
            s = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }
        System.out.println(solve());
    }

    private static int solve() {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, 1, false));
        visited[0][0][0] = true;
        Point p;
        int nextX;
        int nextY;
        while (!q.isEmpty()) {
            p = q.poll();
            if (p.x == N - 1 && p.y == M - 1) {
                return p.count;
            }
            for (int i = 0; i < 4; i++) {
                nextX = p.x + dx[i];
                nextY = p.y + dy[i];
                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M)
                    continue;
                if (map[nextX][nextY] == 1) {
                    if (!p.destroyed) {
                        q.add(new Point(nextX, nextY, p.count + 1, true));
                        visited[nextX][nextY][1] = true;
                    }
                } else {
                    if (!p.destroyed && !visited[nextX][nextY][0]) {
                        q.add(new Point(nextX, nextY, p.count + 1, false));
                        visited[nextX][nextY][0] = true;
                    } else if (p.destroyed && !visited[nextX][nextY][1]) {
                        q.add(new Point(nextX, nextY, p.count + 1, true));
                        visited[nextX][nextY][1] = true;
                    }
                }
            }
        }
        return -1;
    }

    private static class Point {
        int x;
        int y;
        int count;
        boolean destroyed;

        public Point(int x, int y, int count, boolean destroyed) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.destroyed = destroyed;
        }
    }
}
