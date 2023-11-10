package codingtest.tree;

import java.io.*;
import java.util.*;

public class BOJ1991 {
    private static int N;
    private static List<Node> list;
    private static StringBuilder preorder;
    private static StringBuilder inorder;
    private static StringBuilder postorder;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        preorder = new StringBuilder();
        inorder = new StringBuilder();
        postorder = new StringBuilder();
        list = new ArrayList<>();
        String str;
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(new Node((char) ('A' + i)));
        }
        for (int i = 0; i < N; i++) {
            str = br.readLine();
            if (str.charAt(2) != '.')
                list.get(str.charAt(0) - 'A').left = list.get(str.charAt(2) - 'A');
            if (str.charAt(4) != '.')
                list.get(str.charAt(0) - 'A').right = list.get(str.charAt(4) - 'A');
        }
        solve();
        System.out.println(preorder);
        System.out.println(inorder);
        System.out.println(postorder);

    }
    private static void solve(){
        search(list.get(0));
    }

    private static void search(Node node) {
        preorder.append(node.name);
        if(node.left!=null)
            search(node.left);
        inorder.append(node.name);
        if(node.right!=null)
            search(node.right);
        postorder.append(node.name);
    }

    private static class Node {
        char name;
        Node left;
        Node right;

        private Node(char name) {
            this.name = name;

        }
    }
}
