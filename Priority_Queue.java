import java.util.Comparator;
import java.util.PriorityQueue;
public class Priority_Queue {
    static class Student implements Comparable<Student>{
        String name;
        int rank;
        public Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        // function overriding
        @Override
        public int compareTo(Student s2) {
            return this.rank - s2.rank;
        }
    }
    public static void main(String args[]) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(3);
        pq.add(4);
        pq.add(1);
        pq.add(7);
        while(!pq.isEmpty()) {
            System.out.println(pq.peek());
            pq.remove();
        }
        PriorityQueue<Student> pqs = new PriorityQueue<>();
        pqs.add(new Student("A", 4));
        pqs.add(new Student("B", 5));
        pqs.add(new Student("C", 2));
        pqs.add(new Student("D", 12));
        while(!pqs.isEmpty()) {
            System.out.println(pqs.peek().name + " -> " + pqs.peek().rank);
            pqs.remove();
        }
    }
    
}
