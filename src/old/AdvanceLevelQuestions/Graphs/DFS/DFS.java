package old.AdvanceLevelQuestions.Graphs.DFS;

import java.util.ArrayList;
import java.util.Arrays;

/*
   Link : https://www.youtube.com/watch?v=Qzf1a--rhp8&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=7&ab_channel=takeUforward
 */

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
