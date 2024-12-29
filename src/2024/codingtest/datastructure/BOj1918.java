package codingtest.datastructure;

import java.io.*;
import java.util.*;

public class BOj1918 {
    private static char[] formula;
    private static Stack<Character> stack;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        stack = new Stack<>();
        sb = new StringBuilder();
        formula = br.readLine().toCharArray();
        solve();
        System.out.println(sb);
    }

    private static void solve() {
        for (int i = 0; i < formula.length; i++) {
            switch (formula[i]) {
                case '(':
                    stack.push('(');
                    break;
                case ')':
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    stack.pop();
                    break;
                case '*': case '/':
                    while (!stack.isEmpty() && (stack.peek() == '*'||stack.peek() == '/')) {
                        sb.append(stack.pop());
                    }
                    stack.push(formula[i]);
                    break;
                case '-': case '+':
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    stack.push(formula[i]);
                    break;
                default:
                    sb.append(formula[i]);
                    break;
            }
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
    }
}
