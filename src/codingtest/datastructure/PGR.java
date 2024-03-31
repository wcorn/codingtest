package codingtest.datastructure;

import java.util.*;

public class PGR {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 1, 3, 2},2));
    }
    public static int solution(int[] priorities, int location) {
        int answer=0;
        Queue<Process> q = new LinkedList<>();
        for(int i=0;i<priorities.length;i++){
            q.add(new Process(i, priorities[i]));
        }
        Arrays.sort(priorities);
        int k = priorities.length-1;
        Process temp;
        while(true){
            temp = q.poll();
            if(temp.priority==priorities[k]){
                answer++;
                k--;
                if(temp.pid==location)
                    break;
            }
            q.add(temp);
        }
        return answer;
    }
    public static class Process{
        int pid;
        int priority;
        public Process(int pid, int priority){
            this.pid = pid;
            this.priority = priority;
        }
    }
}
