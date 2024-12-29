package codingtest.datastructure;

import java.util.*;

public class PGR42626 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 9, 10, 12},7));
    }
    public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<scoville.length;i++){
            pq.add(scoville[i]);
        }
        int a,b;
        while(true){
            if(pq.size()<2){
                if(pq.peek()<K)
                    return -1;
                break;
            }
            if(pq.peek()>=K)
                break;
            answer++;
            a = pq.poll();
            b = pq.poll();
            pq.add(a+b*2);
        }
        return answer;
    }
}
