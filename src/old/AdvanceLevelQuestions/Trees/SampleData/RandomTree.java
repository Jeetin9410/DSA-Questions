package old.AdvanceLevelQuestions.Trees.SampleData;

public class RandomTree {
    /*
                                  1
                     2                              3
             4                 5              6              7
         8       null     null     9    null     10    null        11

     */
    public static Node root;

    static {
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        root.left.left.left = new Node(8);
        root.left.right.right = new Node(9);

        root.right.left.right = new Node(10);
        root.right.right.right = new Node(11);
    }

    public static void main(String[] args) {

        // Issue with this is, main() will execute when you run this file.
        // so need to write this code in static block.
        /* root = new Node(1);
         root.left = new Node(2);
         root.right = new Node(3);

         root.left.left = new Node(4);
         root.left.right = new Node(5);

         root.right.left = new Node(6);
         root.right.right = new Node(7);

        root.left.left.left = new Node(8);
        root.left.right.right = new Node(9);

        root.right.left.right = new Node(10);
        root.right.right.right = new Node(11);*/
    }
}
