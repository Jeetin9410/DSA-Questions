package old.AdvanceLevelQuestions.Trees;

import old.AdvanceLevelQuestions.Trees.SampleData.Node;
import old.AdvanceLevelQuestions.Trees.SampleData.RandomTree;

public class Prob2_DFS_PreOrder {
    public static void main(String[] args) {
        Node root = RandomTree.root;
        preorder(root);
    }

    public static void preorder(Node root) {
        if(root == null) return;
        System.out.print(root.value + " ");
        preorder(root.left);
        preorder(root.right);
    }
}
