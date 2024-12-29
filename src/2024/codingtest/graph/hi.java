package codingtest.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class hi {
    public static void main(String[] args){
        List<String> strings = new ArrayList<>();
        strings.add("a");
        strings.add("b");
        strings.add("c");
        dangerous(strings);
    }
    static void dangerous(List<String>... stringLists){
        List<Integer> intList = List.of(42);
        Object[] objects = stringLists;
        System.out.println(stringLists[0]);
        System.out.println(objects[0]);
        stringLists[0].add("1");
        System.out.println(stringLists[0]);
        System.out.println(objects[0]);
        objects[0] = intList;                  //힙 오염 발생
//        String s = stringLists[0].get(0);      //ClassCastException
    }
}
