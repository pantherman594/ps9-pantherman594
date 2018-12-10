import java.util.*;

public class HashMapCS2<Key extends Comparable<Key>, Value> implements MapCS2<Key, Value> {

  // _________________________________________
  // Note: Once you have implemented all the
  // interface methods, be sure to add implements
  // MapCS2 in the class declaration above.
  // _________________________________________


  // -----------------------------------------
  // Inner class: KeyValuePair
  // ------------------------------------------
  public class KeyValuePair {
    Key k;
    Value v;

    public KeyValuePair(Key k, Value v) {
      this.k = k;
      this.v = v;
    }

    public String toString() {
      return this.k + " : " + this.v;
    }
  }


  // -----------------------------------------
  // Member variables: storage array and size
  // ------------------------------------------

  // An ArrayList of LinkedLists.
  // The indices into the ArrayList will correspond
  // to hashcodes. At each index in the ArrayList, you will have
  // a LinkedList of KeyValuePairs. This is how you will implement
  // separate chaining when your hash function produces collisions.
  ArrayList<LinkedList<KeyValuePair>> storage;

  // A variable containing the size of the storage array.
  int size;

  // -----------------------------------------------
  // Constructor
  // -----------------------------------------------
  // I have written the HashMapCS2 constructor for you.
  // We create an ArrayList with 31 elements.
  // Each element is an empty LinkedList.
  // Each LinkedList will hold KeyValuePair objects,
  // one for each key you add with that hashcode.
  public HashMapCS2() {
    this.storage = new ArrayList<LinkedList<KeyValuePair>>();
    for (int i=0; i < 31; i++) {
      storage.add(new LinkedList<KeyValuePair>());
    }
    this.size = 0;
  }


  // -----------------------------------------------
  // Hash functions
  // -----------------------------------------------
  // Fill in the blanks below, following the instructions.
  int hashFunction(Key k) {
    int hashcode = 0;

    if (k instanceof String) {
      String s = (String) k;
      // implement this String hash function:
      /* for each char in the String s:
          multiply the int value of the char by (position in the String + 1)
          add that to the current total
         hashcode is the remainder of the final divided by 31
      */

      for (int i = 0, len = s.length(); i < len; i++) {
        hashcode += (int) s.charAt(i) * (i + 1);
      }
    } else if (k instanceof Double) {
      Double d = (Double) k;
      // implement this Double hash function:
      /* hashcode is the remainder of the absolute value d
         as an integer when divided by 31
      */

      hashcode = Math.abs((int) (double) d);
    } else if (k instanceof Integer) {
      Integer q = (Integer) k;
      // implement this Integer hash function:
      /* hashcode is the remainder of the absolute value of q
         when divided by 31
      */

      hashcode = Math.abs((int) q);
    } else {
      // If hashcode returns -1, you have a problem! Throw an exception
      throw new IllegalArgumentException("Invalid key type.");
    }
    return hashcode % 31;
  }


  // -----------------------------------------------
  // Interface methods to implement
  // -----------------------------------------------
  /*
  Value get(Key key);           // returns a Value for the specified key
  void put(Key key, Value val); // puts a Key-Value pair in the map
  ArrayList<Key> getKeys();     // returns the keys of the map as an ArrayList
  Key min();                    // returns the minimum key in the map
  Key max();                    // returns the maximum key in the map
  boolean contains(Key key);    // returns true if the map contains the key
  boolean isEmpty();            // returns true if map is empty
  int size();                   // returns size of map
  String toString();            // returns a string with each key : value pair
  */

  private LinkedList<KeyValuePair> getEntries(Key key) {
    int hashcode = this.hashFunction(key); // Compute the hash code for the key
    return this.storage.get(hashcode); // Get all the key value pairs with that hash code
  }

  private KeyValuePair getKeyValuePair(Key key) {
    // Find the key in the key value pairs
    for (KeyValuePair entry : this.getEntries(key)) {
      if (entry.k.equals(key)) {
        return entry;
      }
    }
    return null; // Key isn't in the map: return null
  }

  public Value get(Key key) {
    if (this.size == 0) return null;
    KeyValuePair entry = this.getKeyValuePair(key);

    return entry == null ? null : entry.v;
  }

  public void put(Key key, Value val) {
    LinkedList<KeyValuePair> entries = this.getEntries(key);

    // Find the key in the key value pairs
    for (KeyValuePair entry : entries) {
      if (entry.k.equals(key)) {
        entry.v = val;
        return; // Matching key was found. Don't create a new one, just change the value
      }
    }

    entries.add(new KeyValuePair(key, val));
    this.size++;
  }

  public ArrayList<Key> getKeys() {
    ArrayList<Key> keys = new ArrayList<>();
    for (KeyValuePair entry : this.getKeyValuePairs()) {
      keys.add(entry.k);
    }
    return keys;
  }

  public Key min() {
    int comparisons = 0;
    Key min = null;
    for (KeyValuePair entry : this.getKeyValuePairs()) {
      comparisons++;
      if (min == null || min.compareTo(entry.k) > 0) {
        min = entry.k;
      }
    }
    System.out.println(comparisons + " comparisons");
    return min;
  }

  public Key max() {
    int comparisons = 0;
    Key max = null;
    for (KeyValuePair entry : this.getKeyValuePairs()) {
      comparisons++;
      if (max == null || max.compareTo(entry.k) < 0) {
        max = entry.k;
      }
    }
    System.out.println(comparisons + " comparisons");
    return max;
  }

  public boolean contains(Key key) {
    for (KeyValuePair entry : this.getEntries(key)) {
      if (entry.k.equals(key)) {
        return true;
      }
    }
    return false;
  }

  public boolean isEmpty() {
    return this.size == 0;
  }

  public int size() {
    return this.size;
  }

  private String toString(String delim) {
    StringBuilder out = new StringBuilder();
    for (KeyValuePair entry : this.getKeyValuePairs()) {
      out.append(delim).append(entry.toString());
    }
    return out.toString().substring(delim.length()); // Remove the first delimeter
  }

  public String toString() {
    return this.toString(", ");
  }

  private ArrayList<KeyValuePair> getKeyValuePairs() {
    ArrayList<KeyValuePair> keyValuePairs = new ArrayList<>();
    for (LinkedList<KeyValuePair> row : this.storage) {
      keyValuePairs.addAll(row);
    }

    return keyValuePairs;
  }

  // -----------------------------------------------
  // Main method to test out your code
  // -----------------------------------------------
  public static void main (String[] args) {

  }

}
