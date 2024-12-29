package codingtest.search;

import java.io.*;
import java.util.*;

public class BOJ2239 {
    private static int[][] board;
    private static List<Point> list;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        board = new int[9][9];
        list = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            board[i] = Arrays.stream(br.readLine().split("")).mapToInt(a -> Integer.parseInt(a) - 1).toArray();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == -1)
                    list.add(new Point(i, j));
            }
        }
        solve();
        System.out.println(sb);
    }

    private static void solve() {
        backtracking(0);
    }

    private static void backtracking(int num) {
        if(sb.length()!=0)
            return;
        if (num == list.size()) {
            if (sb.length()==0) {
                print();
            }
            return;
        }
        int x = list.get(num).x;
        int y = list.get(num).y;
        for (int i = 0; i < 9; i++) {
            if (isPossible(x, y, i)) {
                board[x][y] = i;
                backtracking(num + 1);
                board[x][y] = -1;
            }
        }
    }

    private static boolean isPossible(int x, int y, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[x][i] == num && i != y)
                return false;
            if (board[i][y] == num && i != x)
                return false;
            int nx = (x) / 3 * 3 + (i) / 3;
            int ny = (y) / 3 * 3 + (i) % 3;
            if (board[nx][ny] == num && !(nx == x && ny == y)) return false;
        }
        return true;
    }

    private static void print() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(board[i][j] + 1);
            }
            sb.append("\n");
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
