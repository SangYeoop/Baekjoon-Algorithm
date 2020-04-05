package Implemetation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Problem1939 {
    private LinkedList<Node> queue;
    private int maxWeight;
    private int factory1;
    private int factory2;

    public static void run() {
        Problem1939 problem = new Problem1939();
        Scanner sc = new Scanner(System.in);
        int nodeNum = sc.nextInt();
        int pathNum = sc.nextInt();
        int[][] paths = new int[pathNum][3];

        for (int i = 0; i < pathNum; i++) {
            for (int j = 0; j < 3; j++) {
                paths[i][j] = sc.nextInt();
            }
        }
        problem.factory1 = sc.nextInt();
        problem.factory2 = sc.nextInt();
    }

    class Node {
        ArrayList<Node> nextNodes;
        boolean isSearched;
        boolean isFactory;
        int pathValue;
        int weight;

        Node (boolean isFactory) {
            this.isFactory = isFactory;
        }

        Node(ArrayList<Node> nextNodes, boolean isFactory) {
            this.nextNodes = nextNodes;
            this.isFactory = isFactory;
            isSearched = false;
            pathValue = 0;
            weight = 0;
        }

        void setMaxWeight() {
            if (isFactory == true)
                isSearched = true;
            if (isSearched == true)
                return;
            for (int i = 0; i < nextNodes.size(); i++) {
                Node node = nextNodes.get(i);
                int nextNodeWeight = weight;
                if(node.pathValue < weight) {
                    nextNodeWeight = node.pathValue;
                }
                maxWeight = nextNodeWeight;
                queue.add(node);
            }
            isSearched = true;
        }
    }
}

