package boj.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

// 연산자 끼워넣기
public class _14888 {
    static int N;

    static Deque<Integer> operand = new ArrayDeque<>();

    static Map<String, Integer> operatorMap = new LinkedHashMap<>();

    static String[] operator; //4개

    static String[] operators; // 순열 연산자

    static boolean[] visit;

    static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            operand.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        int plus = Integer.parseInt(st.nextToken());
        int minus = Integer.parseInt(st.nextToken());
        int multiply = Integer.parseInt(st.nextToken());
        int divide = Integer.parseInt(st.nextToken());

        operatorMap.put("+", plus);
        operatorMap.put("-", minus);
        operatorMap.put("*", multiply);
        operatorMap.put("%", divide);

        int operatorSize = plus + minus + multiply + divide;
        operator = new String[operatorSize];
        visit = new boolean[operatorSize];

        int idx = 0;
        for (String key : operatorMap.keySet()) {
            int cur = operatorMap.get(key);
            while (idx != operatorSize) {
                if (cur == 0) break;
                if (cur != 0) {
                    operator[idx] = key;
                    cur--;
                }
                idx++;
            }
        }

        operators = new String[operatorSize];

        permutation(operators, 0, operatorSize);

        Collections.sort(answer);
        System.out.println(answer.get(answer.size()-1));
        System.out.println(answer.get(0));

    }

    static void permutation(String[] operators, int depth, int r) {
        if (depth == r) {
            Deque<Integer> operandCopy = new ArrayDeque<>(operand);
            calcualte(operandCopy, operators);
            return;
        }

        for (int i = 0; i < operator.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                operators[depth] = operator[i];
                permutation(operators, depth + 1, r);
                visit[i] = false;
            }
        }
    }

    static void calcualte(Deque<Integer> operand, String[] operators) {
        for (int i = 0; i < operators.length; i++) {
            int val1 = operand.pop();
            int val2 = operand.pop();
            int calculated = 0;
            String operator = operators[i];

            switch (operator) {
                case "+" : calculated = val1 + val2;
                break;
                case "-" : calculated = val1 - val2;
                break;
                case "*" : calculated = val1 * val2;
                break;
                case "%" : calculated = val1 > 0 ? val1 / val2 : -(Math.abs(val1) / val2);
                break;
            }
            operand.push(calculated);
        }
        answer.add(operand.peek());
    }

}

//package implement;
//
//import java.util.Arrays;
//import java.util.Scanner;
//
//public class BOJ14888 {
//
//static int N;
//static int[] E;
//static int[] O = new int[4];
//
//static int MAX = Integer.MIN_VALUE;
//static int MIN = Integer.MAX_VALUE;
//
//public static void main(String[] args) {
//Scanner sc = new Scanner(System.in);
//N = sc.nextInt();
//sc.nextLine();
//E = new int[N];
//E = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//O = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//makeValue(0, E[0]);
//System.out.println(MAX);
//System.out.println(MIN);
//
//}
//
//public static void makeValue(int index, int value) {
//if (index +1 == N) {
//MAX = Math.max(MAX, value);
//MIN = Math.min(MIN, value);
//return;
//}
//
//for (int i = 0; i < 4; i++) {
//if (O[i] != 0) {
//O[i]--;
//switch (i) {
//case 0:
//makeValue(index + 1, value + E[index + 1]);
//break;
//case 1:
//makeValue(index + 1, value - E[index + 1]);
//break;
//case 2:
//makeValue(index + 1, value * E[index + 1]);
//break;
//case 3:
//makeValue(index + 1, value / E[index + 1]);
//}
//O[i]++;
//}
//
//}
//
//}
//
//}