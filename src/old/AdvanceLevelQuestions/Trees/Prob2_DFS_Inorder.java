package old.AdvanceLevelQuestions.Trees;

import old.AdvanceLevelQuestions.Trees.SampleData.Node;
import old.AdvanceLevelQuestions.Trees.SampleData.RandomTree;

public class Prob2_DFS_Inorder {
    public static void main(String[] args) {
        Node root = RandomTree.root;
        inorder(root);
    }

    public static void inorder(Node root) {
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.value + " ");
        inorder(root.right);
    }
}
