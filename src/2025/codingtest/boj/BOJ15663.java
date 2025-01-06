package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/15663"> N과 M (9) </a>
 */
public class BOJ15663 {

    private static int N;
    private static int M;
    private static Set<String> set;
    private static boolean[] visited;
    private static List<Integer> list;
    private static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dist = new int[M];
        visited = new boolean[N];
        set = new LinkedHashSet<>();
        list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);
        dfs(0);
        for (String s : set) {
            System.out.println(s);
        }
    }

    private static void dfs(int depth) {
        if (depth == M) {
            StringBuilder sb = new StringBuilder();
            for (int i : dist) {
                sb.append(i).append(" ");
            }
            set.add(sb.toString());
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            dist[depth] = list.get(i);
            dfs(depth + 1);
            visited[i] = false;
        }
    }
}
