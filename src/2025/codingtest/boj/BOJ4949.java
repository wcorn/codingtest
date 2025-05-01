package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/4949"> 균형잡힌 세상 </a>
 */
public class BOJ4949 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> s = new Stack<>();
        while (true) {
            String str = br.readLine();
            if (str.equals(".")) {
                break;
            }
            boolean flag = true;
            s.clear();
            for (char c : str.toCharArray()) {
                if (c == '(' || c == '[') {
                    s.push(c);
                }
                if (c == ')') {
                    if (!s.isEmpty() && s.peek() == '(') {
                        s.pop();
                    } else {
                        flag = false;
                        break;
                    }
                }
                if (c == ']') {
                    if (!s.isEmpty() && s.peek() == '[') {
                        s.pop();
                    } else {
                        flag = false;
                        break;
                    }
                }
            }
            if (!s.isEmpty()) {
                flag = false;
            }
            if (flag) {
                sb.append("yes").append("\n");
            } else {
                sb.append("no").append("\n");
            }
        }
        System.out.println(sb);
    }

}
