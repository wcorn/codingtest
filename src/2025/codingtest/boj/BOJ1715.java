package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/1715"> 카드 정렬하기 </a>
 */
public class BOJ1715 {

    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Queue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }
        int result = 0;
        while (pq.size() > 1) {
            int n = pq.poll()+pq.poll();
            result+=n;
            pq.add(n);
        }
        System.out.println(result);
    }
}
