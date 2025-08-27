package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/5639"> 이진 검색 트리 </a>
 */
public class BOJ5639 {

    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        String str;
        Node h = new Node(Integer.parseInt(br.readLine()));
        while (true) {
            str = br.readLine();
            if (str==null || str.isEmpty()) {
                break;
            }
            int num = Integer.parseInt(str);
            h.add(num);
        }
        h.postOrder();
        System.out.println(sb);
    }

    private static class Node {

        int num;
        Node left;
        Node right;

        Node(int num) {
            this.num = num;
            this.left = null;
            this.right = null;
        }

        public void add(int num) {
            if (this.num > num) {
                if (left == null) {
                    left = new Node(num);
                } else {
                    left.add(num);
                }
            } else if (this.num < num) {
                if (right == null) {
                    right = new Node(num);
                } else {
                    right.add(num);
                }
            }
        }

        public void postOrder() {
            if (left != null) {
                left.postOrder();
            }
            if (right != null) {
                right.postOrder();
            }
            sb.append(this.num).append("\n");
        }
    }
}
