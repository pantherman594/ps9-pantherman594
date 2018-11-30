# Problem Set 9: Maps (and Trees)

### Due Monday, December 10, 11:59pm

---

This is an individual assignment. In this problem set, you will be implementing different maps and running experiments to measure their efficiency. For all of the maps, you will be using the following Map ADT interface:

``` java

public interface CS2Map<Key extends Comparable<Key>, Value> { 
  Value get(Key key);
  void put(Key key, Value val);
  Key[] getKeys();
  Key min();
  boolean contains(Key key);
  boolean isEmpty();
  String toString();
}

```


## Part 1: Hash maps

### Part 1a: Hash map with separate chaining

### Part 1b: Hash map with linear probing

### Part 2: Tree map with a binary search tree

## Part 3: Testing your data structures
