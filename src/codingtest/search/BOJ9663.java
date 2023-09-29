package codingtest.search;

import java.io.*;

public class BOJ9663 {
    static int N;
    static int[] board;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N];
        System.out.println(solve());
    }

    private static int solve() {
        nQueen(0);
        return result;
    }

    private static void nQueen(int row) {
        if (row == N) {
            result++;
            return;
        }
        for (int i = 0; i < N; i++) {
            if (possible(row, i)) {
                board[row] = i;
                nQueen(row + 1);
            }
        }
    }

    private static boolean possible(int row, int column) {
        for (int i = 0; i < row; i++) {
          if(board[i]==column)
              return false;
          if(Math.abs(i-row)==Math.abs(board[i]-column))
              return false;
        }
        return true;
    }
}
