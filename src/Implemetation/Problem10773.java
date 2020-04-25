package Implemetation;

import java.util.Scanner;
import java.util.Stack;

public class Problem10773 {
    public static void run() {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(sc.nextLine());
            if (m > 0)
                stack.push(m);
            else if (m == 0)
                stack.pop();
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        System.out.println(sum);
    }
}
