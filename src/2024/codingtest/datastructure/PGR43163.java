package codingtest.datastructure;

import java.util.*;

public class PGR43163 {

    public static void main(String[] args) {
        System.out.println(solution("hit",	"cog",new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
    }
    public static int solution(String begin, String target, String[] words) {
        int answer = 0;
        Queue<String> q = new LinkedList<>();
        Set<String> set = new HashSet<>(Arrays.asList(words));
        q.add(begin);
        set.remove(begin);
        if(!set.contains(target)){
            return 0;
        }
        String temp;
        while(!q.isEmpty()){
            for(int i=0;i<q.size();i++){
                temp = q.poll();
                if(temp.equals(target))
                    return answer;
                for(String str : set.toArray(new String[set.size()])){
                    if(check(temp, str)){
                        q.offer(str);
                        set.remove(str);
                    }
                }
            }
            answer++;
        }
        return answer;
    }
    public static boolean check(String w1, String w2){
        int cnt = 0;
        for(int i=0;i<w1.length();i++){
            if(w1.charAt(i)!=w2.charAt(i))
                cnt++;
        }
        return cnt==1;
    }
}
