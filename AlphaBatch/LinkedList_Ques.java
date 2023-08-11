public class LinkedList_Ques {
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

    public void deleteMN(int m, int n) {

        Node temp = head;

        while(temp != null) {
            int tm = m;
            int tn = n;

            while(tm > 1) {
        
                temp = temp.next;
                tm--;

                if(temp == null)
                    return;
            }

            Node jump = temp;

            while(tn >= 0) {

                if(jump == null) {
                    temp.next = null;
                    return;
                }

                jump = jump.next;
                tn--;
            }

            temp.next = jump;
            temp = jump;
        }
    }

    public void swap(int x, int y) {
        int tx = x;
        Node temp = head;
        Node prevtemp = null;
        while(tx > 1) {
            prevtemp = temp;
            temp = temp.next;

            if(temp == null) {
                System.out.println("Index out of range");
                return;
            }

            tx--;
        }

        Node swap = temp;
        Node prevswap = prevtemp;

        while(y - x > 0) {
            prevswap = swap;
            swap = swap.next;

            if(swap == null) {
                System.out.println("Index out of range");
                return;
            }

            y--;
        }

        Node s = swap.next;
        prevtemp.next = swap;
        swap.next = temp.next;

        prevswap.next = temp;
        temp.next = s;

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

        LinkedList_Ques ll = new LinkedList_Ques();

        /* Question 2
           Delete N Nodes after M Nodes of a Linked List
        */

        // ll.addLast(1);
        // ll.addLast(2);
        // ll.addLast(3);
        // ll.addLast(4);
        // ll.addLast(5);
        // ll.addLast(6);
        // ll.addLast(7);
        // ll.addLast(8);
        // ll.addLast(9);
        // ll.addLast(10);
        // ll.addLast(11);
        // ll.addLast(12);
        // ll.addLast(13);

        // ll.printList();

        // ll.deleteMN(2, 3);
        // ll.printList();

        /* Swapping Nodes in a Linked List
        */

        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.printList();
        ll.swap(2, 3);
        ll.printList();

    }
}
