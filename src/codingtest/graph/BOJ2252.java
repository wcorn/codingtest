package codingtest.graph;

import java.io.*;
import java.util.*;

public class BOJ2252 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int a, b;
        List<Node> nodes = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nodes.add(new Node(i));
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            nodes.get(a - 1).nextNode.add(b - 1);
            nodes.get(b - 1).size++;
        }
        Queue<Node> queue = new LinkedList<>();
        for (Node node : nodes) {
            if (node.size == 0) {
                queue.add(node);
            }
        }
        Node temp;
        while (!queue.isEmpty()) {
            temp = queue.poll();
            for (Integer i : temp.nextNode) {
                if (--nodes.get(i).size == 0) {
                    queue.add(nodes.get(i));
                }
            }
            sb.append(temp.num).append(" ");
        }
        System.out.println(sb);
    }

    private static class Node {
        int num;
        int size;
        List<Integer> nextNode;

        public Node(int num) {
            this.num = num;
            size = 0;
            nextNode = new ArrayList<>();
        }
    }
}
