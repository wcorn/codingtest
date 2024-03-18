package codingtest.dynamicprograming;

import java.io.*;

public class BOJ9252 {
    private static char[] arr1;
    private static char[] arr2;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr1 = br.readLine().toCharArray();
        arr2 = br.readLine().toCharArray();
        dp = new int[arr1.length + 1][arr2.length + 1];
        LCS(arr1.length, arr2.length);
        System.out.println(dp[arr1.length][arr2.length]);
        if (dp[arr1.length - 1][arr2.length - 1] != 0)
            System.out.print(find());
    }

    private static String find() {
        StringBuilder sb = new StringBuilder();
        int x = arr1.length, y = arr2.length;
        while ( x != 0 && y != 0) {
            if (arr1[x-1] == arr2[y-1]) {
                sb.insert(0, arr2[y-1]);
                x--;
                y--;
            } else if (dp[x][y] == dp[x - 1][y]) {
                x--;
            } else if (dp[x][y] == dp[x][y - 1]) {
                y--;
            }
        }
        return sb.toString();
    }

    private static void LCS(int x, int y) {
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                if (arr1[i - 1] == arr2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
    }
}
