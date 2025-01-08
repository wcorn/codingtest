package codingtest.boj;

import java.io.*;
import java.util.*;

public class BOJ15686 {

    private static int N;
    private static int M;
    private static List<int[]> store;
    private static List<int[]> home;
    private static boolean[] visited;
    private static int[][] dist;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = Integer.MAX_VALUE;
        home = new ArrayList<>();
        store = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < N; j++) {
                char c = temp.charAt(j * 2);
                if (c == '1') {
                    home.add(new int[]{i, j});
                }
                if (c == '2') {
                    store.add(new int[]{i, j});
                }
            }
        }
        visited = new boolean[store.size()];
        dist = new int[home.size()][store.size()];
        for (int i = 0; i < home.size(); i++) {
            for (int j = 0; j < store.size(); j++) {
                dist[i][j] = Math.abs(home.get(i)[0] - store.get(j)[0]) +
                    Math.abs(home.get(i)[1] - store.get(j)[1]);
            }
        }
        dfs(0, 0);
        System.out.println(answer);
    }

    private static void dfs(int depth, int idx) {
        if (depth == M) {
            int sum = 0;
            for (int i = 0; i < home.size(); i++) {
                int length = Integer.MAX_VALUE;
                for (int j = 0; j < store.size(); j++) {
                    if (!visited[j]) {
                        continue;
                    }
                    length = Math.min(length, dist[i][j]);
                }
                sum += length;
            }
            answer = Math.min(answer, sum);
            return;
        }
        for (int i = idx; i < store.size(); i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            dfs(depth + 1, i + 1);
            visited[i] = false;
        }
    }
}