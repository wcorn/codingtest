package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/1743"> 음식물 피하기 </a>
 */
public class BOJ1743 {

    private static int N;
    private static int M;
    private static int K;
    private static boolean[][] map;
    private static boolean[][] visited;
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    private static int size;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        answer = 0;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new boolean[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = true;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j] || !map[i][j]) {
                    continue;
                }
                visited[i][j] = true;
                size = 1;
                find(i, j);
                answer = Math.max(answer, size);
            }
        }
        System.out.println(answer);
    }

    private static void find(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
                continue;
            }
            if (visited[nextX][nextY] || !map[nextX][nextY]) {
                continue;
            }
            visited[nextX][nextY] = true;
            size++;
            find(nextX, nextY);
        }
    }
}
