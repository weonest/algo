package pgs.heap;


import java.util.*;


public class DoublePriorityQueue {

    public static int[] solution(String[] operations) {
        int[] answer = new int[2];

        PriorityQueue<Integer> tq = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> lq = new PriorityQueue<>();

        for (String input : operations) {
            String[] operation = input.split(" ");
            String command = operation[0];
            int value = Integer.parseInt(operation[1]);

            if (command.equals("I")) {
                tq.offer(value);
                lq.offer(value);
                continue;
            }

            if (!command.equals("D")) continue;

            if (value == 1) {
                lq.remove(tq.poll());
            } else {
                tq.remove(lq.poll());
            }
        }

        if (tq.size() == 0) {
            return new int[]{0, 0};
        }
        answer[0] = tq.poll();
        answer[1] = lq.poll();
        return answer;
    }

    static List<Integer> list = new ArrayList<>();

    public static int[] solution2(String[] operations) {
        int[] answer = new int[2];

        for (int i = 0; i < operations.length; i++) {
            String[] command = operations[i].split(" ");

            switch(command[0]){
                case "I" : insert(Integer.valueOf(command[1]));
                    break;
                case "D" : delete(command[1]);
                    break;
            }
        }

        if (!list.isEmpty()) {
            answer[0] = list.get(list.size() - 1);
            answer[1] = list.get(0);
        }

        return answer;
    }

    private static void insert(int num) {
        list.add(num);
        if (list.size() > 0) Collections.sort(list);
    }

    private static void delete(String command) {
        if (list.isEmpty()) return;

        if (command.equals("1")) {
            list.remove(list.size() - 1);
        } else {
            list.remove(0);
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"})));
        System.out.println(Arrays.toString(solution2(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"})));
    }
}
