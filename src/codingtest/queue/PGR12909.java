package codingtest.queue;

import java.io.*;
import java.util.*;

public class PGR12909 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        boolean result = solution(s);
        System.out.println(result);
    }

    private static boolean solution(String s) {
        boolean answer = true;
        Queue<Character> q = new LinkedList<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                q.add(arr[i]);
            }
            if(arr[i]==')'){
                if(q.peek()==null){
                    return false;
                }
                if(q.peek()==')'){
                    return false;
                }
                if(q.peek()=='('){
                    q.remove();
                }
            }
        }
        if(!q.isEmpty())
            return false;
        return answer;
    }

}