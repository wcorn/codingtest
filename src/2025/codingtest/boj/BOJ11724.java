package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/11724"> 연결 요소의 개수 </a>
 */
public class BOJ11724 {

    private static int N;
    private static int M;
    private static Set<Integer>[] set;
    private static boolean[] visited;
    private static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        set = new Set[N];
        for (int i = 0; i < N; i++) {
            set[i] = new HashSet<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            set[a].add(b);
            set[b].add(a);
        }
        result = 0;
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            if (visited[i]) {
                continue;
            }
            result++;
            find(i);
        }
        System.out.println(result);
    }

    private static void find(int num) {
        visited[num] = true;
        List<Integer> list = new ArrayList<>(set[num]);
        for (int i : list) {
            if (visited[i]) {
                continue;
            }
            find(i);
        }
    }
}
