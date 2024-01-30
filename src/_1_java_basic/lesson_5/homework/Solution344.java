package _1_java_basic.lesson_5.homework;

import java.util.Stack;

public class Solution344 {

    public static char[] input = new char[]{'h', 'e', 'l', 'l', 'o'};

    public static void main(String[] args) {
        Solution344 solution = new Solution344();
        solution.reverseString3(input);
    }

    public void reverseString1(char[] s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s) {
            stack.push(c);
        }
        for (int i = 0; i < s.length; ++i) {
            s[i] = stack.pop();
        }
        System.out.println(s);
    }

    public void reverseString2(char[] s) {
        char temp;
        int cntDown = s.length - 1;

        for (int i = 0; i < s.length / 2; i++) {
            temp = s[cntDown];
            s[cntDown] = s[i];
            s[i] = temp;
            cntDown--;
        }

        System.out.println(s);
    }

    public void reverseString3(char[] s) {
        char temp = ' ';
        int begin = 0;
        int finish = s.length - 1;

        while (begin < finish) {
            temp = s[finish];
            s[finish] = s[begin];
            s[begin] = temp;
            begin++;
            finish--;
        }

        System.out.println(s);
    }
}
