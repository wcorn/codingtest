package codingtest.greedy;

import java.io.*;
import java.util.*;

public class BOJ1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PriorityQueue<Integer> A = new PriorityQueue<>();
        PriorityQueue<Integer> B = new PriorityQueue<>(Collections.reverseOrder());
        int ans = 0;
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A.offer(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B.offer(Integer.parseInt(st.nextToken()));
        }
        for (int i = 0; i < N; i++) {
            ans += A.poll() * B.poll();
        }
        System.out.println(ans);
    }
}
