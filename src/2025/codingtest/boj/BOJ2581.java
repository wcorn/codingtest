package codingtest.boj;

import java.io.*;

/**
 * <a href="https://www.acmicpc.net/problem/2581"> 소수 </a>
 */
public class BOJ2581 {

    private static int M;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int min = 0;
        int sum = 0;
        M = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        if (M == 1) {
            M = 2;
        }
        for (int i = N; i >= M; i--) {
            boolean flag = true;
            for (int j = 2; j < Math.sqrt(i); j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                sum += i;
                min = i;
            }
        }
        if (sum == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum + "\n" + min);
        }
    }
}
