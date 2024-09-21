package pgs.dfs;

import java.util.*;

// 여행 경로
public class TravelRoute {

    static Map<String, Queue<String>> graph = new HashMap<>();
    static List<String> answer = new ArrayList<>();

    public static String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (o1, o2) -> o1[1].compareTo(o2[1]));

        for (String[] ticket: tickets) {
            String dep = ticket[0];
            String des = ticket[1];

            graph.computeIfAbsent(dep, k -> new LinkedList<>()).add(des);
        }
        dfs("ICN");
        Collections.reverse(answer);
        return answer.toArray(new String[0]);
    }

    private static void dfs(String dep) {
        while(graph.containsKey(dep) && !graph.get(dep).isEmpty()) {
            dfs(graph.get(dep).poll());
        }
        answer.add(dep);
    }

    static boolean[] visited;

    public static String[] solution2(String[][] tickets) {
        visited = new boolean[tickets.length];
        Arrays.sort(tickets, (o1, o2) -> o1[1].compareTo(o2[1]));
        dfs2("ICN", "ICN", tickets, 0);
        return answer.get(0).split(" ");
    }

    private static void dfs2(String start, String route, String[][] tickets, int cnt) {
        if (cnt == tickets.length) {
            answer.add(route);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(start)) {
                visited[i] = true;
                dfs2(tickets[i][1], route + " " + tickets[i][1], tickets, cnt + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}})));
        answer.clear();
        System.out.println(Arrays.toString(solution2(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}})));
    }
}
