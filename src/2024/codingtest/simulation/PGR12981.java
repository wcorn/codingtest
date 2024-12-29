package codingtest.simulation;

import java.util.*;

public class PGR12981 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"})));
    }
    public static int[] solution(int n, String[] words) {
        List<String> list = new ArrayList<>();
        list.add(words[0]);
        for(int i=1;i<words.length;i++){
            if(list.contains(words[i]) || list.get(list.size()-1).charAt(list.get(list.size()-1).length()-1)!=words[i].charAt(0)){
                return new int[]{(i)%n+1, i/n+1};
            }
            list.add(words[i]);
        }
        return new int[]{0,0};
    }
}
