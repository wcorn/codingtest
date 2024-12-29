package codingtest.datastructure;

import java.util.*;

public class PGR131704 {

    public static void main(String[] args) {
        System.out.println(solution(new int[] {4, 3, 1, 2, 5}));
    }
    public static int solution(int[] order) {
        int index = 0;
        int size = order.length;
        Stack<Integer> s = new Stack<>();
        for(int i=1;i<=size; i++){
            if(order[index]!=i){
                s.push(i);
            }else{
                index++;
            }
            while(!s.isEmpty()&&order[index]==s.peek()){
                index++;
                s.pop();
            }
        }
        return index;
    }
}
