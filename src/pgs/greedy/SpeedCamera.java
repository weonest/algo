package pgs.greedy;

import java.util.*;

public class SpeedCamera {

    public int solution(int[][] routes) {
        int answer = 1;

        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);

        System.out.println(Arrays.deepToString(routes));

        int end = routes[0][1];
        for (int i = 1; i < routes.length; i++) {
            int curStart = routes[i][0];
            int curEnd = routes[i][1];

            if (end >= curStart && end <= curEnd) {
                continue;
            } else {
                answer++;
                end = curEnd;
            }
        }
        return answer;
    }

}
