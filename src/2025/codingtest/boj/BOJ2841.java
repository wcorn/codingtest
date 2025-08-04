package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/2841"> 외계인의 기타 연주</a>
 */
public class BOJ2841 {

    private static int N;
    private static int P;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        Queue<Integer>[] q = new PriorityQueue[P + 1];
        for (int i = 0; i <= P; i++) {
            q[i] = new PriorityQueue<>(Collections.reverseOrder());
        }
        int count = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int line = Integer.parseInt(st.nextToken());
            int pret = Integer.parseInt(st.nextToken());
            while (!q[line].isEmpty() && q[line].peek() > pret) {
                q[line].poll();
                count++;
            }
            if (q[line].isEmpty() || q[line].peek() != pret) {
                q[line].add(pret);
                count++;
            }
        }
        System.out.println(count);
    }
}
