package codingtest.recursion;

import java.io.*;

public class BOJ11729 {
    private static int N;
    private static int cnt;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        cnt = 0;
        solve();
        System.out.println(cnt);
        System.out.println(sb);
    }

    private static void solve() {
        hanoiTop(N,1,2,3);
    }

    private static void hanoiTop(int n, int start, int mid, int end) {
        if (n == 1) {
            sb.append(start).append(" ").append(end).append("\n");
            cnt++;
            return;
        }
        hanoiTop(n - 1, start, end, mid);
        cnt++;
        sb.append(start).append(" ").append(end).append("\n");
        hanoiTop(n - 1, mid, start, end);
    }
}