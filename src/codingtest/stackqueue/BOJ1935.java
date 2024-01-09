package codingtest.stackqueue;

import java.io.*;
import java.util.*;

public class BOJ1935 {
    private static int N;
    private static char[] expression;
    private static double[] value;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        value = new double[N];
        expression = br.readLine().toCharArray();
        for (int i = 0; i < N; i++) {
            value[i] = Integer.parseInt(br.readLine());
        }
        System.out.printf("%.2f", solve());
    }

    private static Double solve() {
        Stack<Double> stack = new Stack<>();
        double d1, d2, d3;
        for (int i = 0; i < expression.length; i++) {
            if ('A' <= expression[i] && expression[i] <= 'Z') {
                stack.push(value[expression[i] - 'A']);
            } else {
                d1 = stack.pop();
                d2 = stack.pop();
                switch (expression[i]) {
                    case '+':
                        d3 = d2 + d1;
                        break;
                    case '-':
                        d3 = d2 - d1;
                        break;
                    case '*':
                        d3 = d2 * d1;
                        break;
                    case '/':
                        d3 = d2 / d1;
                        break;
                    default :
                        d3 = 0;
                        break;
                }
                stack.push(d3);
            }
        }
        return stack.pop();
    }
}
