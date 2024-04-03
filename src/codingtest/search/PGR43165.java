package codingtest.search;

import java.util.*;

public class PGR43165 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,1,1,1,1},3));
    }
    public static int solution(int[] numbers, int target) {
        int answer = 0;
        Queue<NUM> q = new LinkedList<>();
        q.add(new NUM(numbers[0],0));
        q.add(new NUM(-numbers[0],0));
        NUM now;
        while(!q.isEmpty()){
            now = q.poll();
            if(now.index==numbers.length-1){
                if(now.sum==target)
                    answer++;
                continue;
            }
            q.add(new NUM(now.sum+numbers[now.index+1],now.index+1));
            q.add(new NUM(now.sum-numbers[now.index+1],now.index+1));
        }
        return answer;
    }
    static class NUM{
        int sum;
        int index;
        NUM(int sum, int index){
            this.sum = sum;
            this.index = index;
        }
    }
}
