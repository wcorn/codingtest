package codingtest.search;

import java.io.*;
import java.util.*;

public class BOJ15686 {
    private static int N;
    private static int M;
    private static List<Point> house;
    private static List<Point> chicken;
    private static Point[] sequence;
    private static int chickenDistance = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        house = new ArrayList<>();
        chicken = new ArrayList<>();
        sequence = new Point[M];
        int temp;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                temp = Integer.parseInt(st.nextToken());
                if (temp == 0) continue;
                if (temp == 1) {
                    house.add(new Point(i, j));
                } else if (temp == 2) {
                    chicken.add(new Point(i, j));
                }
            }
        }
        solve();
        System.out.println(chickenDistance);
    }

    private static void solve() {
        dfs(0, 0);
    }

    private static void dfs(int now, int depth) {
        if (depth == M) {
            int sum = 0;
            for (int i = 0; i < house.size(); i++) {
                int min = 101;
                for (int j = 0; j < M; j++) {
                    min = Math.min(min,Math.abs(sequence[j].x-house.get(i).x)+Math.abs(sequence[j].y-house.get(i).y));
                }
                sum+=min;
            }
            chickenDistance = Math.min(sum,chickenDistance);
            return;
        }
        for (int i = now; i < chicken.size(); i++) {
            sequence[depth] = chicken.get(i);
            dfs(i + 1, depth + 1);
        }
    }

    private static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }
}
