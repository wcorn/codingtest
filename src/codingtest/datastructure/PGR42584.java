package codingtest.datastructure;

import java.util.*;

public class PGR42584 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 2, 3})));
    }
    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> s = new Stack<>();
        int a;
        for(int i=0;i<prices.length;i++){
            while(!s.isEmpty() && prices[i] < prices[s.peek()]){
                a = s.pop();
                answer[a] = i - a;
            }
            s.push(i);
        }
        while(!s.isEmpty()){
            a = s.pop();
            answer[a] = prices.length - 1 - a;
        }
        return answer;
    }
}
