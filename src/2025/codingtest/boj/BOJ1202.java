package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/1202"> 보석 도둑 </a>
 */
public class BOJ1202 {

    private static int N;
    private static int K;
    private static long[][] arr;
    private static int[] bag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new long[N][2];
        bag = new int[K];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Long.parseLong(st.nextToken());
            arr[i][1] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr, (n1, n2) -> Long.compare(n1[0], n2[0]));
        for (int i = 0; i < K; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bag);
        long answer = 0;
        int j = 0;
        Queue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : bag) {
            while (j < N && arr[j][0] <= i) {
                pq.add(arr[j++][1]);
            }
            if (!pq.isEmpty()) {
                answer += pq.poll();
            }
        }
        System.out.println(answer);
    }
}
