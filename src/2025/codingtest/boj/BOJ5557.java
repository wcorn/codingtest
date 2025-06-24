package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/5557"> 1학년 </a>
 */
public class BOJ5557 {

    private static int N;
    private static Map<Integer, Long> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        map = new HashMap<>();
        map.put(Integer.parseInt(st.nextToken()), 1L);
        for (int i = 1; i < N-1; i++) {
            int num = Integer.parseInt(st.nextToken());
            Map<Integer, Long> temp = new HashMap<>();
            for (int t : map.keySet()) {
                int pk = t + num;
                int mk = t - num;
                if (pk <= 20) {
                    long n = temp.getOrDefault(pk, 0L) + map.getOrDefault(t, 0L);
                    temp.put(pk, n);
                }
                if (mk >= 0) {
                    long n = temp.getOrDefault(mk, 0L) + map.getOrDefault(t, 0L);
                    temp.put(mk, n);
                }
            }
            map = temp;
        }
        System.out.println(map.get(Integer.parseInt(st.nextToken())));
    }
}
