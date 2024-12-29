package codingtest.datastructure;

import java.io.*;
import java.util.*;

public class BOJ3986 {
    private static int N;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        answer = 0;
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            solve(br.readLine().toCharArray());
        }
        System.out.println(answer);
    }

    private static void solve(char[] arr) {
        if (arr.length % 2 == 1)
            return;
        Stack<Character> s = new Stack<>();
        char num1;
        for (int i = 0; i < arr.length; i++) {
            if (s.isEmpty())
                s.push(arr[i]);
            else if (s.peek() == arr[i])
                s.pop();
            else
                s.push(arr[i]);
            if (s.size() >= 2) {
                num1 = s.pop();
                if (num1 != s.peek()) {
                    s.push(num1);
                }
            }
        }
        if (s.isEmpty())
            answer++;
    }
}
