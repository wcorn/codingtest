package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/2667"> 단지번호붙이기 </a>
 */
public class BOJ2667 {

    private static int N;
    private static int[][] arr;
    private static boolean[][] visited;
    private static final int[] dx = new int[]{-1, 1, 0, 0};
    private static final int[] dy = new int[]{0, 0, -1, 1};
    private static List<Integer> list;
    private static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N][N];
        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            arr[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] || arr[i][j] == 0) {
                    continue;
                }
                visited[i][j] = true;
                result = 0;
                dfs(i, j);
                list.add(result);
            }
        }
        Collections.sort(list);
        sb.append(list.size()).append("\n");
        for(int i : list){
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int x, int y) {
        result++;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) {
                continue;
            }
            if (arr[x][y] != arr[nextX][nextY] || visited[nextX][nextY] || arr[nextX][nextY] == 0) {
                continue;
            }
            visited[nextX][nextY] = true;
            dfs(nextX, nextY);
        }
    }
}
