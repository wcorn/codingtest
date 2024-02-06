package codingtest.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2903 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans = 2;
        for (int i = 0; i < N; i++) {
            ans = 2 * ans - 1;
        }
        System.out.println((int)Math.pow(ans,2));
    }
}
