package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/2206"> 벽 부수고 이동하기 </a>
 */
public class BOJ2206 {

    private static int N;
    private static int M;
    private static int[][] map;
    private static boolean[][][] dp;
    private static int[] dx = new int[]{-1, 1, 0, 0};
    private static int[] dy = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dp = new boolean[N][M][2];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        System.out.println(bfs(0, 0));
    }

    private static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        dp[0][0][0] = true;
        q.add(new int[]{x, y, 1, 0});
        while (!q.isEmpty()) {
            int[] now = q.poll();
            if (now[0] == N - 1 && now[1] == M - 1) {
                return now[2];
            }
            for (int i = 0; i < 4; i++) {
                int nextX = now[0] + dx[i];
                int nextY = now[1] + dy[i];
                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
                    continue;
                }
                if (!dp[nextX][nextY][now[3]] && map[nextX][nextY] == 0) {
                    dp[nextX][nextY][now[3]] = true;
                    q.add(new int[]{nextX, nextY, now[2] + 1, now[3]});
                }
                if (now[3] == 0 && !dp[nextX][nextY][1] && map[nextX][nextY] == 1) {
                    dp[nextX][nextY][1] = true;
                    q.add(new int[]{nextX, nextY, now[2] + 1, 1});
                }
            }
        }
        return -1;
    }
}
