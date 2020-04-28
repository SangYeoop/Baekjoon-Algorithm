package BOJ;

import java.util.Scanner;

public class Problem9498{

    private int score;

    private void setScore(int score){
        this.score = score;
    }

    private void printGrade()
    {
        if (score >= 90 && score <= 100)
            System.out.println("A");
        else if (score >= 80 && score <= 89)
            System.out.println("B");
        else if (score >= 70 && score <= 79)
            System.out.println("C");
        else if (score >= 60 && score <= 69)
            System.out.println("D");
        else if (score < 60)
            System.out.println("F");
    }

    public static void run()
    {
        Scanner sc = new Scanner(System.in);
        int score = sc.nextInt();
        Problem9498 problem = new Problem9498();
        problem.setScore(score);
        problem.printGrade();
    }
}
