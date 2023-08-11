public class LinkedList {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    /* 
        These functions/methods need not to be static.
        Although static method "main" can call only static methods but here
        we will call using object "ll".
    */

    public void addFirst(int data) {

        // create new node
        Node newNode = new Node(data);
        size++;

        // if LinkedList is empty
        if(head == null) {
            head = tail = newNode;
            return;
        }

        // newnode's next = head
        newNode.next = head;

        // new head is the newnode
        head = newNode; 
    }

    public void addLast(int data) {

        // create new node
        Node newNode = new Node(data);
        size++;

        //if LinkedList is empty
        if(head == null) {
            head = tail = newNode;
            return;
        }

        // tail's next = newNode
        tail.next = newNode;

        // new tail is the newNode
        tail = newNode;
    }

    public void addIndex(int index, int data) {

        // Empty Linked List -> concerned function called
        if(index == 0) {
            addFirst(data);
            return;
        }

         // create new node
        Node newNode = new Node(data);

        Node ptr = head;
        int i = 0;

        // Traversing to reach the required index
        while(ptr != null) {
            if(i == index-1) {
                newNode.next = ptr.next;
                ptr.next = newNode;
                size++;
                return;
            }
            ptr = ptr.next;
            i++;
        }
        
        System.out.println("\nAdding Node at invalid index !");
    }

    public int removeFirst() {

        // Empty Linked List
        if(size == 0) {
            System.out.println("Linked List is empty");
            return Integer.MIN_VALUE;
        }

        // Single Node Linked List
        else if(size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        int val = head.data;

        // Delinking
        head = head.next;
        size--;

        return val;
    }

    public int removeLast() {

        // Empty Linked List
        if(size == 0) {
            System.out.println("Linked List is empty");
            return Integer.MIN_VALUE;
        }

        // Single node Linked List
        else if (size == 1) {
            int val = tail.data;
            head = tail = null;
            size = 0;
            return val;
        }

        int val = tail.data;
        Node ptr = head;
        int i=1;

        // Traversing to reach last second node
        while(ptr != null && i < size-1) {
            ptr = ptr.next;
            i++;
        }

        // Delinking
        ptr.next = null;
        tail = ptr;
        size--;

        return val; 
    }

    // Iterative search
    public int itrSearch(int key) {
        Node ptr = head;
        int i = 0;

        while(ptr != null) {

            // Key found
            if(ptr.data == key) 
                return i;

            ptr = ptr.next;
            i++;
        }

        return -1;
    }

    // Recursive search
    public int recSearch(int key, Node refer) {

        if(refer == null)
            return -1;

        else if(refer.data == key) 
            return 1;

        int index = recSearch(key, refer.next);
        if(index == -1)
            return -1;
        else 
            return index+1;
    }

    public void reverseList() {
        Node previous, current, forward;
        previous = null;
        tail = current = head;
        forward = current.next;
        while(current != null) {
            forward = current.next;
            current.next = previous;
            previous = current;
            current = forward;
        }
        head = previous;
    }

    public void removeNode(int index) {

        if(index == size) {
            head = head.next;
            return;
        }

        Node ptr = head;
        for(int i=1; i<size-index; i++) 
            ptr = ptr.next;
        
        // Delinking middle Node
        ptr.next = ptr.next.next;
    }

    public Node findMid(Node head) {
        Node slow = head;
        Node fast = head;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;       // +1
            fast = fast.next.next;  // +2
        }

        return slow;
    }

    public boolean checkPallindrome() {

        if(head == null || head.next == null)
            return true;

        Node mid = findMid(head);
        Node previous = null;
        Node current = mid;
        Node forward;
        while(current != null) {
            forward = current.next;
            current.next = previous;
            previous = current;
            current = forward;
        }

        Node right = previous;
        Node left = head;

        while(right != null) {
            if(left.data != right.data)
                return false;
            left = left.next;
            right = right.next;
        }
        return true; 

    }

    // Floyd's Cycle finding algorithm
    public boolean isCycle() {
        Node slow = head;
        Node fast  = head;
        Node previous = null;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // both pointer meet each other
            if(slow == fast) {
                System.out.println("\nCycle found in the Linked List !");
                System.out.println("\nConcerned function called to remove the cycle !");
                removeCycle(fast, previous);
                return true;
            }
            previous = slow;
        }
        return false;
    }

    public void removeCycle(Node fast, Node previous) {

        Node slow = head;

        while(slow != fast) {
            slow = slow.next;
            previous = fast;
            fast = fast.next;
        }
        previous.next = null;

        System.out.println("\nLinked after removing the cycle: ");
        printList();
        return;
    }

    public Node mergeSort(Node head) {
        if(head == null || head.next == null)
            return head;

        // finding mid
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node right_head = slow.next;
        slow.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(right_head);
        return merge(newLeft, newRight);
    }

    public Node merge(Node lefthead, Node righthead) {

        Node mergeLL = new Node(-1);
        Node temp = mergeLL;
        while(lefthead != null && righthead != null) {
            if(lefthead.data < righthead.data) {
                temp.next = lefthead;
                lefthead = lefthead.next;
                temp = temp.next;
            }
            else {
                temp.next = righthead;
                righthead = righthead.next;
                temp = temp.next;
            }
        }
        while(righthead != null) {
            temp.next = righthead;
            righthead = righthead.next;
            temp = temp.next;
        }
        while(lefthead != null) {
            temp.next = lefthead;
            lefthead = lefthead.next;
            temp = temp.next;
        }

        return mergeLL.next;
    }

    public void ZigZag() {

        if(head == null || head.next == null)
            return;
        
        Node mid = findMid(head);

        // Reversing the last half 
        Node previous = null;
        Node current = mid.next;
        mid.next = null;
        Node forward;
        while(current != null) {
            forward = current.next;
            current.next = previous;
            previous = current;
            current = forward;
        }

        Node right = previous;
        Node left = head;
        Node nextLeft, nextRight;
        while(right != null && left != null) {
            nextLeft = left.next;
            left.next = right;
            nextRight = right.next;
            right.next = nextLeft;

            left = nextLeft;
            right = nextRight;
        }
    }

    public void printList() {

        // Empty Linked List
        if(head == null) {
            System.out.println("Linked List is empty");
            return;
        }

        Node ptr = head;

        // Traversing the linked list
        while(ptr != null) {
            System.out.print(ptr.data + " ");
            ptr = ptr.next;
        }
        System.out.println("\nSize of Linked List is " + size);
    }

    public static void main(String args[]) {
        LinkedList ll = new LinkedList();

        // ll.addLast(10);
        // ll.addLast(2);
        // ll.addLast(300);
        // ll.addLast(24);
        // ll.addLast(35);

        // ll.addFirst(50);
        // ll.addFirst(-12);

        // ll.addIndex(20, 15);
        // ll.addIndex(2, 14);

        // System.out.println("\nInitial Linked List");
        // ll.printList();

        // System.out.println("\nLinked List after removing first node-");
        // System.out.println("Removed Node: " + ll.removeFirst());
        // ll.printList();

        // System.out.println("\nLinked List after removing last node-");
        // System.out.println("Removed Node: " + ll.removeLast());
        // ll.printList();

        // int index = ll.itrSearch(14);
        // if(index == -1)
        //     System.out.println("\nKey not found");
        // else
        //     System.out.println("\nKey found at index: " + index);

        // System.out.println("\nKey found at index: " + ll.recSearch(30, head) );
        
        // ll.reverseList();
        // System.out.println("\nLinked List after reversing: ");
        // ll.printList();

        // ll.removeNode(2);
        // System.out.println("\nLinked List after removing Node from middle: ");
        // ll.printList();


        // Checking if the Linked List is pallindrome

        ll.addFirst(1);
        ll.addLast(2);
        ll.addLast(2);
        ll.addLast(2);
        ll.addLast(1);
        ll.printList();
        System.out.println("Pallindromic Status of Linked List: " + ll.checkPallindrome());
    
    
        // Detecting Cycle in Linked List

        // head = new Node(1);
        // head.next = new Node(2);
        // head.next.next = new Node(3);
        // head.next.next.next = new Node(4);
        // head.next.next.next.next = new Node(5);
        // head.next.next.next.next.next = head;
        // System.out.println("Cyclicity of Linked List: " + ll.isCycle());
        
        // Sorting the List using Merge Sort

        // ll.mergeSort(head);
        // ll.printList();

        // Creating a ZigZag List
        // ll.ZigZag();
        // ll.printList();
    }
}