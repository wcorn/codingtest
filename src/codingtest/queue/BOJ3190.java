package codingtest.queue;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ3190 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        boolean[][] apple = new boolean[N][N];
        Queue q = new Queue();
        int dir = 0;
        int count = 0;
        q.add(0, 0);
        int[][] point = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            apple[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = true;
        }
        int L = Integer.parseInt(br.readLine());
        String[][] XC = new String[L][2];
        String X;
        String C;
        int flag = 0;
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            X = st.nextToken();
            C = st.nextToken();
            XC[i][0] = X;
            XC[i][1] = C;
        }
        while (true) {
            int x = q.last.x;
            int y = q.last.y;
            int nextX = x + point[dir][0];
            int nextY = y + point[dir][1];
            count++;
            if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N || q.contains(nextX, nextY)) {
                System.out.println(count);
                return;
            }
            q.add(nextX, nextY);
            if (!apple[nextX][nextY]) {
                q.remove();
            }
            apple[nextX][nextY] = false;
            if (flag < L) {
                if (Integer.parseInt(XC[flag][0]) == count) {
                    dir = rotate(XC[flag][1].toCharArray()[0], dir);
                    flag++;
                }
            }
        }
    }

    public static int rotate(char c, int dir) {
        if (c == 'D') {
            dir++;
            if (dir > 3) {
                dir = 0;
            }
        }
        if (c == 'L') {
            dir--;
            if (dir < 0) {
                dir = 3;
            }
        }
        return dir;
    }

    public static class Queue {
        public class Node {
            int x;
            int y;
            Node next;
            Node prev;

            public Node(Node prev, int x, int y, Node next) {
                this.prev = prev;
                this.next = next;
                this.x = x;
                this.y = y;
            }
        }

        int size = 0;
        Node first;
        Node last;

        public void add(int x, int y) {
            Node l = last;
            Node newNode = new Node(l, x, y, null);
            last = newNode;
            if (l == null) {
                first = newNode;
            } else {
                l.next = newNode;
            }
            size++;
        }

        public void remove() {
            if (size <= 0)
                return;
            size--;
            if (first.next == null) {
                first = null;
                last = null;
                return;
            }
            first = first.next;
        }

        public boolean contains(int x, int y) {
            if (size <= 0)
                return false;
            for (Node n = first; n != null; n = n.next) {
                if (n.x == x && n.y == y)
                    return true;
            }
            return false;
        }
    }
}

