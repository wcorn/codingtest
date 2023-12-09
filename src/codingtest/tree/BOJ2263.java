package codingtest.tree;

import java.io.*;
import java.util.*;

public class BOJ2263 {
    private static int n;
    private static int[] inOrder;
    private static int[] postOrder;
    private static int[] inOrderIndex;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        inOrder = new int[n];
        postOrder = new int[n];
        inOrderIndex = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            inOrder[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            postOrder[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < n; i++) {
            inOrderIndex[inOrder[i]] = i;
        }
        solve(0, n - 1, 0, n - 1);
        System.out.println(sb);
    }

    public static void solve(int inStart, int inEnd, int preStart, int preEnd) {
        if (inStart > inEnd || preStart > preEnd) {
            return;
        }
        sb.append(postOrder[preEnd]).append(" ");
        int rootIndex = inOrderIndex[postOrder[preEnd]];
        int leftNodeLength = rootIndex - inStart;
        solve(inStart, rootIndex - 1, preStart, preStart + leftNodeLength - 1);
        solve(rootIndex + 1, inEnd, preStart + leftNodeLength, preEnd - 1);
    }
}
