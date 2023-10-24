import java.util.*;
import java.util.LinkedList;
// Implementing Binary Tree and basic functions
public class Binary_Tree {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }

    // Storing information for diameter calculation
    static class Info {
        int height;
        int diameter;

        Info(int height, int diameter) {
            this.diameter = diameter;
            this.height = height;
        }
    }

    // Class implementing basic functions of tree
    static class BinaryTree {

        static int index = -1;

        public static Node buildTree(int nodes[]) {

            index++;

            if(nodes[index] == -1)
                return null;

            Node newNode = new Node(nodes[index]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        // Printing tree in preorder Sequence -> O(n)
        public static void preorder(Node root) { 

            if(root == null) {
                System.out.print(-1 + " ");
                return;
            }

            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }

        // Printing tree in inorder Sequence -> O(n)
        public static void inorder(Node root) {

            if(root == null) {
                System.out.print(-1 + " ");
                return;
            }

            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }

        // Printing tree in postorder Sequence -> O(n)
        public static void postorder(Node root) {

            if(root == null) {
                System.out.print(-1 + " ");
                return;
            }

            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }

        // Printing tree in levelorder Sequence using queue and iteration with T.C -> O(n)
        public static void levelOrder(Node root) {

            if(root == null)
                return;

            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while(!q.isEmpty()) {

                Node currNode = q.remove();

                if(currNode == null) {
                    
                    // End of one layer
                    System.out.println();

                    // No more levels left
                    if(q.isEmpty()) 
                        break;
                    
                    // More levels are there to be printed
                    else
                        q.add(null);
                }

                else {

                    System.out.print(currNode.data + " ");

                    // Adding left and right subtree root nodes to the queue if they exist
                    if(currNode.left != null)
                        q.add(currNode.left);

                    if(currNode.right != null)
                        q.add(currNode.right);
                }
            }
        }

        // Calculating the height of the tree
        public static int height(Node root) {

            if(root == null) 
                return 0;

            return 1 + Math.max(height(root.left), height(root.right));
        }

        // Calculating the sum of the tree
        public static int sum(Node root) {
            
            if(root == null) 
                return 0;
            
            return root.data + sum(root.left) + sum(root.right);
        }

        // Diameter of Tree 
        // Approach 1 -> Calculating height and diameter separately -> O(n^2) 
        public static int diameter(Node root) { 

            if(root == null) 
                return 0;

            // Diameter including the root
            int self_diameter = height(root.left) + height(root.right) + 1;

            // Diameter excluding the root
            int sub_diameter = Math.max(diameter(root.left), diameter(root.right));

            return Math.max(self_diameter, sub_diameter);
        }

        // Approach 2 -> Calculating height and diameter simultaneously using array -> O(n)
        public static int[] diameter_optimised(Node root) { 
            
            if(root == null) {
                int arr[] = {0, 0};
                return arr;
            }

            int left[] = diameter_optimised(root.left);
            int right[] = diameter_optimised(root.right);

            int self_diameter = left[1] + right[1] + 1;
            int sub_diameter = Math.max(left[0], right[0]);
            int height = Math.max(left[1], right[1]); 
            int arr[] = {Math.max(self_diameter, sub_diameter), height+1};
            return arr;
        }

        // Approach 3 -> Calculating height and diameter simultaneously using object -> O(n)
        public static Info diameter_object(Node root) { 

            if(root == null) {
                Info info = new Info(0, 0);
                return info;
            }

            Info leftinfo = diameter_object(root.left);
            Info rightinfo = diameter_object(root.right);

            int self_diameter = leftinfo.height + rightinfo.height + 1;
            int sub_diameter = Math.max(leftinfo.diameter, rightinfo.diameter);

            Info info = new Info(Math.max(leftinfo.height, rightinfo.height) + 1, Math.max(self_diameter, sub_diameter));

            return info;
        }
    }

    // My approach for checking prescence of subtree inside main tree
    public static String staticinorder(Node root) {

        if(root == null) 
            return "-1";

        return staticinorder(root.left) + " " + Integer.toString(root.data) + " " + staticinorder(root.right);
    }

    public static boolean checkinorder(Node root, Node subroot) {
        if(staticinorder(root).equals(staticinorder(subroot)))
            return true;

        else 
            return false;
    }

    public static boolean search(Node root, Node subroot) {

        if(root == null)
            return false;

        if(root.data == subroot.data) {
            if(checkinorder(root, subroot))
                return true;

            else    
                return false;
        }
        
        return search(root.left, subroot) || search(root.right, subroot);
    }
   
    // Di's approach for checking prescence of subtree inside main tree
    public static boolean isIdentical(Node node, Node subRoot) {

        if(node == null && subRoot == null) 
            return true;

        else if(node == null || subRoot == null || node.data != subRoot.data)
            return false;

        if(!isIdentical(node.left, subRoot.left))
            return false;

        if(!isIdentical(node.right, subRoot.right))
            return false;

        return true;
    }

    public static boolean isSubtree(Node root, Node subRoot) {

        if(root == null)
            return false;

        if(root.data == subRoot.data) {
            if(isIdentical(root, subRoot))
                return true;
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    
    // Class for storing horizontal distance and node information for Top View 
    static class Information {
        Node node;
        int hd;

        public Information(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }
    
    public static void TopView(Node root) {

        // Level Order Traversal
        Queue<Information> q = new LinkedList<>();
        HashMap<Integer, Node> map= new HashMap<>();

        int min = 0, max = 0;

        q.add(new Information(root, 0));
        q.add(null);
        while(!q.isEmpty()) {
            Information curr = q.remove();
            if(curr == null) {
                // System.out.println("null" + curr.node.data);
                if(q.isEmpty())
                    break;
                else    
                    q.add(null);
            }
            else {
                if(!map.containsKey(curr.hd)) {
                    map.put(curr.hd, curr.node);
                }

                if(curr.node.left != null) {
                    q.add(new Information(curr.node.left, curr.hd - 1));
                    min = Math.min(min, curr.hd-1);
                }

                if(curr.node.right != null) {
                    q.add(new Information(curr.node.right, curr.hd+1));
                    max = Math.max(max, curr.hd + 1);
                }
            }
        }
        for(int i=min; i<=max; i++)
            System.out.print(map.get(i).data + " ");            
    }
    
    // Printing Nodes at Kth level using Iteration -> O(n)
    public static void Kth_level_Iteration(Node root, int k) {

        Queue<Node> q = new LinkedList<>();

        q.add(root);
        q.add(null);
        int level = 1;

        while(!q.isEmpty()) {

            if(level > k)
                break;

            Node curr = q.remove();

            if(curr == null) {
                if(q.isEmpty())
                    break;
                else {
                    q.add(null);
                    level++;
                }
            }

            else {
                if(level == k)
                    System.out.print(curr.data + " ");
                else {
                    if(curr.left != null)
                        q.add(curr.left);
                    if(curr.right != null)
                        q.add(curr.right);
                }
            }
        }
    }
    
    // Printing Nodes at Kth level using Recursion -> O(n)
    public static void Kth_level_Recursion(Node root, int level, int k) {

        if(root == null)
            return;

        if(level == k) {
            System.out.print(root.data + " ");
            return;
        }

        Kth_level_Recursion(root.left, level+1, k);
        Kth_level_Recursion(root.right, level+1, k);
    }
    
    // Lowest Common Ancestor
    public static boolean getPath(Node root, int n, ArrayList<Node> path) {

        if(root == null)
            return false;

        path.add(root);

        if(root.data == n) 
            return true;

        boolean foundleft = getPath(root.left, n, path);
        boolean foundright = getPath(root.right, n, path);

        if(foundleft || foundright)
            return true;

        path.remove(path.size() -1);
        return false;
    }

    // Time Complexity -> O(n)
    // Space Complexity -> O(n)
    public static Node lca(Node root, int n1, int n2) {

        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, n1, path1); // O(n)
        getPath(root, n2, path2); // O(n)

        int i = 0;
        for(; i<path1.size() && i<path2.size(); i++) { // O(n)
            if(path1.get(i) != path2.get(i))
                break;
        }

        Node lca = path1.get(i-1);
        return lca;
    }

    // Time Complexity -> O(n)
    // Space Complexity -> O(1) But Since Recursion is being used considering that S.C -> O(n), Although we have not used any auxiliary data structure
    public static Node lca2(Node root, int n1, int n2) {

        if(root == null || root.data == n1 || root.data == n2)
            return root;

        Node leftLca = lca2(root.left, n1, n2);
        Node rightLca = lca2(root.right, n1, n2);

        // Element not found in right subtree
        if(rightLca == null)
            return leftLca;

        // Element not found in left subtree
        if(leftLca == null)
            return rightLca;

        // Element found in both subtree i.e current root node is the common ancestor
        return root;
    }

    // Calculating minimum distance between two nodes
    public static int lcaDistance(Node root, int n) {
        // Calculating distance of node form lca
        if(root == null)
            return -1;

        if(root.data == n)
            return 0;

        int leftDist = lcaDistance(root.left, n);
        int rightDist = lcaDistance(root.right, n);

        if(leftDist == -1 && rightDist == -1)
            return -1;

        if(leftDist == -1)
            return rightDist + 1;
            
        else 
            return leftDist + 1;
    }

    public static int min_Distance(Node root, int n1, int n2) {

        Node lca = lca2(root, n1, n2);

        int dist1 = lcaDistance(lca, n1);
        int dist2 = lcaDistance(lca, n2);

        return dist1 + dist2;
    }
    
    // Kth Ancestor of a node
    public static int Kth_Ancestor(Node root, int n, int k) {

        if(root == null)
            return -1;

        if(root.data == n) 
            return 0;

        int left = Kth_Ancestor(root.left, n, k);
        int right = Kth_Ancestor(root.right, n, k);
        if(left == -1 && right == -1)
            return -1;
        int max = Math.max(left, right);
        if(max+1 == k)
            System.out.println(root.data);
        return max+1;
    }

    // Sum Tree
    public static int transform(Node root) {
        if(root == null)
            return 0;
        
        int leftchild = transform(root.left);
        int rightchild = transform(root.right);
        int data = root.data;
        root.data = root.left.data + leftchild + root.right.data + rightchild;
        return data;
    }


    public static void main(String args[]) {

        int nodes[] = {1, 2, 4, 40, 50, -1, -1, -1, -1, 5, -1, -1, 3, -1, 6, 7, -1, -1, 8, -1, -1};
/*
                    1
                   / \
                  2   3
                 / \   \
                4   5   6
               /       / \
              40      7   8
             / 
            50
        */
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);

// Basic Operations on tree
/*
        System.out.println("\nPreorder Sequence of tree: ");
        tree.preorder(root);

        System.out.println("\n\nInorder Sequence of tree: ");
        tree.inorder(root);

        System.out.println("\n\nPostorder Sequence of tree: ");
        tree.postorder(root);

        System.out.println("\n\nLevelOrder Sequence of tree: ");
        tree.levelOrder(root);

        System.out.println("\nHeight of tree is: " + tree.height(root));

        System.out.println("\nSum of the tree: " + tree.sum(root));

        System.out.println("\nDiameter of the tree:");
        System.out.println("Approach 1: " + tree.diameter(root));

        System.out.println("Approach 2: " + tree.diameter_optimised(root)[0]);

        System.out.println("Approach 3: " + tree.diameter_object(root).diameter);
    */

// Finding Subtree in Main tree
/*        
        // Creating a subtree 
        Node subtree = new Node(6);
        subtree.left = new Node(7);
        subtree.right = new Node(8);

        // Own approach
        if(search(root, subtree))
            System.out.println("Subtree found in main tree");
        else
            System.out.println("Subtree NOT found in main tree");

        // Di's approach
        if(isSubtree(root, subtree))
            System.out.println("Subtree found in main tree");
        
        else
            System.out.println("Subtree NOT found in main tree");
    */
       
        System.out.print("\nTop View of the tree: ");
        TopView(root);

        System.out.println("\n\nElements at level 5: ");
        System.out.print("Using Iteration: ");
        Kth_level_Iteration(root, 5);
        System.out.print("\nUsing Recursion: ");
        Kth_level_Recursion(root, 1, 5);

        System.out.println("\n\nLowest Common Ancestor of 4 and 5");
        System.out.println("Approach 1: " + lca(root, 4, 5).data);
        System.out.println("Approach 2: " + lca(root, 4, 5).data);

        System.out.println("\nMinimum Distance between nodes 2 and 6: " + min_Distance(root, 2, 6) + " edges");

        System.out.print("3rd Ancestor of 5: ");
        Kth_Ancestor(root, 50, 3);

        transform(root);
        BinaryTree.levelOrder(root);
    }
}
