package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/13172"> Σ </a>
 */
public class BOJ13172 {

    private static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int M = Integer.parseInt(br.readLine());
        long result = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            result+=solve(B, A);
            result%=MOD;
        }
        System.out.println(result);
    }

    private static int solve(int a, int b) {
        if (a % b == 0) {
            return a / b;
        }
        int gcd = gcd(a, b);
        a /= gcd;
        b /= gcd;
        long bp = reverse(b);
        return (int)(bp * a % MOD);
    }

    private static long reverse(int num) {
        return pow(num, MOD - 2);
    }

    private static long pow(int num, int count) {
        if (count <= 1) {
            return num;
        }
        long temp = pow(num, count / 2);
        return (temp * temp) % MOD * (count % 2 == 1 ? num : 1) % MOD;
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
