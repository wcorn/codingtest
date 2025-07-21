package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/20916"> 안녕 2020 안녕 2021 </a>
 */
public class BOJ20916 {

    private static int T;
    private static Set<Long> s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        s = new HashSet<>();
        T = Integer.parseInt(br.readLine());
        init();
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            Map<Long, Integer> m = new HashMap<>();
            for (int j = 0; j < n; j++) {
                long num = Long.parseLong(st.nextToken());
                m.put(num, m.getOrDefault(num, 0) + 1);
            }
            sb.append(find(m)).append("\n");
        }
        System.out.println(sb);
    }

    private static long find(Map<Long, Integer> m) {
        long count = 0;
        for (long i : m.keySet()) {
            int num = m.getOrDefault(i, 0);
            for (long j : s) {
                long t = m.getOrDefault(j - i, 0);
                count += num * t;
            }
        }
        return count / 2;
    }

    private static void init() {
        s.add(202021L);
        s.add(20202021L);
        s.add(202002021L);
        s.add(202012021L);
        s.add(202022021L);
        s.add(202032021L);
        s.add(202042021L);
        s.add(202052021L);
        s.add(202062021L);
        s.add(202072021L);
        s.add(202082021L);
        s.add(202092021L);
    }
}
