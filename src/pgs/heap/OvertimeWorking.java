package pgs.heap;

import java.util.*;


public class OvertimeWorking {

    public long solution(int n, int[] works) {
        long answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int v : works) {
            pq.offer(v);
        }

        for (int i = 0; i < n; i++) {
            int work = pq.poll();
            if (work == 0) break;

            pq.offer(work - 1);
        }

        while (!pq.isEmpty()) {
            answer += Math.pow(pq.poll(), 2);
        }

        return answer;
    }

}
