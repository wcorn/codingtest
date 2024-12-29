package codingtest.datastructure;

import java.util.*;

public class PGR154539 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{2, 3, 3, 5})));
    }
    public static int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> s = new Stack<>();
        for(int i=0;i<numbers.length;i++){
            while(!s.isEmpty()&&numbers[s.peek()] < numbers[i])
                answer[s.pop()] = numbers[i];
            s.push(i);
        }
        while(!s.isEmpty()){
            answer[s.pop()] = -1;
        }
        return answer;
    }
}
