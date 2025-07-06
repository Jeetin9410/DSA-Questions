package old.AdvanceLevelQuestions.Trees;

import old.AdvanceLevelQuestions.Trees.SampleData.Node;
import old.AdvanceLevelQuestions.Trees.SampleData.RandomTree;

public class Prob1_DisplayGivenTreeLevelWise {

    public static void main(String[] args) {
        Node root = RandomTree.root;
        display(root);
    }

    public static void display(Node root) {
        if(root == null) return;
        System.out.print(root.value + "  -> ");
        if(root.left != null) System.out.print(root.left.value + ", "); else System.out.print("null, ");
        if(root.right != null) System.out.print(root.right.value + " "); else System.out.print(" null");
        System.out.println();
        display(root.left);
        display(root.right);
    }
}
