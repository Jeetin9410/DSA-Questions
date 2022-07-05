package IntermediateLevelQuestions.TreesBasics;

import com.sun.source.tree.Tree;

public class PostorderTraversal {
    
   static class TreeNode{
        int data;
        TreeNode left,right;
      
        TreeNode(int d){
            data = d;
            left = right = null;
        }
    }
    
    TreeNode root;
    
    public static void main(String[] args) {
        PostorderTraversal tree = new PostorderTraversal();

        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(12);
        tree.root.right = new TreeNode(9);
        tree.root.left.left = new TreeNode(5);
        tree.root.left.right = new TreeNode(6);

        tree.postorder(tree.root);
    }

    public void postorder(TreeNode node){
        if(node == null){
            return;
        }

        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data+"--> ");
    }
}
