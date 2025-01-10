import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ArraySet<T> implements Iterable<T> {

    private T[] items;
    private int size; // the next item to be added will be position "size"

    public ArraySet() {
        items = (T[]) new Object[100];
        size = 0;
    }

    /* Returns true if this map contains a mapping for the specified key.
     */
    public boolean contains(T x) {
        for (int i = 0; i < size; i++) {
            if (items[i].equals(x)) {
                return true;
            }
        }

        return false;
    }

    /* Associates the specified value with the specified key in this map. 
       Throws an IllegalArgumentException if the key is null. */
    public void add(T x) {
        if (x == null) {
            throw new IllegalArgumentException("Cannot add null to ArraySet");
        }

        if (contains(x)) {
            return;
        }
        items[size] = x;
        size += 1;
    }

    /* Returns the number of key-value mappings in this map. */
    public int size() {
        return size;
    }

    /**
     * returns an iterator (a.k.a. seer)
     * @return
     */
    @Override
    public Iterator<T> iterator() {
        return new ArraySetIterator();
    }

    public class ArraySetIterator implements Iterator<T> {

        private int wizIndex;

        public ArraySetIterator() {
            wizIndex = 0;
        }

        @Override
        public boolean hasNext() {
            return wizIndex < size;
        }

        @Override
        public T next() {
            T returnItem = (T) items[wizIndex];
            wizIndex+=1;
            return returnItem;
        }
    }

    public static void main(String[] args) {
        Set<String> javaset = new HashSet<>();

        javaset.add("A");
        javaset.add("B");
        javaset.add("C");

        for (String s : javaset) {
            System.out.println("Java Set: " + s);
        }

        ArraySet<String> s = new ArraySet<>();
        s.add("horse");
        s.add("fish");
        s.add("house");
        s.add("fish");

        // Uglier solution
        Iterator<String> seer = s.iterator();
        while (seer.hasNext()) {
            System.out.println(seer.next());
        }

        // Enhanced for loop
        for (String string : s) {
            System.out.println(string);
        }
    }

    /* Also to do:
    1. Make ArraySet implement the Iterable<T> interface.
    2. Implement a toString method.
    3. Implement an equals() method.
    */
}
