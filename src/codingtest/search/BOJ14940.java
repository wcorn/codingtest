package codingtest.search;

import java.io.*;
import java.util.*;

public class BOJ14940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int temp;
        int[][] board = new int[n][m];
        Point point = null;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                temp = Integer.parseInt(st.nextToken());
                board[i][j] = temp;
                if (temp == 2)
                    point = new Point(i, j);

            }
        }
        int[][] result = solve(n, m, board, point);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static int[][] solve(int n, int m, int[][] board, Point firstPoint) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int[][] result = new int[n][m];
        boolean[][] visited = new boolean[board.length][board[0].length];
        Queue<Point> q = new LinkedList<>();
        q.add(firstPoint);
        visited[firstPoint.x][firstPoint.y] = true;
        Point point;
        int nextX;
        int nextY;
        while (!q.isEmpty()) {
            point = q.poll();
            for (int j = 0; j < 4; j++) {
                nextX = point.x + dx[j];
                nextY = point.y + dy[j];
                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m)
                    continue;
                if (visited[nextX][nextY] || board[nextX][nextY] == 0)
                    continue;
                q.add(new Point(nextX, nextY));
                visited[nextX][nextY] = true;
                result[nextX][nextY] = result[point.x][point.y] + 1;
            }
        }

        for (int j = 0; j < n; j++) {
            for (int k = 0; k < m; k++) {
                if (!visited[j][k] && board[j][k] != 0) {
                    result[j][k] = -1;
                }
            }
        }
        return result;
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
