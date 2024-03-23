package codingtest.datastructure;

import java.util.*;

public class PRG12909 {
    public static void main(String[] args) {
        System.out.println(solution("(())()"));
    }

    public static boolean solution(String s) {
        char[] ch = s.toCharArray();
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '(')
                st.push(ch[i]);
            else {
                if (st.isEmpty())
                    return false;
                if (st.pop() == ')')
                    return false;
            }
        }
        return st.isEmpty();
    }
}
