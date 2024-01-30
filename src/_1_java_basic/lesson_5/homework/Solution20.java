package _1_java_basic.lesson_5.homework;

import java.util.Stack;

public class Solution20 {

    public static String str = "([])";

    public static void main(String[] args) {
        Solution20 sol = new Solution20();
        System.out.println(sol.isValid(str));
    }

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        boolean check = true;

        for (int i = 0; i < s.length(); i++) {
            char ch1 = s.charAt(i);

            if (("([{").contains(String.valueOf(ch1))) {
                stack.push(ch1);
            } else {
                char ch2;
                if (stack.isEmpty()) {
                    return false;
                } else {
                    ch2 = stack.peek();
                    if (ch2 == '(' && ch1 == ')' ||
                            ch2 == '[' && ch1 == ']' ||
                            ch2 == '{' && ch1 == '}') {
                        stack.pop();
                    } else {
                        check = false;
                    }
                }
            }
        }

        return stack.isEmpty() && check;
    }
}
