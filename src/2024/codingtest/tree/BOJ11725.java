package codingtest.tree;

import java.io.*;
import java.util.*;

public class BOJ11725 {
    private static int N;
    private static StringBuilder sb;
    private static List<Queue<Integer>> nodes;
    private static List<Integer> result;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        nodes = new ArrayList<>();
        sb = new StringBuilder();
        result = new ArrayList<>();
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        for (int i = 0; i < N + 1; i++) {
            nodes.add(new LinkedList<>());
            result.add(0);
        }
        int a, b;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            nodes.get(a).add(b);
            nodes.get(b).add(a);
        }
        solve();
        for (int i = 2; i < N + 1; i++) {
            sb.append(result.get(i)).append("\n");
        }
        System.out.println(sb);
    }

    private static void solve() {
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> now;
        int value;
        int next;
        q.add(1);
        visited[1] = true;
        while (!q.isEmpty()) {
            value = q.poll();
            now = nodes.get(value);
            while (!now.isEmpty()) {
                next = now.poll();
                if (visited[next])
                    continue;
                result.set(next, value);
                q.add(next);
                visited[next] = true;
            }
        }
    }
}