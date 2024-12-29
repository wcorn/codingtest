package codingtest.search;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class BOJ1520 {
    private static int M;
    private static int N;
    private static int[][] map;
    private static int[][] H;
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        H = new int[M][N];
        for (int i = 0; i < M; i++) {
            map[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.fill(H[i], -1);
        }
        System.out.println(dfs(0,0));
    }

    private static int dfs(int x, int y) {
        if (x == M - 1 && y == N - 1) return 1;
        if (H[x][y] != -1)
            return H[x][y];
        H[x][y] = 0;
        int nextX;
        int nextY;
        for (int i = 0; i < 4; i++) {
            nextX = x + dx[i];
            nextY = y + dy[i];
            if (nextX < 0 || nextY < 0 || nextX >= M || nextY >= N)
                continue;
            if (map[nextX][nextY] >= map[x][y])
                continue;
            H[x][y] = H[x][y] + dfs(nextX, nextY);
        }
        return H[x][y];
    }
}
