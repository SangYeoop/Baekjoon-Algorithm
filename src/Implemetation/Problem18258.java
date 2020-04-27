package Implemetation;

import java.io.*;
import java.util.LinkedList;

public class Problem18258 {
    public static void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");

            if (s[0].equals("push"))
                queue.offer(Integer.parseInt(s[1]));
            else if (s[0].equals("pop")) {
                if (queue.isEmpty())
                    bw.write("-1\n");
                else
                    bw.write(String.valueOf(queue.poll()) + "\n");
            } else if (s[0].equals("front")) {
                if (queue.isEmpty())
                    bw.write("-1\n");
                else
                    bw.write(String.valueOf(queue.peek()) + "\n");
            } else if (s[0].equals("size")) {
                bw.write(String.valueOf(queue.size()) + "\n");
            } else if (s[0].equals("empty")) {
                if (queue.isEmpty())
                    bw.write("1\n");
                else
                    bw.write("0\n");
            } else if (s[0].equals("back")) {
                if (queue.isEmpty())
                    bw.write("-1\n");
                else
                    bw.write(String.valueOf(queue.getLast()) + "\n");
            }
        }
        bw.flush();
    }
}
