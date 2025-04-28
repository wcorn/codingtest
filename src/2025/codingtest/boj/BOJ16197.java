package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/16197"> 두 동전 </a>
 */
public class BOJ16197 {

    private static int N;
    private static int M;
    private static char[][] arr;
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        int x1 = -1;
        int y1 = -1;
        int x2 = -1;
        int y2 = -1;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                arr[i][j] = str.charAt(j);
                if (x1 == -1 && arr[i][j] == 'o') {
                    x1 = i;
                    y1 = j;
                } else if (arr[i][j] == 'o') {
                    x2 = i;
                    y2 = j;
                }
            }
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x1, y1, x2, y2, 0});
        int result = -1;
        t:
        while (!q.isEmpty()) {
            int[] now = q.poll();
            if (now[4] + 1 > 10) {
                continue;
            }
            for (int j = 0; j < 4; j++) {
                int nextX1 = now[0] + dx[j];
                int nextY1 = now[1] + dy[j];
                int nextX2 = now[2] + dx[j];
                int nextY2 = now[3] + dy[j];
                if ((nextX1 < 0 || nextY1 < 0 || nextX1 >= N || nextY1 >= M) &&
                    (nextX2 < 0 || nextY2 < 0 || nextX2 >= N || nextY2 >= M)) {
                    continue;
                }
                if (nextX1 < 0 || nextY1 < 0 || nextX1 >= N || nextY1 >= M ||
                    nextX2 < 0 || nextY2 < 0 || nextX2 >= N || nextY2 >= M) {
                    result = now[4] + 1;
                    break t;
                }
                if (arr[nextX1][nextY1] == '#' && arr[nextX2][nextY2] == '#') {
                    continue;
                }
                if (arr[nextX1][nextY1] == '#' || arr[nextX2][nextY2] == '#') {
                    if (arr[nextX1][nextY1] == '#') {
                        nextX1 = now[0];
                        nextY1 = now[1];
                    }
                    if (arr[nextX2][nextY2] == '#') {
                        nextX2 = now[2];
                        nextY2 = now[3];
                    }
                }
                if (nextX1 == nextX2 && nextY1 == nextY2) {
                    continue;
                }
                q.add(new int[]{nextX1, nextY1, nextX2, nextY2, now[4] + 1});
            }

        }
        System.out.println(result);
    }
}
