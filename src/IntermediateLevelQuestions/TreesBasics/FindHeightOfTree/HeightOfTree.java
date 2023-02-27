package IntermediateLevelQuestions.TreesBasics.FindHeightOfTree;

public class HeightOfTree {

    static class Node{
        int data;
        Node left,right;

        Node(int d){
            data=d;
            left = null;
            right = null;
        }
    }

    Node root;

    public static void main(String[] args) {

        HeightOfTree tree = new HeightOfTree();

        tree.root = new Node(1);

        Node node2 = new Node(2);
        Node node3 = new Node(3);

        tree.root.left = node2;
        tree.root.right = node3;

        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        node2.left = node4;
        node2.right = node5;

        node3.right = node6;

        Node node7 = new Node(7);
        Node node8 = new Node(8);

        node5.right = node7;

        node7.right = node8;

        System.out.println("Height of tree is : "+(maxDepth(tree.root)));
    }

    public static int maxDepth(Node n) {
        if (n == null) {
            return -1;
        } else {

            return 1 + Math.max(maxDepth(n.left), maxDepth(n.right));
        }
    }

}
