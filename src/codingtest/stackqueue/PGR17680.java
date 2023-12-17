package codingtest.stackqueue;

import java.util.*;

public class PGR17680 {
    public static void main(String[] args) {
        int cacheSize = 2;
        String[] cities = {"Jeju", "Pangyo", "NewYork", "newyork"};
        System.out.println(solution(cacheSize, cities));
    }

    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> cache = new LinkedList<>();
        String value;
        for (int i = 0; i < cities.length; i++) {
            value = cities[i].toLowerCase();
            if(cache.contains(value)){
                cache.remove(value);
                cache.offer(value);
                answer+=1;
            }
            else {
                cache.add(value);
                if(cache.size()>cacheSize)
                    cache.poll();
                answer+=5;
            }
        }
        return answer;
    }
}
