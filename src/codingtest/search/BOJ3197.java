package codingtest.search;

import java.io.*;
import java.util.*;

public class BOJ3197 {

    private static int R, C;
    private static boolean[][] lake;
    private static Queue<Point> wq, sq;
    private static int date;
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    private static boolean[][] check;
    private static Point swan;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        lake = new boolean[R][C];
        check = new boolean[R][C];
        wq = new LinkedList<>();
        sq = new LinkedList<>();
        date = 0;
        char[] ch;
        for (int i = 0; i < R; i++) {
            ch = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if (ch[j] == 'L') {
                    sq.add(new Point(i, j));
                    wq.add(new Point(i, j));
                    check[i][j] = true;
                    lake[i][j] = true;
                }
                if (ch[j] == '.') {
                    wq.add(new Point(i, j));
                    lake[i][j] = true;
                }
            }
        }
        swan = sq.poll();
        check[swan.x][swan.y] = false;
        solve();
        System.out.println(date);

    }

    private static void solve() {
        while (!move()) {
            melting();
            date++;
        }
    }

    private static boolean move() {
        Queue<Point> q = new LinkedList<>();
        Point point;
        int nextX, nextY;
        while (!sq.isEmpty()) {
            point = sq.poll();
            if (point.x == swan.x && point.y == swan.y) {
                return true;
            }
            for (int i = 0; i < 4; i++) {
                nextX = point.x + dx[i];
                nextY = point.y + dy[i];
                if (nextX < 0 || nextY < 0 || nextX >= R || nextY >= C || check[nextX][nextY]) {
                    continue;
                }
                check[nextX][nextY] = true;
                if (lake[nextX][nextY]) {
                    sq.add(new Point(nextX, nextY));
                } else {
                    q.add(new Point(nextX, nextY));
                }
            }
        }
        sq = q;
        return false;
    }

    private static void melting() {
        int size = wq.size();
        Point p;
        int nextX, nextY;
        for (int i = 0; i < size; i++) {
            p = wq.poll();
            for (int j = 0; j < 4; j++) {
                nextX = p.x + dx[j];
                nextY = p.y + dy[j];
                if (nextX < 0 || nextY < 0 || nextX >= R || nextY >= C || lake[nextX][nextY]) {
                    continue;
                }
                lake[nextX][nextY] = true;
                wq.add(new Point(nextX, nextY));
            }
        }
    }

    private static class Point {

        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}