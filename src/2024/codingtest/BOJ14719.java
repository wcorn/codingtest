package codingtest;

import java.io.*;
import java.util.*;

public class BOJ14719 {
    private static int H;
    private static int W;
    private static int[] block;
    private static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        block = new int[W];
        result = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            block[i] = Integer.parseInt(st.nextToken());
        }
        solve();
        System.out.println(result);
    }

    private static void solve() {
        int start;
        int end;
        for (int i = 0; i < H; i++) {
            start = -1;
            end = -1;
            for (int j = 0; j < W; j++) {
                if (block[j] > i) {
                    start = j;
                    break;
                }
            }
            for (int j = W - 1; j >= 0; j--) {
                if (block[j] > i) {
                    end = j;
                    break;
                }
            }
            if (end == start || end == -1 || start == -1) {
                break;
            }
            for (int j = start+1; j <= end-1; j++) {
                if (block[j] <= i) {
                    result++;
                }
            }
        }
    }
}
