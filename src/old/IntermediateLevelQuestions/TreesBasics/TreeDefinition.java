package old.IntermediateLevelQuestions.TreesBasics;

public class TreeDefinition {
   static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int d){
            data = d;
            left = null;
            right = null;
        }
    }

    TreeNode root;


    public static void main(String[] args) {

        TreeDefinition tree = new TreeDefinition();

        tree.root = new TreeNode(1);


        // A Tree with single node is created here.



    }
}
