package codingtest.simulation;

import java.io.IOException;
import java.util.*;

public class PGR131127 {
    public static void main(String[] args) throws IOException {
        System.out.println(solution(new String[]{"banana", "apple", "rice", "pork", "pot"},
            new int[]{3, 2, 2, 2, 1},
            new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"}));
    }
    public static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> hashMap;
        int i=0;
        boolean flag;
        while(i <= discount.length-10){
            hashMap = new HashMap<>();
            flag = true;
            for(int k=0;k<want.length;k++){
                hashMap.put(want[k],0);
            }
            for(int k=0;k<10;k++){
                if(hashMap.containsKey(discount[i+k]))
                    hashMap.replace(discount[i+k],hashMap.get(discount[i+k])+1);
            }
            for(int k=0;k<want.length;k++){
                if(hashMap.get(want[k])!=number[k]){
                    flag = false;
                }
            }
            if(flag)
                answer++;
            i++;
        }
        return answer;
    }
}
