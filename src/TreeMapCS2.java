import java.util.*;

public class TreeMapCS2<Key extends Comparable<Key>, Value> implements MapCS2<Key, Value> {

  // _________________________________________
  // Note: Once you have implemented all the
  // interface methods, be sure to add implements
  // MapCS2 in the class declaration above.
  // _________________________________________


  // -----------------------------------------
  // Member variables:
  // ------------------------------------------
  // Create pointer to top Node and a size variable
  Node top = null;
  int size = 0;


  // -----------------------------------------------
  // Node inner class
  // -----------------------------------------------
  // Create an inner class called Node which has the
  // following instance variable:
  // Key k, Value v, Node rightchild, Node leftchild
  // Also create one or more constructors for the Node class.
  // Remember that your binary search tree will be organized
  // according to the Key only (not the value).
  public class Node {
    Entry entry;
    Node rightchild = null;
    Node leftchild = null;

    public Node() {
      this.entry = new Entry(null, null);
    }

    public Node(Key k, Value v) {
      this.entry = new Entry(k, v);
    }

    public String toString() {
      return this.entry.k + " : " + this.entry.v;
    }
  }

  public class Entry {
    Key k;
    Value v;
    public Entry(Key k, Value v) {
      this.k = k;
      this.v = v;
    }
    public String toString() {
      return this.k + " : " + this.v;
    }
  }

  // -----------------------------------------------
  // Constructor(s)
  // -----------------------------------------------
  // Write a constructor for TreeMapCS2, if you wish.


  // -----------------------------------------------
  // Interface methods to implement
  // -----------------------------------------------
  /*
  Value get(Key key);           // returns a Value for the specified key
  void put(Key key, Value val); // puts a Key-Value pair in the map
  ArrayList<Key> getKeys();     // returns the *SORTED* keys as an ArrayList
  Key min();                    // returns the minimum key in the map
  Key max();                    // returns the maximum key in the map
  boolean contains(Key key);    // returns true if the map contains the key
  boolean isEmpty();            // returns true if map is empty
  int size();                   // returns size of map
  String toString();            // returns a string with each key : value pair
  */

  public Value get(Key key) {
    if (this.size == 0) return null;
    Node current = top;

    // Loop through all the children until you reach a null child or a matching key
    int diff;
    while (current != null && (diff = current.entry.k.compareTo(key)) != 0) {
      if (diff > 0) {
        current = current.rightchild;
      } else {
        current = current.leftchild;
      }
    }

    return current == null ? null : current.entry.v;
  }

  public void put(Key key, Value val) {
    Node newNode = new Node(key, val);

    if (this.size == 0) {
      top = newNode;
      this.size++;
      return;
    }

    Node current = top;

    // Loop through all the children until you reach a matching key
    int diff;
    while ((diff = current.entry.k.compareTo(key)) != 0) {
      if (diff < 0) {
        if (current.rightchild == null) {
          current.rightchild = newNode;
          this.size++;
          return;
        }
        current = current.rightchild;
      } else {
        if (current.leftchild == null) {
          current.leftchild = newNode;
          this.size++;
          return;
        }
        current = current.leftchild;
      }
    }

    // No need to create a new node or increase the size, because matching key was found
    current.entry.v = val;
  }

  public ArrayList<Key> getKeys() {
    ArrayList<Entry> entries = new ArrayList<>();
    getEntries(this.top, entries);

    ArrayList<Key> keys = new ArrayList<>();
    for (Entry entry : entries) {
      keys.add(entry.k);
    }
    return keys;
  }

  private void getEntries(Node top, ArrayList<Entry> entries) {
    if (top == null) return;

    // Get children and keys in order
    getEntries(top.leftchild, entries);
    entries.add(top.entry);
    getEntries(top.rightchild, entries);
  }

  public Key min() { // Keep going down left children until bottom
    if (this.size == 0) return null;
    Node current = top;
    int comparisons = 1;

    while (current.leftchild != null) {
      comparisons++;
      current = current.leftchild;
    }
    System.out.println(comparisons + " comparisons");
    return current.entry.k;
  }

  public Key max() { // Keep going down right children until bottom
    if (this.size == 0) return null;
    Node current = top;
    int comparisons = 1;

    while (current.rightchild != null) {
      comparisons++;
      current = current.rightchild;
    }
    System.out.println(comparisons + " comparisons");
    return current.entry.k;
  }

  public boolean contains(Key key) {
    return this.get(key) == null;
  }

  public boolean isEmpty() {
    return this.size == 0;
  }

  public int size() {
    return this.size;
  }

  private String toString(String delim) {
    ArrayList<Entry> entries = new ArrayList<>();
    this.getEntries(this.top, entries);

    StringBuilder out = new StringBuilder();
    for (Entry entry : entries) {
      out.append(delim).append(entry.toString());
    }
    return out.toString().substring(delim.length()); // Remove the first delimeter
  }

  public String toString() {
    return this.toString(", ");
  }

  // -----------------------------------------------
  // Main method to test your code
  // -----------------------------------------------
  public static void main (String[] args) {

  }

}
