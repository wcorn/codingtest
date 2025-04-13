package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/2504"> 괄호의 값 </a>
 */
public class BOJ2504 {

    private static char[] ch;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ch = br.readLine().toCharArray();
        int num = 1;
        int answer = 0;
        Stack<Character> s = new Stack<>();
        char before = 'a';
        L1:
        for (char c : ch) {
            switch (c) {
                case '(':
                    num *= 2;
                    s.add(c);
                    break;
                case '[':
                    num *= 3;
                    s.add(c);
                    break;
                case ')':
                    if (s.isEmpty() || s.peek() != '(') {
                        answer = 0;
                        break L1;
                    }
                    if (before == '(') {
                        answer += num;
                    }
                    num /= 2;
                    s.pop();
                    break;
                case ']':
                    if (s.isEmpty() || s.peek() != '[') {
                        answer = 0;
                        break L1;
                    }
                    if (before == '[') {
                        answer += num;
                    }
                    num /= 3;
                    s.pop();
                    break;
            }
            before = c;
        }
        if (!s.isEmpty()) {
            answer = 0;
        }
        System.out.println(answer);
    }
}
