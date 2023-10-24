public class Binary_Tree_2 {
    static class Node {
        int data;
        Node right;
        Node left;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }
    
    // Printing tree in Preorder Traversal
    public static void preorder(Node root) {
        if(root == null)
            return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Mirroring the Binary Tree
    public static Node createMirror(Node root) {
        if(root == null)
            return null;
            
        // Mirroring left and right subtrees
        Node leftMirror = createMirror(root.left);
        Node rightMirror = createMirror(root.right);

        // Swapping
        root.left = rightMirror;
        root.right = leftMirror;
        return root;
    }
    
    public static void main(String args[]) {

        /*
                8           |       8
               / \          |      / \
              5  10         |     10  5
             / \   \        |    /   / \
            3   6   11      |   11  6   3
         */

        // Building the Binary tree
        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(10);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right.right = new Node(11);

        // Mirroring the Tree
        createMirror(root);
        preorder(root);
    }   
}
