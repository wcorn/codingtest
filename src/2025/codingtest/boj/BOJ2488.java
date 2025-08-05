package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/2448"> 별 찍기 - 11 </a>
 */
public class BOJ2488 {

    private static int N;
    private static boolean[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arr = new boolean[N][N * 2 - 1];
        recursion(N, 0, N - 1);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2 * N - 1; j++) {
                if (arr[i][j]) {
                    sb.append('*');
                } else {
                    sb.append(' ');
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void recursion(int n, int x, int y) {
        if (n == 3) {
            draw(x, y);
            return;
        }
        int num = n / 2;
        recursion(num, x, y);
        recursion(num, x + num, y - num);
        recursion(num, x + num, y + num);
    }

    private static void draw(int x, int y) {
        arr[x][y] = true;
        arr[x + 1][y - 1] = true;
        arr[x + 1][y + 1] = true;
        arr[x + 2][y - 2] = true;
        arr[x + 2][y - 1] = true;
        arr[x + 2][y] = true;
        arr[x + 2][y + 1] = true;
        arr[x + 2][y + 2] = true;
    }
}
