package BOJ;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Problem1874 {
    public static void run() {
        Stack<Integer> stack = new Stack<>();
        LinkedList<Character> queue = new LinkedList<>();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int currentMaxValue = 0;
        int i = 1;
        while(true) {
            int num = sc.nextInt();
            if (num > currentMaxValue) {
                currentMaxValue = num;
                while (i <= num) {
                    stack.push(i);
                    queue.add('+');
                    i++;
                }
                queue.add('-');
                stack.pop();
            }
            if (num < currentMaxValue) {
                if (stack.peek() == num) {
                    queue.add('-');
                    stack.pop();
                }else {
                    System.out.println("NO");
                    break;
                }
            }
            if (queue.size() == n * 2){
                while(!queue.isEmpty())
                    System.out.println(queue.poll());
                break;
            }
        }
    }
}
