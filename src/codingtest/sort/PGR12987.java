package codingtest.sort;

import java.util.*;

public class PGR12987 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{5,1,3,7}, new int[]{5,1,3,7}));
    }
    public static int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int indexA = A.length-1;;
        int indexB = B.length-1;;
        for(int i = indexA; i >= 0; i--){
            if(A[i]<B[indexB]){
                answer++;
                indexB--;
            }
        }
        return answer;
    }
}
