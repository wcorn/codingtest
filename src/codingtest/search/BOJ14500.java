package codingtest.search;

import java.io.*;
import java.util.*;

public class BOJ14500 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] paper = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(solve(paper, N, M));
    }

    private static int solve(int[][] paper, int N, int M) {
        int result = 0;
        result = Math.max(result, I(paper, N, M));
        result = Math.max(result, LSTO(paper, N, M));
        return result;
    }

    private static int I(int[][] paper, int N, int M) {
        int max = 0;
        int value;
        for (int i = 0; i < N - 3; i++) {
            for (int j = 0; j < M; j++) {
                value = paper[i][j] + paper[i + 1][j] + paper[i + 2][j] + paper[i + 3][j];
                max = Math.max(max, value);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M - 3; j++) {
                value = paper[i][j] + paper[i][j + 1] + paper[i][j + 2] + paper[i][j + 3];
                max = Math.max(max, value);
            }
        }
        return max;
    }

    private static int LSTO(int[][] paper, int N, int M) {
        int max = 0;
        int min;
        int temp;
        int[][][] match = {
                {{0, 0}, {0, 1}},
                {{0, 0}, {1, 0}},
                {{0, 1}, {0, 2}},
                {{1, 1}, {1, 2}},
                {{0, 2}, {1, 2}},
                {{1, 1}, {1, 0}},
                {{0, 0}, {1, 2}},
                {{1, 0}, {0, 2}},
                {{0, 0}, {0, 2}},
                {{1, 0}, {1, 2}}
        };
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < M - 2; j++) {
                temp = paper[i][j] + paper[i][j + 1] + paper[i][j + 2] + paper[i + 1][j] + paper[i + 1][j + 1] + paper[i + 1][j + 2];
                min = Integer.MAX_VALUE;
                for (int[][] ints : match) {
                    min = Math.min(min, paper[i + ints[0][0]][j + ints[0][1]] + paper[i + ints[1][0]][j + ints[1][1]]);
                }
                max = Math.max(max, temp - min);
            }
        }
        for (int i = 0; i < N -2; i++) {
            for (int j = 0; j < M - 1; j++) {
                min = Integer.MAX_VALUE;
                temp = paper[i][j] + paper[i + 1][j] + paper[i + 2][j] + paper[i][j + 1] + paper[i + 1][j + 1] + paper[i + 2][j + 1];
                for (int[][] ints : match) {
                    min = Math.min(min, paper[i + ints[0][1]][j + ints[0][0]] + paper[i + ints[1][1]][j + ints[1][0]]);
                }
                max = Math.max(max, temp - min);
            }
        }
        return max;
    }
}
