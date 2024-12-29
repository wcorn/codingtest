package codingtest.greedy;

import java.util.*;

public class BOJ42885 {
    public static void main(String[] args) {
        int[] people = {70,50,80,50};
        int limit = 100;
        System.out.println(solution(people, limit));
    }
    public static int solution(int[] people, int limit) {
        int answer=0;
        Arrays.sort(people);
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<people.length;i++){
            list.add(people[i]);
        }
        int b;
        while(!list.isEmpty()){
            b = list.remove(list.size()-1);
            answer++;
            if(list.isEmpty())
                break;
            if(list.get(0)+b<=limit){
                list.remove(0);
            }
        }
        return answer;
    }
}
