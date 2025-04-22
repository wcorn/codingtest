package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/2178"> 미로 탐색</a>
 */
public class BOJ2178 {

    private static int N;
    private static int M;
    private static int[][] map;
    private static boolean[][] visited;
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().chars().map(x -> x - '0').toArray();
        }
        Queue<int[]> q = new LinkedList<>();
        visited[0][0] = true;
        q.add(new int[]{0, 0, 1});
        int answer = 0;
        l1:
        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = now[0] + dx[i];
                int nextY = now[1] + dy[i];
                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
                    continue;
                }
                if (map[nextX][nextY] == 0 || visited[nextX][nextY]) {
                    continue;
                }
                if (nextX == N - 1 && nextY == M - 1) {
                    answer = now[2] + 1;
                    break l1;
                }
                visited[nextX][nextY] = true;
                q.add(new int[]{nextX, nextY, now[2] + 1});
            }
        }
        System.out.println(answer);
    }

}
