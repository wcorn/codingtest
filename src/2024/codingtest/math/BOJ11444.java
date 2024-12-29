package codingtest.math;

import java.io.*;
import java.util.*;

public class BOJ11444 {
    private static final long MOV = 1_000_000_007;
    private static long n;
    private static Map<Long, Long> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new HashMap<>();
        n = Long.parseLong(br.readLine());
        System.out.println(solve());
    }

    private static long solve() {
        return fib(n);
    }

    private static long fib(long value) {
        if (value == 0) return 0;
        if (value == 1) return 1;
        if (value == 2) return 1;
        if (map.containsKey(value)) return map.get(value);
        long temp;
        long a, b;
        if (value % 2 == 0) {
            temp = value / 2;
            a = fib(temp);
            b = fib(temp - 1);
            map.put(value, ((2 * b + a) * a) % MOV);
            return map.get(value);
        }
        temp = (value + 1) / 2;
        a = fib(temp);
        b = fib(temp - 1);
        map.put(value, (a * a + b * b) % MOV);
        return map.get(value);
    }
}
