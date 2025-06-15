package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/1935"> 후위 표기식2 </a>
 */
public class BOJ1935 {

    private static int N;
    private static int[] arr;
    private static Stack<Double> s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        s = new Stack<>();

        String expression = br.readLine();
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (char c : expression.toCharArray()) {
            if (Character.isUpperCase(c)) {
                s.push((double) arr[c - 'A']);
            } else {
                double b = s.pop();
                double a = s.pop();
                switch (c) {
                    case '+':
                        s.push(a + b);
                        break;
                    case '-':
                        s.push(a - b);
                        break;
                    case '*':
                        s.push(a * b);
                        break;
                    case '/':
                        s.push(a / b);
                        break;
                }
            }
        }
        System.out.printf("%.2f", s.pop());
    }
}
