package codingtest.search;

import java.util.*;
import java.io.*;

public class BOJ21736 {
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] board = new char[N][M];
        int x = 0, y = 0;
        String s;
        for (int i = 0; i < N; i++) {
            s = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = s.charAt(j);
                if (board[i][j] == 'I') {
                    x = i;
                    y = j;
                }
            }
        }
        System.out.println(solve(board, x, y));
    }

    private static String solve(char[][] board, int x, int y) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        bfs(x, y, board, visited);
        if (result == 0)
            return "TT";
        else
            return String.valueOf(result);
    }
    private static void bfs(int x, int y, char[][] board, boolean[][] visited) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int nextX;
        int nextY;
        visited[x][y] = true;
        if (board[x][y] == 'P') {
            result++;
        }
        for (int i = 0; i < 4; i++) {
            nextX = x + dx[i];
            nextY = y + dy[i];
            if (nextX < 0 || nextX >= board.length || nextY < 0 || nextY >= board[0].length)
                continue;
            if (visited[nextX][nextY] || board[nextX][nextY] == 'X')
                continue;
            bfs(nextX, nextY, board, visited);
        }
    }
}