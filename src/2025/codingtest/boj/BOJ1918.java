package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/1918"> 후위 표기식 </a>
 */
public class BOJ1918 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> s = new Stack<>();
        char[] ch = br.readLine().toCharArray();
        for (char c : ch) {
            switch (c) {
                case '+':
                case '-':
                case '*':
                case '/':
                    while (!s.isEmpty() && priority(s.peek()) >= priority(c)) {
                        sb.append(s.pop());
                    }
                    s.add(c);
                    break;
                case '(':
                    s.add(c);
                    break;
                case ')':
                    while (!s.isEmpty() && s.peek() != '(') {
                        sb.append(s.pop());
                    }
                    s.pop();
                    break;
                default:
                    sb.append(c);
                    break;
            }
        }
        while (!s.isEmpty()) {
            sb.append(s.pop());
        }
        System.out.println(sb);
    }

    private static int priority(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return 0;
    }
}
