package codingtest.greedy;
import java.util.*;
public class PGR138476 {
    public static void main(String[] args) {
        System.out.println(solution(6,new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
    }
    public static int solution(int k, int[] tangerine) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        Arrays.sort(tangerine);
        list.add(1);
        for(int i=1;i<tangerine.length;i++){
            if(tangerine[i-1]==tangerine[i]){
                list.set(list.size()-1,list.get(list.size()-1)+1);
            }
            else
                list.add(1);
        }
        int now=0;
        Collections.sort(list,Collections.reverseOrder());
        for(int i=0;i<list.size();i++){
            now+=list.get(i);
            answer++;
            if(now>=k)
                break;
        }
        return answer;
    }
}
