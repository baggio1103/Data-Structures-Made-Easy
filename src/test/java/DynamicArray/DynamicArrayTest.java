package DynamicArray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DynamicArrayTest {

    @Test
    void get() {
        DynamicArray<Integer> dynamicArray = new DynamicArray<>(Integer.class);
        dynamicArray.add(1189);
        dynamicArray.add(122);
        dynamicArray.add(87);
        dynamicArray.add(122);
        assertEquals(4, dynamicArray.size());
        assertEquals(1189, dynamicArray.get(0));
        assertEquals(122, dynamicArray.get(1));

        assertThrows(IndexOutOfBoundsException.class, () -> dynamicArray.get(4));
        assertThrows(IndexOutOfBoundsException.class, () -> dynamicArray.get(5));
        assertThrows(IndexOutOfBoundsException.class, () -> dynamicArray.get(-1));
    }

    @Test
    void add() {
        DynamicArray<Integer> dynamicArray = new DynamicArray<>(Integer.class);
        for (int i = 0; i < 10; i++) {
            dynamicArray.add(i+1);
        }
        assertEquals(10, dynamicArray.size());
        assertEquals(1, dynamicArray.get(0));
        assertEquals(10, dynamicArray.get(9));
        assertEquals(16, dynamicArray.capacity);

        for (int i = 10; i < 25; i++) {
            dynamicArray.add(i+1);
        }
        assertEquals(25, dynamicArray.size());
        assertEquals(11, dynamicArray.get(10));
        assertEquals(32, dynamicArray.capacity);
    }

    @Test
    void addToSpecifiedIndex() {
        String[] words = {"ab", "ad", "bc", "xy", "ze", "as", "aa",
                          "ss", "ww", "qq", "az", "td", "qe", "as"};
        DynamicArray<String> dynamicArray = new DynamicArray<>(String.class);
        for (String word : words) {
            dynamicArray.add(word);
        }
        assertEquals("ab", dynamicArray.get(0));
        assertEquals(14, dynamicArray.size());

        dynamicArray.add(0, "abc");
        assertEquals("abc", dynamicArray.get(0));
        assertEquals(15, dynamicArray.size());

        dynamicArray.add(7, "Hello");
        assertEquals("Hello", dynamicArray.get(7));
        assertEquals(16, dynamicArray.size());
        assertEquals(16, dynamicArray.capacity);

        dynamicArray.add(16, "World!");
        assertEquals("World!", dynamicArray.get(16));
        assertEquals(17, dynamicArray.size());
        assertEquals(32, dynamicArray.capacity);
    }

    @Test
    void remove() {
        String[] words = {"ab", "ad", "bc", "xy", "ze", "as", "aa",
                          "ss", "ww", "qq", "az", "td", "qe", "as",
                          "er", "wt", "uy", "xg", "ht", "tp", "iq" };
        DynamicArray<String> dynamicArray = new DynamicArray<>(String.class);
        for (String word : words) {
            dynamicArray.add(word);
        }
//      "ab", "ad", "bc", "xy", "ze", "as", "aa", "ss", "ww", "qq", "az", "td", "qe", "as", "er", "wt", "uy", "xg", "ht", "tp", "iq"
        assertEquals("ab", dynamicArray.get(0));
        dynamicArray.remove(0);

//      "ad", "bc", "xy", "ze", "as", "aa", "ss", "ww", "qq", "az", "td", "qe", "as", "er", "wt", "uy", "xg", "ht", "tp", "iq"
        assertEquals("ad",dynamicArray.get(0));
        dynamicArray.remove(0);

//      "bc", "xy", "ze", "as", "aa", "ss", "ww", "qq", "az", "td", "qe", "as", "er", "wt", "uy", "xg", "ht", "tp", "iq"
        assertNotEquals("ad",dynamicArray.get(0));
        dynamicArray.remove(6);

//      "bc", "xy", "ze", "as", "aa", "ss", "qq", "az", "td", "qe", "as", "er", "wt", "uy", "xg", "ht", "tp", "iq"
        assertEquals("qq",dynamicArray.get(6));

//      "bc", "xy", "ze", "as", "aa", "ss", "qq", "az", "td", "qe", "as", "er", "wt", "uy", "xg", "ht", "tp", "iq"
        assertEquals("bc",dynamicArray.get(0));
        dynamicArray.remove(17);

//      "bc", "xy", "ze", "as", "aa", "ss", "qq", "az", "td", "qe", "as", "er", "wt", "uy", "xg", "ht", "tp"
        assertEquals("tp",dynamicArray.get(dynamicArray.size()-1));
        dynamicArray.remove(1);

//      "bc", "ze", "as", "aa", "ss", "qq", "az", "td", "qe", "as", "er", "wt", "uy", "xg", "ht", "tp"
        assertEquals("ze",dynamicArray.get(1));
        dynamicArray.remove(5);

//      "bc", "ze", "as", "aa", "ss", "az", "td", "qe", "as", "er", "wt", "uy", "xg", "ht", "tp"
        assertEquals("az",dynamicArray.get(5));
        dynamicArray.remove(0);

//      "ze", "as", "aa", "ss", "az", "td", "qe", "as", "er", "wt", "uy", "xg", "ht", "tp"
        assertEquals("ze",dynamicArray.get(0));

    }

}