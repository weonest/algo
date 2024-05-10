package pgs.binary_search;

// 징검다리 건너기
public class SteppingStones {

    public int solution(int[] stones, int k) {
        int answer = 0;

        int min = 1;
        int max = 200_000_000;

        while(min < max) {
            int mid = (min + max) / 2;

            if (canAcross(k, stones, mid)) {
                min = mid + 1;
                answer = Math.max(answer, mid);
            } else {
                max = mid;
            }
        }

        return answer;
    }

    private boolean canAcross(int k, int[] stones, int mid) {
        int skip = 0;

        for (int stone : stones) {
            if (stone - mid < 0) {
                skip++;
            } else {
                skip = 0;
            }
            if (skip == k) {
                return false;
            }
        }
        return true;
    }
}
