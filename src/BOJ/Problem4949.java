package BOJ;

import java.util.Scanner;
import java.util.Stack;

public class Problem4949 {
    public static void run() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            Stack<Character> stack = new Stack<>();
            String s = sc.nextLine();
            if (s.charAt(0) == '.')
                break;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(' || s.charAt(i) == '[')
                    stack.push(s.charAt(i));
                else if (s.charAt(i) == ')') {
                    if (!stack.isEmpty() && stack.pop() == '(')
                        continue;
                    else {
                        stack.push('1');
                        break;
                    }
                } else if (s.charAt(i) == ']') {
                    if (!stack.isEmpty() && stack.pop() == '[')
                        continue;
                    else {
                        stack.push('1');
                        break;
                    }
                }
            }
            if (stack.isEmpty())
                System.out.println("yes");
            else
                System.out.println("no");
        }
    }
}
