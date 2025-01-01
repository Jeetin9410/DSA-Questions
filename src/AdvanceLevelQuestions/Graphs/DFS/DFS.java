package AdvanceLevelQuestions.Graphs.DFS;

import java.util.ArrayList;
import java.util.Arrays;

public class DFS {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        adj.add(new ArrayList<>(Arrays.asList(2, 3, 1)));
        adj.add(new ArrayList<>(Arrays.asList(0)));
        adj.add(new ArrayList<>(Arrays.asList(0, 4)));
        adj.add(new ArrayList<>(Arrays.asList(0)));
        adj.add(new ArrayList<>(Arrays.asList(2)));

        boolean[] isVisited = new boolean[adj.size()];

        ArrayList<Integer> ans = new ArrayList<>();

        performDFS(adj, isVisited, 0, ans);

        System.out.println(ans.toString());
    }

    public static void performDFS(ArrayList<ArrayList<Integer>> adjList, boolean[] isVisited, int node, ArrayList<Integer> ans) {
        isVisited[node] = true;
        ans.add(node);   // Either you print it here

        for( int i : adjList.get(node)) {
            if(!isVisited[i]){
                performDFS(adjList, isVisited, i, ans);
            }
        }
    }
}
