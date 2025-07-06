package old.AdvanceLevelQuestions.Trees;

import old.AdvanceLevelQuestions.Trees.SampleData.Node;
import old.AdvanceLevelQuestions.Trees.SampleData.RandomTree;

public class Prob3_DFS_PostOrder {
    public static void main(String[] args) {
        Node root = RandomTree.root;
        postOrder(root);
    }

    public static void postOrder(Node root) {
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.value+ " ");
    }
}
