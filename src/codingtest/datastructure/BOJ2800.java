package codingtest.datastructure;

import java.util.*;
import java.io.*;

public class BOJ2800 {
    private static char[] arr;
    private static Set<String> set;
    private static List<Bracket> list;
    private static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        set = new TreeSet<>();
        list = new ArrayList<>();
        arr = br.readLine().toCharArray();
        check = new boolean[arr.length];
        solve();
        StringBuilder sb = new StringBuilder();
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next()).append("\n");
        }
        System.out.println(sb);
    }

    private static void solve() {
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(')
                s.push(i);
            else if (arr[i] == ')')
                list.add(new Bracket(s.pop(), i));
        }
        comb(0);
    }

    static void comb(int depth) {
        if (depth == list.size()) {
            boolean f = false;
            StringBuilder sb2 = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                if (!check[i]) {
                    sb2.append(arr[i]);
                } else f = true;
            }
            if (f) {
                set.add(sb2.toString());
            }
            return;
        }

        comb(depth + 1);
        check[list.get(depth).left] = true;
        check[list.get(depth).right] = true;
        comb(depth + 1);
        check[list.get(depth).left] = false;
        check[list.get(depth).right] = false;
    }

    private static class Bracket {
        int left;
        int right;

        public Bracket(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
}
