package Implemetation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    LinkedList<Node> queue;
    int maxWeight;

    Main() {
        queue = new LinkedList<Node>();
        maxWeight = 0;
    }
    void queueSearch() {
        while(true) {
            if (!queue.isEmpty())
                queue.poll().setMaxWeight(this);
            else
                break;
        }
        System.out.println(maxWeight);
    }

    public static void main(String[] args) {
        Main problem = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node[] node = new Node[n + 1];
        for (int i = 1; i <= n; i++)
            node[i] = new Node();
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int island1 = sc.nextInt();
            int island2 = sc.nextInt();
            int pathValue = sc.nextInt();
            node[island1].nodes.add(node[island2]);
            node[island2].nodes.add(node[island1]);
            node[island1].pathValue.add(pathValue);
            node[island2].pathValue.add(pathValue);
        }
        int firstIsland = sc.nextInt();
        int lastIsland = sc.nextInt();
        node[firstIsland].weight = Integer.MAX_VALUE;
        node[lastIsland].isLast = true;
        problem.queue.add(node[firstIsland]);
        problem.queueSearch();
    }
}

class Node{
    ArrayList<Node> nodes;
    ArrayList<Integer> pathValue;
    boolean isSearched;
    boolean isLast;
    int weight;

    Node() {
        weight = 0;
        isSearched = false;
        isLast = false;
        nodes = new ArrayList<Node>();
        pathValue = new ArrayList<Integer>();
    }

    void setMaxWeight(Main problem) {
        if (isLast) {
            if (problem.maxWeight < weight)
                problem.maxWeight = weight;
            return ;
        }
        if (isSearched == false) {
            for (int i = 0; i < nodes.size(); i++) {
                if (weight > pathValue.get(i)) {
                    if (nodes.get(i).weight < pathValue.get(i))
                        nodes.get(i).weight = pathValue.get(i);
                } else {
                    if (nodes.get(i).weight < pathValue.get(i))
                        nodes.get(i).weight = pathValue.get(i);
                }
                problem.queue.add(nodes.get(i));
            }
            isSearched = true;
        }
    }
}