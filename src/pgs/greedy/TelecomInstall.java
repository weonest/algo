package pgs.greedy;

// 기지국 설치
public class TelecomInstall {

    public int solution(int n, int[] stations, int w) {
        int answer = 0, sectionLength;
        for (int i = 0; i <= stations.length; i++) {
            if (i == 0) {
                sectionLength = stations[i] - 1 - w;
            } else if (i == stations.length) {
                sectionLength = n - stations[i - 1] - w;
            } else {
                sectionLength = stations[i] - stations[i - 1] - 2 * w - 1;
            }

            if (sectionLength >= 0) {
                answer += sectionLength / (2 * w + 1);

                if (sectionLength % (2 * w + 1) != 0) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
