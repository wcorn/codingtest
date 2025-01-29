package codingtest.boj;

import java.io.*;

/**
 * <a href="https://www.acmicpc.net/problem/2239"> 스도쿠 </a>
 */
public class BOJ2239 {

    private static int[][] map;
    private static boolean[][][] check;
    private static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        map = new int[9][9];
        check = new boolean[3][9][10];
        for (int i = 0; i < 9; i++) {
            String temp = br.readLine();
            for (int j = 0; j < 9; j++) {
                map[i][j] = temp.charAt(j) - '0';
                if (map[i][j] != 0) {
                    check[0][i][map[i][j]] = true;
                    check[1][j][map[i][j]] = true;
                    check[2][square(i,j)][map[i][j]] = true;
                }
            }
        }
        flag = false;
        solve(0);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void solve(int depth) {
        if (depth == 81) {
            flag = true;
            return;
        }
        int x = depth / 9;
        int y = depth % 9;
        if (map[x][y] != 0) {
            solve(depth + 1);
            return;
        }
        for (int i = 1; i <= 9; i++) {
            if (check[0][x][i] || check[1][y][i] || check[2][square(x, y)][i]) {
                continue;
            }
            check[0][x][i] = true;
            check[1][y][i] = true;
            check[2][square(x, y)][i] = true;
            map[x][y] = i;
            solve(depth + 1);
            if (flag) {
                return;
            }
            map[x][y] = 0;
            check[0][x][i] = false;
            check[1][y][i] = false;
            check[2][square(x, y)][i] = false;
        }
    }

    private static int square(int x, int y) {
        return x / 3 * 3 + y / 3;
    }
}
