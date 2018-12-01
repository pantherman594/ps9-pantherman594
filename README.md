# Problem Set 9: Maps (and Trees)

### Due Monday, December 10, 11:59pm

---

This is an individual assignment. In this problem set, you will be implementing two different maps and running experiments to compare their efficiency under different circumstance. For both maps, you will be implementing the following map ADT interface:

``` java

public interface MapCS2<Key extends Comparable<Key>, Value> { 
  Value get(Key key);           // returns a Value for the specified key
  void put(Key key, Value val); // puts a Key-Value pair in the map
  Set<Keys> getKeys();          // returns the keys of the map as a set
  Key min();                    // returns the minimum key in the map
  Key max();                    // returns the maximum key in the map
  boolean contains(Key key);    // returns true if the map contains the key
  boolean isEmpty();            // returns true if map is empty
  int size();                   // returns size of map
  String toString();            // returns a string that lists each key-value pair, one per line
}

```

**Note: I expect you to use the files I have provided. Do not create new .java files, and do not change the names of the methods. I will be testing your code using these specific methods.**


### Part 1: Hash map with separate chaining: HashMapCS2.java
I have provided skeleton code for a hash-based implementation of the `MapCS2` interface in the `HashMapCS2.java` file. Your hash map implementation will include all of the above interface methods, plus the following components:

* You will be storing your values in an array of size 31 of `ArrayList` objects, in which each `ArrayList` contains elements of the `KeyValuePair` type, which you will define as outlined in the `HashMapCS2.java` file. That is, you will have an array, and every element in the array will be an `ArrayList` of `KeyValuePair` objects. This will allow you to easily and efficiently implement separate chaining for collision resolution. For more information on how separate chaining works, see the textbook and the lecture notes on maps (or "symbol tables" as they are often called in the textbook).

* You must also write the hash function. To keep things manageable, you will implement a hash function for only three data types: String, Integer, and Double. Your hash function will take any Integer, Double, or String, and convert it to an integer between 0 and 30. Details are provided in the `HashMapCS2.java` file. Your code needs to handle Keys of these three types only.

*There are many implementations of the hash map data structure on the web, including one provided by the textbook. You must implement your hash map as I have described above. If you copy and paste existing code, you will not be meeting the specifications here.*


### Part 2: Tree map with a binary search tree: TreeMapCS2.java

### Part 3: Testing your data structures

Populate your hashmap with the following key-value pairs:

A. Write code in your java class definitions to count the number of operations required to 

