package codingtest.string;

import java.util.Arrays;

public class PGR70129 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("110010101001")));
    }
    static int a = 0;
    static int b = 0;
    public static int[] solution(String s) {
        while(!s.equals("1")){
            a++;
            s = remove(s);
            s = Integer.toString(s.length(),2);
        }
        return new int[] {a, b};
    }
    public static String remove(String s){
        String answer="";
        char[] ch = s.toCharArray();
        for(int i=0;i<ch.length;i++){
            if(ch[i]=='1')
                answer+="1";
            else
                b++;
        }
        return answer;
    }
}
