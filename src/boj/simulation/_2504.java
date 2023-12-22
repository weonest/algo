package boj.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _2504 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String bracket = br.readLine();

        int[] p = new int[30];

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < bracket.length(); i++) {
            char cur = bracket.charAt(i);
            if (cur == '(') {
                stack.push(cur);
                continue;
            }
            if (cur == '[') {
                stack.push(cur);
                continue;
            }
            if (cur == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    p[0] = 0;
                    break;
                }
                stack.pop();
                p[stack.size()] += p[stack.size() + 1] == 0 ? 2 : p[stack.size() + 1] * 2;
                p[stack.size() + 1] = 0;
                continue;
            }
            if (cur == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    p[0] = 0;
                    break;
                }
                stack.pop();
                p[stack.size()] += p[stack.size() + 1] == 0 ? 3 : p[stack.size() + 1] * 3;
                p[stack.size() + 1] = 0;
            }
        }
        System.out.println(p[0]);
    }
}
