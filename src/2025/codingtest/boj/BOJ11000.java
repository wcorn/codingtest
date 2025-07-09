package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/11000"> 강의실 배정 </a>
 */
public class BOJ11000 {

    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new int[]{a, b});
        }
        Collections.sort(list, (n1, n2) -> n1[0] == n2[0]
            ? Integer.compare(n1[1], n2[1]) : Integer.compare(n1[0], n2[0]));
        Queue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int[] a = list.get(i);
            if (!pq.isEmpty() && pq.peek() <= a[0]) {
                pq.poll();
            }
            pq.add(a[1]);
        }
        System.out.println(pq.size());
    }

}
