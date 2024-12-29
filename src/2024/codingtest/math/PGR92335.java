package codingtest.math;

public class PGR92335 {
    public static void main(String[] args){
        int n = 437674;
        int k = 3;
        System.out.println(solution(n,k));
    }
    public static int solution(int n, int k) {
        int answer = 0;
        String kNum = "";
        while(n!=0){
            kNum=n%k+kNum;
            n/=k;
        }
        String[] arr = kNum.split("0");
        for(int i=0;i<arr.length;i++){
            if(arr[i].equals(""))
                continue;
            long num = Long.parseLong(arr[i]);
            if(isPrime(num))
                answer++;
        }
        return answer;
    }
    public static boolean isPrime(long num){
        if(num<2) return false;
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i==0)
                return false;
        }
        return true;
    }
}
