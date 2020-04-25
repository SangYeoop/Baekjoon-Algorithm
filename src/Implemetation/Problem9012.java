package Implemetation;

import java.util.Scanner;
import java.util.Stack;

public class Problem9012 {
    public static void run() {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            Stack<Integer> stack = new Stack<>();
            String s = sc.nextLine();
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '(')
                    stack.push(1);
                else if (s.charAt(j) == ')' && !stack.isEmpty())
                    stack.pop();
                else {
                    stack.push(2);
                    break;
                }
            }
            if (stack.isEmpty())
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
