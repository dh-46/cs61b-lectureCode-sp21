/** Array based list.
 *  @author Josh Hug
 */

//         0 1  2 3 4 5
// items: [6 9 -1 2 0 0 0 0...]
// size: 3

/**
 * addLast: 下一個項目會被加到目前大小的位置。 (size = 4, next index = 4)
 * size: list 裡的 items 數量會是 size。
 * getLast(): 要回傳的項目 index 會是 size - 1。
 */

public class AList<Item> {

    Item[] items;
    int size;

    /** Creates an empty list. */
    public AList() {
        size = 0;
        items = (Item[]) new Object[size];
    }

    /**
     * Resize the underlying array to the target capacity
     * @param capacity
     */
    private void resize(int capacity) {
        int[] temp = new int[capacity];
        System.arraycopy(items, 0, temp, 0, size);
        items = temp;
    }

    /** Inserts X into the back of the list. */
    public void addLast(int x) {
        if (size == items.length) {
            resize(size + 1);
        }
        items[size] = x;
        size += 1;
    }

    /** Returns the item from the back of the list. */
    public int getLast() {
        return items[size - 1];
    }
    /** Gets the ith item in the list (0 is the front). */
    public int get(int i) {
        return items[i];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** Deletes item from back of the list and
      * returns deleted item. */
    public int removeLast() {
        int x = getLast();
        size = size - 1;
        return x;
    }
} 