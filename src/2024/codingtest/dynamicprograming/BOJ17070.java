package codingtest.dynamicprograming;

import java.io.*;
import java.util.stream.Stream;

public class BOJ17070 {
    private static int N;
    private static int[][] house;
    private static int[][][] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        house = new int[N][N];
        result = new int[N][N][3];
        for (int i = 0; i < N; i++) {
            house[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        System.out.println(solve());
    }

    private static int solve() {
        result[0][1][0] = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 2; j < N; j++) {
                if (j - 1 >= 0 && house[i][j] == 0) {
                    result[i][j][0] = result[i][j-1][0] + result[i][j-1][2];
                }
                if (i - 1 >= 0 && house[i][j] == 0) {
                    result[i][j][1] = result[i-1][j][1] + result[i-1][j][2];
                }
                if (i - 1 >= 0 && j - 1 >= 0 && house[i - 1][j] == 0 && house[i][j] == 0 && house[i][j - 1] == 0) {
                    result[i][j][2] = result[i - 1][j - 1][0] + result[i - 1][j - 1][1] + result[i - 1][j - 1][2];
                }
            }
        }
        return result[N - 1][N - 1][0] + result[N - 1][N - 1][1] + result[N - 1][N - 1][2];
    }
}