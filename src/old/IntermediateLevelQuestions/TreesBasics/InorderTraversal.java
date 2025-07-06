package old.IntermediateLevelQuestions.TreesBasics;

public class InorderTraversal {
   static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int d){
            data = d;
            left = right = null;
        }
    }

    TreeNode root;

    public static void main(String[] args) {

        InorderTraversal tree = new InorderTraversal();

        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(12);
        tree.root.right = new TreeNode(9);
        tree.root.left.left = new TreeNode(5);
        tree.root.left.right = new TreeNode(6);

        tree.inorder(tree.root);

    }

    public void inorder(TreeNode node){
        if(node == null){
            return;
        }

        inorder(node.left);
        System.out.print(node.data+" -->");
        inorder(node.right);
    }
}
