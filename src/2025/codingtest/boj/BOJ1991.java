package codingtest.boj;

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
        N = Integer.parseInt(br.readLine());
        preorder = new StringBuilder();
        inorder = new StringBuilder();
        postorder = new StringBuilder();
        list = new ArrayList<>();
        for(int i = 0; i < N; i++){
            list.add(new Node((char)('A'+i)));
        }
        int a,b,c;
        String str;
        for(int i = 0; i < N; i++){
            str = br.readLine();
            a = str.charAt(0)-'A';
            b = str.charAt(2)-'A';
            c = str.charAt(4)-'A';
            Node temp = list.get(a);
            if(b!=-19)
                temp.left = list.get(b);
            if(c!=-19)
                temp.right = list.get(c);
        }
        traversal(list.get(0));
        System.out.println(preorder);
        System.out.println(inorder);
        System.out.println(postorder);
    }
    private static void traversal(Node now){
        preorder.append(now.index);
        if(now.left!=null)
            traversal(now.left);
        inorder.append(now.index);
        if(now.right!=null)
            traversal(now.right);
        postorder.append(now.index);
    }
    private static class Node{
        char index;
        Node left;
        Node right;
        public Node(char index){
            this.index  = index;
            left = null;
            right = null;
        }
    }
}
