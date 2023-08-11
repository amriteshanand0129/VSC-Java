public class DoubleLL {
    public class Node {
        int data;
        Node next;
        Node prev;
        
        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) {

        Node newnode = new Node(data);
        size++;

        if(head == null) {
            head = tail = newnode;
            return;
        }

        newnode.next = head;
        head.prev = newnode;
        head = newnode;
    }

    public void addLast(int data) {
        
        Node newnode = new Node(data);
        size++;

        if(head == null) {
            head = tail = newnode;
            return;
        }

        tail.next = newnode;
        newnode.prev = tail;
        tail = newnode;
    }

    public void addIndex(int index, int data) {

        if(index == 1) {
            addFirst(data);
            return;
        }

        if(index == size) {
            addLast(data);
            return;
        }

        Node newnode = new Node(data);
        size++;

        Node temp = head;
        while(temp != null && index > 1) {
            temp = temp.next;
            index--;
        }

        temp.prev.next = newnode;
        newnode.next = temp;
        newnode.prev = temp.prev;
        temp.prev = newnode;
    }

    public void removeFirst() {
        head = head.next;
        head.prev = null;
        size--;
    }

    public void removeLast() {
        tail = tail.prev;
        tail.next = null;
        size--;
    }

    public void removeIndex(int index) {
        Node temp = head;
        while(temp != null && index > 1) {
            temp = temp.next;
            index--;
        }
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        size--;
    }

    public void reverse() {
        Node curr = head;
        Node prev = null;
        Node next;

        tail = head;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            curr.prev = next;

            prev = curr;
            curr = next;
        }

        head = prev;
    }

    public void printForward() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println("\nSize of LinkedList is " + size);
    }

    public void printBackword() {
        Node temp = tail;
        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println("\nSize of LinkedList is " + size);
    }

    public static void printLL(DoubleLL dll) {
        System.out.println("\nForward Printed LinkedList - ");
        dll.printForward();

        System.out.println("\nBackword Printed LinkedList - ");
        dll.printBackword();
    }

    public static void main(String args[]) {
        DoubleLL dll = new DoubleLL();
        dll.addFirst(4);
        dll.addFirst(2);
        dll.addFirst(1);
        dll.addLast(5);
        dll.addLast(6);

        printLL(dll);

        dll.addIndex(3, 3);
        dll.addIndex(1, 0);
        dll.addIndex(7, 7);

        printLL(dll);

        dll.removeFirst();
        dll.removeLast();
        printLL(dll);

        dll.removeIndex(2);
        printLL(dll);

        System.out.println("\n\t\t---LinkedList after reversing---");
        dll.reverse();
        printLL(dll);

    }
}
