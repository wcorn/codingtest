package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/16236"> 아기 상어 </a>
 */
public class BOJ16236 {

    private static int N;
    private static int[][] map;
    private static int answer;
    private static int size;
    private static int eat;
    private static int[] dx = new int[]{-1, 0, 0, 1};
    private static int[] dy = new int[]{0, -1, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        answer = 0;
        size = 2;
        eat = 0;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        int x = 0;
        int y = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    x = i;
                    y = j;
                    map[i][j] = 0;
                }
            }
        }
        while (true) {
            int[] now = bfs(x, y);
            if (now[2] == 0) {
                break;
            }
            answer += now[2];
            x = now[0];
            y = now[1];
            map[x][y] = 0;
            if (eat == size) {
                eat = 0;
                size++;
            }
        }
        System.out.println(answer);
    }

    private static int[] bfs(int x, int y) {
        boolean[][] visited = new boolean[N][N];
        int[] point = new int[]{x, y, 0};
        List<int[]> fishes = new ArrayList<>();
        visited[x][y] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(point);
        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = now[0] + dx[i];
                int nextY = now[1] + dy[i];
                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) {
                    continue;
                }
                if (visited[nextX][nextY] || map[nextX][nextY] > size) {
                    continue;
                }
                visited[nextX][nextY] = true;
                q.add(new int[]{nextX, nextY, now[2] + 1});

                if (map[nextX][nextY] > 0 && map[nextX][nextY] < size) {
                    fishes.add(new int[]{nextX, nextY, now[2] + 1});
                }
            }
        }
        if (fishes.isEmpty()) {
            return new int[]{x, y, 0};
        }
        fishes.sort((a, b) -> {
            if (a[2] == b[2]) {
                if (a[0] == b[0]) {
                    return Integer.compare(a[1], b[1]);
                }
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[2], b[2]);
        });
        eat++;
        return fishes.get(0);
    }
}
