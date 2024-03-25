package pgs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class PlantAndWater {

    private static class Plant {
        int day;
        int left;
        int idx;

        public Plant(int day, int left, int idx) {
            this.day = day;
            this.left = left;
            this.idx = idx;
        }

        @Override
        public String toString() {
            return "[" + day + " ," + left + " ," + idx + "]\n";
        }
    }

    private static int[] answer;

    public static int solution(int[] plants, int[] waters) {
        answer = new int[waters.length];
        PriorityQueue<Plant> pq = new PriorityQueue<>(((o1, o2) -> {
            if (o1.left == o2.left) {
                return o1.day - o2.day;
            }
            return o1.left - o2.left;
        }));

        Map<Integer, Integer> cache = new HashMap<>();

        for (int i = 0; i < plants.length; i++) {
            pq.add(new Plant(plants[i], plants[i], i + 1));
        }

        for (int i = 0; i < waters.length; i++) {
            boolean give = false;
            while (!pq.isEmpty()) {

                if (pq.peek().left > i + 1) break;
                Plant plant = pq.poll();

                if (plant.idx == waters[i]) {
                    pq.add(new Plant(plant.day, plant.left + plant.day, plant.idx));
                    give = true;
                    continue;
                }

                if (cache.containsKey(plant.idx)) {
                    pq.add(new Plant(plant.day, cache.get(plant.idx) + plant.day, plant.idx));
                    cache.remove(plant.idx);
                }
            }
            if (!give) {
                cache.put(waters[i], i + 1);
            }
            answer[i] = pq.size();
        }
        return Arrays.stream(answer).max().getAsInt();
    }

    public static void main(String[] args) {
        System.out.println("solution = " + solution(new int[]{2, 4, 1, 2}, new int[]{3, 1, 2, 1, 4, 1}));
    }

}
