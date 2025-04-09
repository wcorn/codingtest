package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/2609"> 최대공약수와 최소공배수 </a>
 */
public class BOJ2609 {

    private static long a;
    private static long b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());
        long gcd = gcd(a, b);
        System.out.println(gcd);
        System.out.println(gcd * a / gcd * b / gcd);
    }

    private static long gcd(long x, long y) {
        if (x % y == 0) {
            return y;
        }
        return gcd(y, x % y);
    }
}
