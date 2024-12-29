package codingtest.string;

public class BOJ12951 {
    public static void main(String[] args) {
        System.out.println(solution("3people unFollowed me"));
    }
    public static String solution(String s) {
        String answer = "";
        String[] arr = s.split(" ");
        for(int i=0;i<arr.length;i++){
            if(arr[i].length() != 0) {
                answer+=arr[i].substring(0,1).toUpperCase();
                answer+=arr[i].substring(1).toLowerCase();
            }
            answer+=" ";
        }
        if(s.substring(s.length()-1).equals(" ")){
            return answer;
        }
        return answer.substring(0, answer.length()-1);
    }
}
