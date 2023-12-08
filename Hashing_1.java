// Implementation of HashMap and its basic functions
import java.util.ArrayList;
import java.util.LinkedList;
public class Hashing_1 {
    static class HashMap<K, V> {

        // K and V are generics representing data type of the parateteres passed 
        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n; // Total number of nodes
        private int N; // Total number of buckets
        private LinkedList<Node> buckets[]; // It's an array of type LinkedList<Node>

        // Suppressing warning as we are declaring an array of type linkedlist without specifying the data type of linkedlist in line 26
        @SuppressWarnings("unchecked")
        public HashMap() { // Constructor
            this.N = 4;
            this.buckets = new LinkedList[4];
            for(int i=0; i<4; i++) 
                this.buckets[i] = new LinkedList<>();
        }

        private int hashFunction(K key) {
            int hc = key.hashCode(); // can return -ve values also
            return Math.abs(hc) % N; // converting into valid index form
        }

        private int SearchInLL(K key, int bi) {
            LinkedList<Node> ll = buckets[bi]; // Stroring the linkedlist attached to a bucket index
            int di = 0;
            for(int i=0; i<ll.size(); i++) {
                Node node = ll.get(i);
                if(node.key == key) 
                    return di;
                di++;
            }
            return -1;
        }

        @SuppressWarnings("unchecked")
        private void rehash() {
            LinkedList<Node> oldBuck[] = buckets; // Backing up data into auxiliary array of linkedlist
            
            // Initializing new bucket of double size
            buckets = new LinkedList[n*2];  
            N = 2 * N;
            for(int i=0; i<buckets.length; i++) 
                buckets[i] = new LinkedList<>();
            
            // nodes -> add in new bucket
            for(int i=0; i<oldBuck.length; i++) {
                LinkedList<Node> ll = oldBuck[i];
                for(int j=0; j<ll.size(); j++) {
                    Node node = ll.remove();
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V value) { // O(lambda) -> O(1)
            int bi = hashFunction(key); // bucket index which should be 0 to size -1;
            int di = SearchInLL(key, bi); // data index either valid or -1

            if(di != -1) {
                // Node found -> updating value of node 
                Node node = buckets[bi].get(di);
                node.value = value;
            }

            else {
                // Node not found -> creating new node
                buckets[bi].add(new Node(key, value));
                n++;
            }

            double lambda = (double)n / N; // Parameter to check possibility of rehashing
            if(lambda > 2.0) 
                rehash(); 
        }

        public boolean containsKey(K key) { // O(1)
            int bi = hashFunction(key); // bucket index which should be 0 to size -1;
            int di = SearchInLL(key, bi); // data index either valid or -1

            if(di != -1) 
                return true;
            else 
                return false;
        }

        public V remove(K key) { // O(1)
            int bi = hashFunction(key); // bucket index which should be 0 to size -1;
            int di = SearchInLL(key, bi); // data index either valid or -1

            if(di != -1) {
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            }
            else 
                return null;
        }

        public V get(K key) { // O(1)
            int bi = hashFunction(key); // bucket index which should be 0 to size -1;
            int di = SearchInLL(key, bi); // data index either valid or -1

            if(di != -1) {
                Node node = buckets[bi].get(di);
                return node.value;
            }
            else 
                return null;
        }

        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();
            for(int i=0; i<buckets.length; i++) {
                LinkedList<Node> ll = buckets[i];
                for(Node node: ll) {
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public boolean isEmpty() {
            return n == 0;
        }
    }
    public static void main(String args[]) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);
        hm.put("Nepal", 5);

        ArrayList<String> keys = hm.keySet();
        for(String key: keys)
            System.out.println(key);
        System.out.println(hm.get("India"));
    }
}
