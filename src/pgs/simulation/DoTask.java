package pgs.simulation;

import java.util.*;

public class DoTask {

    class Task implements Comparable<Task> {
        String name;
        int start, playtime;

        Task(String name, int start, int playtime) {
            this.name = name;
            this.start = start;
            this.playtime = playtime;
        }

        @Override
        public int compareTo(Task t) {
            return this.start - t.start;
        }
    }


    public String[] solution(String[][] plans) {

        String[] answer = new String[plans.length];

        PriorityQueue<Task> q = new PriorityQueue<>();
        for (String[] plan : plans) {
            q.add(new Task(plan[0], parseTime(plan[1]), Integer.parseInt(plan[2])));
        }

        Task t = q.poll();
        int now = t.start;
        int idx = 0;
        Deque<Task> stop = new ArrayDeque<>();

        while (true) {
            if (!q.isEmpty() && now + t.playtime > q.peek().start) {
                stop.push(new Task(t.name, t.start, t.playtime - (q.peek().start - now)));
                now = q.peek().start;
                t = q.poll();
            } else {
                answer[idx++] = t.name;
                now += t.playtime;
                if (!q.isEmpty() && now == q.peek().start) {
                    t = q.poll();
                } else if (!stop.isEmpty()) {
                    t = stop.pop();
                } else if (!q.isEmpty()) {
                    t = q.poll();
                    now = t.start;
                } else break;
            }
        }

        return answer;
    }

    public int parseTime(String time) {
        String[] tmp = time.split(":");
        int h = Integer.parseInt(tmp[0]) * 60;
        int m = Integer.parseInt(tmp[1]);
        return h + m;
    }

    public static void main(String[] args) {
        DoTask d = new DoTask();
        System.out.println(Arrays.toString(d.solution(new String[][]{{"korean", "11:40", "30"}, {"korean2", "12:10", "20"}, {"korean3", "12:30", "40"}})));
    }
}
