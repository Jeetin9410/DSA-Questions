package AdvanceLevelQuestions.Graphs.BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        adj.add(new ArrayList<>(Arrays.asList(2, 3, 1)));
        adj.add(new ArrayList<>(Arrays.asList(0)));
        adj.add(new ArrayList<>(Arrays.asList(0, 4)));
        adj.add(new ArrayList<>(Arrays.asList(0)));
        adj.add(new ArrayList<>(Arrays.asList(2)));

        // adj = [[2,3,1], [0], [0,4], [0], [2]]

        ArrayList<Integer> ans = BFSAlgo(0, adj);

        System.out.println(ans.toString());
    }

    public static ArrayList<Integer> BFSAlgo(int startingNode, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> res = new ArrayList<>();

        //Need a visited Array
        boolean[] isVisited = new boolean[adj.size()];

        Queue<Integer> q = new LinkedList<>();

        isVisited[startingNode] = true;
        q.add(startingNode);

        while (!q.isEmpty()) {
            int curr = q.poll();
            res.add(curr);
            for(int i: adj.get(curr)) {
                if(!isVisited[i]) {
                    isVisited[i] = true;
                    q.add(i);
                }
            }

        }

        return  res;
    }
}
