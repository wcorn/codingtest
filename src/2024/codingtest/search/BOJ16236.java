package codingtest.search;

import java.io.*;
import java.util.*;

public class BOJ16236 {
    private static int[][] map;
    private static boolean[][] visited;
    private static int N;
    private static final int[] dy = {0, -1, 0, 1};
    private static final int[] dx = {-1, 0, 1, 0};
    private static Shark shark;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    shark = new Shark(i, j);
                    map[i][j] = 0;
                }
            }
        }
        solve();
        System.out.println(shark.move);
    }

    private static void solve() {
        do {
            visited = new boolean[N][N];
        } while (findFish(shark.x, shark.y));
    }

    private static boolean findFish(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        Point out = new Point(0, 0, Integer.MAX_VALUE);
        q.add(new Point(x, y, 0));
        Point temp;
        int nextX;
        int nextY;
        boolean result = false;
        while (!q.isEmpty()) {
            temp = q.poll();
            if (map[temp.x][temp.y] < shark.size && map[temp.x][temp.y] >= 1) {
                if (out.move == temp.move) {
                    if (out.x > temp.x) {
                        out.x = temp.x;
                        out.y = temp.y;
                    }
                    if (out.x == temp.x && out.y > temp.y) {
                        out.y = temp.y;
                    }
                } else if (out.move > temp.move) {
                    out.x = temp.x;
                    out.y = temp.y;
                    out.move = temp.move;
                }
                result = true;
            }
            for (int i = 0; i < 4; i++) {
                nextX = temp.x + dx[i];
                nextY = temp.y + dy[i];
                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N)
                    continue;
                if (visited[nextX][nextY] || map[nextX][nextY] > shark.size)
                    continue;
                q.add(new Point(nextX, nextY, temp.move + 1));
                visited[nextX][nextY] = true;
            }
        }
        if (result) {
            shark.eat(out.x, out.y, out.move);
        }
        return result;
    }

    private static class Point {
        int x;
        int y;
        int move;

        public Point(int x, int y, int move) {
            this.x = x;
            this.y = y;
            this.move = move;
        }
    }

    private static class Shark {
        int x;
        int y;
        int eaten;
        int size;
        int move;

        public Shark(int x, int y) {
            this.x = x;
            this.y = y;
            eaten = 0;
            size = 2;
            move = 0;
        }

        public void eat(int x, int y, int move) {
            this.x = x;
            this.y = y;
            map[x][y] = 0;
            eaten++;
            this.move += move;
            if (eaten == size) {
                size++;
                eaten = 0;
            }
        }
    }
}
