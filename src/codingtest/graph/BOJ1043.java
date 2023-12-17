package codingtest.graph;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class BOJ1043 {
    private static int N;
    private static int M;
    private static List<Person> list;
    private static List<List<Integer>> partyList;
    private static int result;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        list = new ArrayList<>();
        partyList = new ArrayList<>();
        result = 0;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int purpose;
        for (int i = 0; i <= N; i++) {
            list.add(new Person(i));
        }
        purpose = Integer.parseInt(st.nextToken());
        for (int i = 0; i < purpose; i++) {
            list.get(Integer.parseInt(st.nextToken())).know = true;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            List<Integer> person = new ArrayList<>();
            purpose = Integer.parseInt(st.nextToken());
            for (int j = 0; j < purpose; j++) {
                person.add(Integer.parseInt(st.nextToken()));
            }
            for (int j = 0; j < purpose; j++) {
                Person p = list.get(person.get(j));
                for (int k = 0; k < purpose; k++) {
                    if (j == k)
                        continue;
                    p.knownPerson.add(list.get(person.get(k)));
                }
            }
            partyList.add(person);
        }
        for (int i = 1; i <= N; i++) {
            list.get(i).knownPerson = list.get(i).knownPerson.stream().distinct().collect(Collectors.toList());
        }
        solve();
        System.out.println(M - result);
    }

    private static void solve() {
        for (int i = 1; i <= N; i++) {
            if (!list.get(i).know)
                continue;
            visited = new boolean[N + 1];
            Person p = list.get(i);
            dfs(p);
        }
        List<Integer> party;
        for (int i = 0; i < M; i++) {
            party = partyList.get(i);
            for (int j = 0; j < party.size(); j++) {
                if (list.get(party.get(j)).know) {
                    result++;
                    break;
                }
            }
        }
    }

    private static void dfs(Person p) {
        List<Person> edges = p.knownPerson;
        Person e;
        visited[p.num] = true;
        p.know = true;
        for (int i = 0; i < edges.size(); i++) {
            e = edges.get(i);
            if (visited[e.num])
                continue;
            dfs(e);
        }
    }

    private static class Person {
        int num;
        boolean know;
        List<Person> knownPerson;

        public Person(int num) {
            this.num = num;
            this.know = false;
            this.knownPerson = new LinkedList<>();
        }
    }
}