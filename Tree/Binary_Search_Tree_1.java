import java.util.ArrayList;
public class Binary_Search_Tree_1 {
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
        }
    }

    // Inserting node at the correct position in the B.S.T
    public static Node insert(Node root, int val) {
        if(root == null) {
            root = new Node(val);
            return root;
        }
        if(root.data > val) 
            root.left = insert(root.left, val);
        else 
            root.right = insert(root.right, val);
        return root;
    }

    // Inorder Traversal of B.S.T
    public static void inorder(Node root) {
        if(root == null) 
            return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // Searching the B.S.T
    public static boolean Search(Node root, int key) {
        if(root == null) 
            return false;
        if(root.data == key)
            return true;
        if(root.data > key)
            return Search(root.left, key);
        else
            return Search(root.right, key);
    }

    // Deleting the B.S.T node
    // Utility function to find the Inorder Successor
    public static Node findInorderSuccessor(Node root) {
        while(root.left != null)
            root = root.left;
        return root;
    }

    public static Node delete(Node root, int val) {

        // Searching for the node to be deleted
        if(root.data < val) 
            root.right = delete(root.right, val);
        else if(root.data > val) 
            root.left = delete(root.left, val);
        
        // Node found
        else {

            // Case 1: Leaf Node
            if(root.left == null && root.right == null) 
                return null;

            // Case 2: Single Child
            if(root.left == null) 
                return root.right;

            else if(root.right == null) 
                return root.left;

            // Case 3: Two Child
            Node IS = findInorderSuccessor(root.right);     // Since the successor will be in the right subtree only
            root.data = IS.data;    // Replacing data
            root.right = delete(root.right, IS.data);
        }
        return root;
    }

    // Printing the values lying in a range
    public static void printInRange(Node root, int k1, int k2) {
        if(root == null)
            return;
        
        // Root lying within the range
        if(root.data >= k1 && root.data <= k2) {
            printInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRange(root.right, k1, k2);
        }

        // Root smaller than key -> we need bigger values
        else if(root.data < k1) 
            printInRange(root.right, k1, k2);
        
        // Root bigger than key -> we need smaller values
        else
            printInRange(root.left, k1, k2);

    }

    // Printing Paths from root to leaves
    public static void printPath(ArrayList<Integer> path) {
        for(int i=0; i<path.size(); i++)
            System.out.print(path.get(i) + " -> ");
        System.out.println("Null");
    }

    public static void rootToleaf(Node root, ArrayList<Integer> path) {

        if(root == null)
            return;

        path.add(root.data);

        // Root is a leaf node
        if(root.left == null && root.right == null) 
            printPath(path);

        rootToleaf(root.left, path);
        rootToleaf(root.right, path);

        // Backtracking
        path.remove(path.size()-1);
    }

    // Validate BST
    public static boolean isValidBST(Node root, Node min, Node max) {

        if(root == null)
            return true;

        if(min != null && root.data <= min.data) 
            return false;
        else if(max != null && root.data >= max.data)   
            return false;

        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

    public static void main(String args[]) {

        // Building a Binary Search Tree
        int values[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = null;

        for(int i=0; i<values.length; i++) 
            root = insert(root,values[i]);

        // Printing the Binary Search Tree Inorder Traversal
        System.out.print("Inorder Traversal of the B.S.T:  ");
        inorder(root);

        // Searching the Binary Search Tree
        System.out.println("\nKey found in the Tree: " + Search(root, 10));

        // Deleting node in the Binary Search Tree
        root = delete(root, 5);
        System.out.print("Inorder Traversal of the B.S.T:  ");
        inorder(root);

        // Printing the values lying in a range
        System.out.print("\nValues lying in the range 5 - 12: ");
        printInRange(root, 5, 12);

        // Root to leaf paths
        System.out.println("\nRoot to Leaf Paths: ");
        rootToleaf(root, new ArrayList<Integer>());

        // Validate BST
        if(isValidBST(root, null, null))
            System.out.println("Valid BST");
        else    
            System.out.println("Inalid BST");
    }
}
