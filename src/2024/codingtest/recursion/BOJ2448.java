package codingtest.recursion;

import java.io.*;
import java.util.*;

public class BOJ2448 {
    private static int N;
    private static char[][] star;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        // N, N/3 * 5 + N/3 - 1
        star = new char[N][N * 2 - 1];
        for (int i = 0; i < N; i++) {
            Arrays.fill(star[i], ' ');
        }
        //초기 위치, 삼각형의 위 꼭지점 기준, 재귀 기준도 윗 꼭지점
        solve(0, N - 1, N);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N * 2 - 1; j++) {
                sb.append(star[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void solve(int row, int column, int now) {
        //가장 작은 범위일 때 별 찍기
        if (now == 3) {
            star[row][column] = '*';
            star[row + 1][column - 1] = '*';
            star[row + 1][column + 1] = '*';
            star[row + 2][column - 2] = '*';
            star[row + 2][column - 2] = '*';
            star[row + 2][column - 1] = '*';
            star[row + 2][column] = '*';
            star[row + 2][column + 1] = '*';
            star[row + 2][column + 2] = '*';
        } else {
            //범위 나누기
            solve(row + now / 2, column - now / 2, now / 2);
            solve(row, column, now / 2);
            solve(row + now / 2, column + now / 2, now / 2);
        }
    }
}
