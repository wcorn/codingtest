package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/30805"> 사전 순 최대 공통 부분 수열 </a>
 */
public class BOJ30805 {

    private static int N;
    private static Queue<int[]> A;
    private static int M;
    private static Queue<int[]> B;
    private static List<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        A = new PriorityQueue<>((n1,n2)->n1[0]==n2[0] ? Integer.compare(n1[1],n2[1]) : Integer.compare(n2[0],n1[0]));
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A.add(new int[]{Integer.parseInt(st.nextToken()), i});
        }
        M = Integer.parseInt(br.readLine());
        B = new PriorityQueue<>((n1,n2)->n1[0]==n2[0] ? Integer.compare(n1[1],n2[1]) : Integer.compare(n2[0],n1[0]));
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B.add(new int[]{Integer.parseInt(st.nextToken()), i});
        }
        result = new ArrayList<>();
        solve();
        sb.append(result.size()).append("\n");
        for (int i : result) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

    private static void solve() {
        int liA = -1;
        int liB = -1;
        while (!A.isEmpty() && !B.isEmpty()) {
            if (A.peek()[1] < liA) {
                A.poll();
                continue;
            }
            if (B.peek()[1] < liB) {
                B.poll();
                continue;
            }
            if (A.peek()[0] > B.peek()[0]) {
                A.poll();
            }
            else if(A.peek()[0]<B.peek()[0]){
                B.poll();
            } else {
                int[] an = A.poll();
                int[] bn = B.poll();
                result.add(an[0]);
                liA = an[1];
                liB = bn[1];
            }
        }
    }
}
