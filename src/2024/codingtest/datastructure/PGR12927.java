package codingtest.datastructure;

import java.util.*;

public class PGR12927 {

    public static void main(String[] args) {
        System.out.println(solution(4,new int[]{4, 3, 3}));
    }
    public static long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<works.length;i++){
            q.add(works[i]);
        }
        int k;
        for(int i=0;i<n;i++){
            if(q.isEmpty())
                break;
            k = q.poll();
            if(k==0)
                continue;
            q.add(--k);
        }
        while(!q.isEmpty()){
            answer+=Math.pow(q.poll(),2);
        }
        return answer;
    }
}
