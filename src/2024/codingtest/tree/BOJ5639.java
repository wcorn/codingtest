package codingtest.tree;

import java.io.*;

public class BOJ5639 {
    private static Node h;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        h = new Node(Integer.parseInt(br.readLine()));
        String input;
        while (true) {
            input = br.readLine();
            if (input == null)
                break;
            init(Integer.parseInt(input));
        }
        postOrder(h);
        System.out.println(sb);
    }

    private static void postOrder(Node node) {
        if (node.left != null) {
            postOrder(node.left);
        }
        if (node.right != null) {
            postOrder(node.right);
        }
        sb.append(node.value).append("\n");
    }

    private static void init(int value) {
        Node temp = h;
        while (true) {
            if (temp.value > value) {
                if (temp.left == null) {
                    temp.left = new Node(value);
                    return;
                }
                temp = temp.left;
            } else if (temp.value < value) {
                if (temp.right == null) {
                    temp.right = new Node(value);
                    return;
                }
                temp = temp.right;
            }
        }

    }

    private static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }
}
