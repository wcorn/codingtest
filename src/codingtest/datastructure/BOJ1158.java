package codingtest.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int cnt = 0;
        int data;
        Queue Josep = new Queue();
        for (int i = 1; i <= N; i++) {
            Josep.push(i);
        }
        while (!Josep.isEmpty()) {
            data = Josep.pop();
            cnt++;
            if (cnt % K == 0) {
                if(Josep.isEmpty()){
                    sb.append(data);
                }else {
                    sb.append(data).append(", ");
                }
            } else {
                Josep.push(data);
            }
        }
        sb.append(">");
        System.out.println(sb);
    }

    public static class Queue {
        public static class Node {
            int data;
            Node next;
            Node prev;

            public Node(Node prev, int data, Node next) {
                this.prev = prev;
                this.data = data;
                this.next = next;
            }
        }

        private Node first;
        private Node last;
        private int size;

        public void push(int data) {
            Node l = last;
            Node newNode = new Node(l, data, null);
            last = newNode;
            if (size <= 0) {
                first = newNode;
            } else {
                l.next = newNode;
            }
            size++;
        }

        public int pop() {
            if (size <= 0)
                return -1;
            int data = first.data;
            size--;
            if (size <= 0) {
                first = null;
                last = null;
                return data;
            }
            Node next = first.next;
            first.data = 0;
            first.prev = null;
            first.next = null;
            first = next;
            return data;
        }

        public boolean isEmpty() {
            return size <= 0;
        }

        public int size() {
            return size;
        }
    }
}
