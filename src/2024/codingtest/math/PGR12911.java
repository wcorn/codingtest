package codingtest.math;

public class PGR12911 {
    public static void main(String[] args) {
        System.out.println(solution(78));
    }
    public static int solution(int n) {
        int bin = cnt(n);
        while(true){
            n++;
            if(bin==cnt(n))
                return n;
        }
    }
    public static int cnt(int num){
        char[] ch = Integer.toString(num,2).toCharArray();
        int count=0;
        for(int i=0;i<ch.length;i++){
            if(ch[i]=='1')
                count++;
        }
        return count;
    }
}
