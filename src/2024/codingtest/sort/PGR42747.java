package codingtest.sort;
import java.util.*;
public class PGR42747 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 0, 6, 1, 5}));
    }
    public static int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        int a;
        for(int i=0;i<citations.length;i++){
            a = citations.length-i;
            if(citations[i]>=a)
                return a;
        }
        return 0;
    }
}
