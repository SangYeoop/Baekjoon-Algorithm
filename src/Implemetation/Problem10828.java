package Implemetation;

import java.util.Scanner;
import java.util.Stack;

public class Problem10828 {
    public static void run() {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String[] s = sc.nextLine().split(" ");

            if (s[0].equals("push"))
                stack.push(Integer.parseInt(s[1]));
            else if (s[0].equals("top") && !stack.isEmpty())
                System.out.println(stack.peek());
            else if (s[0].equals("top"))
                System.out.println("-1");
            else if (s[0].equals("pop") && !stack.isEmpty())
                System.out.println(stack.pop());
            else if (s[0].equals("pop"))
                System.out.println("-1");
            else if (s[0].equals("size"))
                System.out.println(stack.size());
            else if (s[0].equals("empty") && stack.isEmpty())
                System.out.println("1");
            else if (s[0].equals("empty"))
                System.out.println("0");
        }
    }
}
