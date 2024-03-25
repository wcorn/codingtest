package codingtest.datastructure;

import java.util.*;

public class PGR12973 {
    public static void main(String[] args) {
        System.out.println(solution("baabaa"));
    }

    public static int solution(String s)
    {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        char[] ch = s.toCharArray();
        for(int i=0;i<ch.length;i++){
            if(stack.isEmpty())
                stack.push(ch[i]);
            else if(stack.peek()==ch[i])
                stack.pop();
            else
                stack.push(ch[i]);
        }
        if(stack.isEmpty())
            answer=1;
        return answer;
    }
}
