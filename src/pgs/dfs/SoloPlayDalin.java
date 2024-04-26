package pgs.dfs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// 혼자 놀기의 달인
public class SoloPlayDalin {

    boolean[] visited;
    int cnt = 0;

    public int solution(int[] cards) {

        visited = new boolean[cards.length];

        List<Integer> cntList = new ArrayList<>();

        for (int i = 0; i < cards.length; i++) {
            if (visited[i]) continue; // 첫 번째 카드를 뽑는다. 방문했다면 다음 카드가 첫 번재 카드
            cnt = 1; // 위 조건에서 유효한 카드만을 뽑기 때문에 cnt = 1로 설정
            visited[i] = true;
            recursive(cards, cards[i] - 1);
            cntList.add(cnt);
        }
        System.out.println("cntList = " + cntList);

        cntList.sort(Comparator.reverseOrder());

        if (cntList.size() < 2) {
            return 0;
        } else {
            return cntList.get(0) * cntList.get(1);
        }
    }

    public void recursive(int[] cards, int idx) {
        if (visited[idx]) return;

        visited[idx] = true;
        cnt++;
        recursive(cards, cards[idx] - 1);
    }

    public static void main(String[] args) {
        int[] ex = {2, 3, 1, 4, 5, 6};
        SoloPlayDalin sol = new SoloPlayDalin();
        sol.solution(ex);
    }

}
