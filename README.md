# Problem Set 9: Maps (and Trees)

### Due Monday, December 10, 11:59pm

---

This is an individual assignment. In this problem set, you will be implementing two different maps and running experiments to compare their efficiency under different circumstance. For both maps, you will be implementing the following Map ADT interface:

``` java

public interface CS2Map<Key extends Comparable<Key>, Value> { 
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


### Part 1: Hash map with separate chaining: CS2HashMap.java
I have provided skeleton code for a hash implementation of CS2Map in the CS2HashMap.java file. In this file you will find skeleton code 

### Part 2: Tree map with a binary search tree

### Part 3: Testing your data structures
