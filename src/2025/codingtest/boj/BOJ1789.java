package codingtest.boj;

import java.io.*;

/**
 * <a href="https://www.acmicpc.net/problem/1789">수들의 합</a>
 */
public class BOJ1789 {

    private static long S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = Long.parseLong(br.readLine());
        long N = 1;
        while (true) {
            if (S >= N) {
                S -= N;
            } else {
                break;
            }
            N++;
        }
        System.out.println(N - 1);
    }
}
