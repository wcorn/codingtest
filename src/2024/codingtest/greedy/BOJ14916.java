package codingtest.greedy;

import java.io.*;

public class BOJ14916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int ans = -1;
        for (int i = n / 5; i >= 0; i--) {
            if ((n - i * 5) % 2 == 0) {
                ans = i + (n - i * 5) / 2;
                break;
            }
        }
        System.out.println(ans);
    }
}
