package IntermediateLevelQuestions.TreesBasics;

public class PreorderTraversal {

   static class TreeNode {
        int data;
        TreeNode left,right;

        TreeNode(int d){
            data = d;
            left = right = null;
        }
    }

    TreeNode root;

    public static void main(String[] args) {
        PreorderTraversal tree = new PreorderTraversal();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(12);
        tree.root.right = new TreeNode(9);
        tree.root.left.left = new TreeNode(5);
        tree.root.left.right = new TreeNode(6);

        tree.preorder(tree.root);
    }

    public void preorder(TreeNode node){
        if(node == null){
            return;
        }

        System.out.print(node.data+"--> ");
        preorder(node.left);
        preorder(node.right);
    }
}
