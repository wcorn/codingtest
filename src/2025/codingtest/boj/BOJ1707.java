package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/1707"> 이분 그래프 </a>
 */
public class BOJ1707 {

    private static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            List<Integer>[] list = new ArrayList[V];
            int start = 0;
            for (int j = 0; j < V; j++) {
                list[j] = new ArrayList<>();
            }
            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                int n1 = Integer.parseInt(st.nextToken()) - 1;
                int n2 = Integer.parseInt(st.nextToken()) - 1;
                list[n1].add(n2);
                list[n2].add(n1);
            }
            int[] color = new int[V];
            boolean flag = true;
            for (int j = 0; j < V; j++) {
                if (color[j] == 0) {
                    flag = solve(list, color, V, j);
                }
                if (!flag) {
                    break;
                }
            }
            if (flag) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }
        System.out.println(sb);
    }

    private static boolean solve(List<Integer>[] list, int[] color, int V, int num) {
        Queue<Integer> q = new LinkedList<>();
        q.add(num);
        color[num] = 1;
        while (!q.isEmpty()) {
            int n = q.poll();
            for (int i : list[n]) {
                if (color[i] == 0) {
                    color[i] = color[n] * -1;
                    q.add(i);
                } else if (color[i] == color[n]) {
                    return false;
                }
            }
        }
        return true;
    }
}
