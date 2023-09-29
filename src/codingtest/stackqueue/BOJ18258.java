package codingtest.stackqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ18258 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int X;
        Queue q = new Queue();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String offer = st.nextToken();
            switch (offer) {
                case "push":
                    X = Integer.parseInt(st.nextToken());
                    q.push(X);
                    break;
                case "pop":
                    sb.append(q.pop()).append("\n");
                    break;
                case "size":
                    sb.append(q.size()).append("\n");
                    break;
                case "empty":
                    sb.append(q.empty()).append("\n");
                    break;
                case "front":
                    sb.append(q.front()).append("\n");
                    break;
                case "back":
                    sb.append(q.back()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }

    public static class Queue {
        Node first;
        Node last;
        int size = 0;

        public static class Node {
            int data;
            Node prev;
            Node next;

            public Node(Node prev, int data, Node next) {
                this.data = data;
                this.prev = prev;
                this.next = next;
            }
        }

        public int size() {
            return size;
        }

        public void push(int data) {
            Node l = last;
            Node newNode = new Node(l, data, null);
            last = newNode;
            if (l == null) {
                first = newNode;
            } else {
                l.next = newNode;
            }
            size++;
        }

        public int pop() {
            if (size <= 0)
                return -1;
            Node n = first;
            size--;
            int data = n.data;
            if (first.next == null) {
                first = null;
                last = null;
                return data;
            }
            first = first.next;
            return data;
        }

        public int empty() {
            if (size <= 0)
                return 1;
            else
                return 0;
        }

        public int front() {
            if (first != null)
                return first.data;
            else
                return -1;
        }

        public int back() {
            if (last != null)
                return last.data;
            else
                return -1;
        }
    }
}
