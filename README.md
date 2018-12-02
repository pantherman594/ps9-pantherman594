# Problem Set 9: Maps (and Trees)

### Due Monday, December 10, 11:59pm

---

This is an individual assignment. In this problem set, you will be implementing two different maps and running experiments to compare their efficiency under different circumstances. For both maps, you will be implementing the following map ADT interface, which you will find in the `src` directory:

``` java

public interface MapCS2<Key extends Comparable<Key>, Value> { 
  Value get(Key key);           // returns a Value for the specified key
  void put(Key key, Value val); // puts a Key-Value pair in the map
  ArrayList<Keys> getKeys();    // returns the keys of the map as a set
  Key min();                    // returns the minimum key in the map
  Key max();                    // returns the maximum key in the map
  boolean contains(Key key);    // returns true if the map contains the key
  boolean isEmpty();            // returns true if map is empty
  int size();                   // returns size of map
  String toString();            // returns a string that lists each key-value pair, one per line
}

```

**Helpful Hints**

* Keys are unique in a map! If the user calls `put()` with a key that has already been added to the map, replace the current value for that key with the new value.

* The toString() method should return a string with key-value pairs, where the key is separated from the value by a space-colon-space, and the pairs are separated by a comma-space, e.g., ``dog : animal, tree : vegetable, salt : mineral``.

* I expect you to use the files I have provided. Do not create new .java files, do not create new directories, and keep all your `.java` files in the `src` directory. In addition, do not change the names of the methods. I will be testing your code using these specific methods.


### Part 1: Hash map with separate chaining: `HashMapCS2.java`
I have provided skeleton code for a hash-based implementation of the `MapCS2` interface in the `HashMapCS2.java` file. Your hash map implementation will include all of the above interface methods, as well as the following components:

* You will be storing your values in an array **of size 31** of `ArrayList` objects, in which each `ArrayList` contains elements of the `KeyValuePair` type, which you will define as outlined in the `HashMapCS2.java` file. That is, you will have an array, and every element in the array will be an `ArrayList` of `KeyValuePair` objects. This will allow you to easily and efficiently implement separate chaining for collision resolution. For more information on how separate chaining works, see the textbook and the lecture notes on maps (or "symbol tables" as they are often called in the textbook).

* You must also write the hash function. To keep things manageable, you will implement a hash function for **only three data types:** `String`, `Integer`, and `Double`. Your hash function will take any Integer, Double, or String, and convert it to an integer between 0 and 30. Details are provided in the `HashMapCS2.java` file. Your code needs to handle keys of these three types only.

*There are many implementations of the hash map data structure on the web, including one provided by the textbook. You must implement your hash map as I have described above using the skeleton code I have provided.*


### Part 2: Tree map with a binary search tree: `TreeMapCS2.java`
I have provided skeleton code for a tree-based implementation of the `MapCS2` interface in the `TreeMapCS2.java` file. Your tree map implementation will include all of the interface methods, plus the following components:

* You will create your trees using an inner `Node` class, whose instance variables will include `Key k, Value v, Node rightchild`, and `Node leftchild`.

* Every `TreeMapCS2` object will have a pointer to the top `Node` and a size variable.

* You will use a binary search tree to store your key-value pairs. Therefore, your keys can be anything that implements `Comparable`. You don't need to write a `compareTo()` method. You can just assume that the user will only use keys that already implement `Comparable`.

* When you are writing the code for `getKeys()` to return an ArrayList of ordered keys, consult the class notes on tree traversal to remember how to traverse the tree in the correct order to return an ordered list. 

*There are many implementations of the tree map data structure on the web, including one provided by the textbook. You must implement your tree map as I have described above using the skeleton code I have provided.*


### Part 3: Testing your data structures

In each of the two maps, add code to keep track of and print out the number of comparisons required to (1) find the minimum key, and (2) find the maximum key.

Then in the `TestMyMap.java` file, write a main method that does the following.

1. Create a HashMapCS2 object and a TreeMapCS2 object.

2. Populate each map with the following key-value pairs. You must insert them in this order!

| key | value |
| --- | --- |
| 5   | "dog" |
| 22  | "lion" |
| 36  | "cat" |
| 73  | "elephant" |
| 89  | "monkey" |
| 177 | "donkey" |
| 215 | "cheetah" |
| 315 | "panda" |
| 470 | "aligator" |
| 496 | "koala" |

3. Call `min()` and `max()` on both maps.

4. Now populate a new map of each kind with the following key-value pairs **in this order**.

| key | value |
| --- | --- |
| 177 | "donkey" |
| 215 | "cheetah" |
| 89  | "monkey" |
| 315 | "panda" |
| 73  | "elephant" |
| 470 | "aligator" |
| 22  | "lion" |
| 5   | "dog" |
| 36  | "cat" |
| 496 | "koala" |

5. Call `min()` and `max()` on both new maps.

6. In the comments of `TestMyMap.java` explain any differences you see in the number of comparisons required for the two different maps under the two different circumstances.


