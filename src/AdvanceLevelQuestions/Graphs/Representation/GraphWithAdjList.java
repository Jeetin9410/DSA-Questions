package AdvanceLevelQuestions.Graphs.Representation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GraphWithAdjList {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the no of vertices");
        int vertices = scanner.nextInt();

        System.out.println("Enter the no of Edges");
        int edges = scanner.nextInt();

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        System.out.println("Start entering your vertices like this 2 3 which means an edge between them (Undirected Graph)");
        for(int i =0; i < edges; i++) {
            int u,v;
            u = scanner.nextInt();
            v = scanner.nextInt();
            map.putIfAbsent(u, new ArrayList<>());
            map.get(u).add(v);

            map.putIfAbsent(v, new ArrayList<>());
            map.get(v).add(u);
        }

        printAdjList(map);

    }

    public static void printAdjList(HashMap<Integer, ArrayList<Integer>> map) {
        for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
            System.out.print(entry.getKey() + ": ");
            for (int neighbor : entry.getValue()) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
}
