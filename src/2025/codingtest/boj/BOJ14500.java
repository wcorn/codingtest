package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/14500"> 테트로미노 </a>
 */
public class BOJ14500 {

    private static int N;
    private static int M;
    private static int[][] arr;
    private static boolean[][] visited;
    private static int result;
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                find(i, j, 0, arr[i][j]);
                visited[i][j] = false;
            }
        }
        System.out.println(result);
    }

    private static void find(int x, int y, int depth, int score) {
        if (depth == 3) {
            result = Math.max(result, score);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
                continue;
            }
            if (visited[nextX][nextY]) {
                continue;
            }
            if (depth == 1) {
                int j = (i + 1) % 4;
                int nextX2 = x + dx[j];
                int nextY2 = y + dy[j];
                if ((nextX2 >= 0 && nextY2 >= 0 && nextX2 < N && nextY2 < M)
                    && !visited[nextX2][nextY2]) {
                    find(nextX, nextY, depth + 2, score + arr[nextX][nextY] + arr[nextX2][nextY2]);
                }
            }
            visited[nextX][nextY] = true;
            find(nextX, nextY, depth + 1, score + arr[nextX][nextY]);
            visited[nextX][nextY] = false;
        }
    }
}
