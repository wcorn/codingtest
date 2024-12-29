package codingtest.recursion;
import java.util.*;
public class PRG15037 {
    public static void main(String[] args){
        long[] i = {7, 42, 5};
        System.out.println(Arrays.toString(solution(i)));
    }
    public static int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        for(int i=0;i<numbers.length;i++){
            if(solve(numbers[i]))
                answer[i] = 1;
            else
                answer[i] = 0;
        }
        return answer;
    }
    public static boolean solve(long number){
        StringBuilder binary = new StringBuilder(Long.toBinaryString(number));
        int treeLen=1;
        int size = binary.length();
        int exp=1;
        while(size>1){
            treeLen += (int) Math.pow(2,(exp++));
            size/=2;
        }
        size = binary.length();
        for(int i=0;i<treeLen-size;i++){
            binary.insert(0, "0");
        }
        return possible(binary.toString());
    }
    public static boolean possible(String binary){
        int size = binary.length();
        int mid = (binary.length())/2;
        if(size==1)
            return true;
        if(binary.charAt(mid)=='0') { //루트가 0이면 자식노드들에서 1이나오면 안됨
            if(size<1)
                return true;
            else {
                int mid2, mid3;
                mid2 = mid-(mid+1)/2;
                mid3 = mid+(mid+1)/2;
                if (binary.charAt(mid2)=='1'||binary.charAt(mid3)=='1') {
                    return false;
                }
            }
        }
        return possible(binary.substring(0,(binary.length()-1)/2))&&possible(binary.substring((binary.length()-1)/2+1));
    }
}
