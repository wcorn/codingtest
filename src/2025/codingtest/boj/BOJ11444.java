package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/11444"> 피보나치 수 6 </a>
 */
public class BOJ11444 {

    private static Long n;
    private static Map<Long, Long> map;
    private static final int INF = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Long.parseLong(br.readLine());
        map = new HashMap<>();
        map.put(0L, 0L);
        map.put(1L, 1L);
        map.put(2L, 1L);
        System.out.println(find(n));
    }

    private static Long find(Long num) {
        if (map.containsKey(num)) {
            return map.get(num);
        }
        long result;
        if (num % 2 == 0) {
            Long a = find(num / 2);
            Long b = find(num / 2 - 1);
            Long c = find(num / 2);
            result = a * (2 * b + c);
        } else {
            Long a = find((num + 1) / 2);
            Long b = find((num - 1) / 2);
            result = a * a + b * b;
        }
        result %= INF;
        map.put(num, result);
        return result % INF;
    }
}
