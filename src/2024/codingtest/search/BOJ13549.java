package codingtest.search;
import java.io.*;
import java.util.*;

public class BOJ13549 {
    static int start;
    static int end;
    static int[] time;
    static final int INF = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        time = new int[INF + 1];
        solve();
        System.out.println(time[end]);
    }

    private static void solve() {
        PriorityQueue<Node> q = new PriorityQueue<>();
        Arrays.fill(time, INF);
        q.add(new Node(start, 0));
        time[start] = 0;
        int nextPoint;
        while (!q.isEmpty()) {
            Node current = q.remove();
            if (time[current.point] < current.time)
                continue;
            nextPoint = current.point - 1;
            if (nextPoint >= 0 && nextPoint <= INF && time[nextPoint] > current.time + 1) {
                time[nextPoint] = current.time + 1;
                q.add(new Node(nextPoint, current.time + 1));
            }
            nextPoint = current.point + 1;
            if (nextPoint >= 0 && nextPoint <= INF && time[nextPoint] > current.time + 1) {
                time[nextPoint] = current.time + 1;
                q.add(new Node(nextPoint, current.time + 1));
            }
            nextPoint = current.point * 2;
            if (nextPoint >= 0 && nextPoint <= INF && time[nextPoint] > current.time) {
                time[nextPoint] = current.time;
                q.add(new Node(nextPoint, current.time));
            }
        }
    }

    static class Node implements Comparable<Node> {
        int point;
        int time;

        public Node(int point, int time) {
            this.point = point;
            this.time = time;
        }

        @Override
        public int compareTo(Node node) {
            return this.time - node.time;
        }
    }
}