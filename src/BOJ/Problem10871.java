package BOJ;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Problem10871 {

    ArrayList<Integer> list;
    Integer offset;

    Problem10871(int listSize, int offset) {
        list = new ArrayList<>(listSize);
        this.offset = offset;
    }

    private void setListValue(Scanner sc, int listSize) {
        for (int i = 0; i < listSize; i++) {
            int value = sc.nextInt();
            list.add(value);
        }
    }

    private void printLowerNumber() {
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            int num = (int) iter.next();
            if (num < offset)
                System.out.print(num + " ");
        }
    }

    public static void run() {
        Scanner sc = new Scanner(System.in);
        int listSize = sc.nextInt();
        int offset = sc.nextInt();

        Problem10871 problem = new Problem10871(listSize, offset);
        problem.setListValue(sc, listSize);
        problem.printLowerNumber();
    }
}
