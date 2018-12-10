public class TestMyMaps {
  public static void main (String[] args) {
    // your code goes here
    
    MapCS2<Integer, String> hashMap = new HashMapCS2<>();
    MapCS2<Integer, String> treeMap = new TreeMapCS2<>();

    hashMap.put(5, "dog");
    hashMap.put(22, "lion");
    hashMap.put(36, "cat");
    hashMap.put(73, "elephant");
    hashMap.put(89, "monkey");
    hashMap.put(177, "donkey");
    hashMap.put(215, "cheetah");
    hashMap.put(315, "panda");
    hashMap.put(470, "aligator");
    hashMap.put(496, "koala");

    treeMap.put(5, "dog");
    treeMap.put(22, "lion");
    treeMap.put(36, "cat");
    treeMap.put(73, "elephant");
    treeMap.put(89, "monkey");
    treeMap.put(177, "donkey");
    treeMap.put(215, "cheetah");
    treeMap.put(315, "panda");
    treeMap.put(470, "aligator");
    treeMap.put(496, "koala");

    System.out.println("Hash min: " + hashMap.min());
    System.out.println();
    System.out.println("Tree min: " + treeMap.min());
    System.out.println();

    System.out.println("Hash max: " + hashMap.max());
    System.out.println();
    System.out.println("Tree max: " + treeMap.max());
    System.out.println();


    System.out.println();

    hashMap = new HashMapCS2<>();
    treeMap = new TreeMapCS2<>();

    hashMap.put(177, "donkey");
    hashMap.put(215, "cheetah");
    hashMap.put(89, "monkey");
    hashMap.put(315, "panda");
    hashMap.put(73, "elephant");
    hashMap.put(470, "aligator");
    hashMap.put(22, "lion");
    hashMap.put(5, "dog");
    hashMap.put(36, "cat");
    hashMap.put(496, "koala");

    treeMap.put(177, "donkey");
    treeMap.put(215, "cheetah");
    treeMap.put(89, "monkey");
    treeMap.put(315, "panda");
    treeMap.put(73, "elephant");
    treeMap.put(470, "aligator");
    treeMap.put(22, "lion");
    treeMap.put(5, "dog");
    treeMap.put(36, "cat");
    treeMap.put(496, "koala");

    System.out.println("Hash min: " + hashMap.min());
    System.out.println();
    System.out.println("Tree min: " + treeMap.min());
    System.out.println();

    System.out.println("Hash max: " + hashMap.max());
    System.out.println();
    System.out.println("Tree max: " + treeMap.max());
    System.out.println();

    System.out.println(hashMap);
    System.out.println(treeMap);


    // Hash map always has to iterate through every item in the map, which is why it requires 10
    // comparisons.
    // Tree map's number of comparisons depends on how it was created--by the order of its keys. If
    // the keys are fed in order, as in the first example, the minimum would be easy to find: it's
    // the first element, only 1 comparisons needed. To find the maximum, it has to keep going down
    // the right children until it hits the bottom, which requires 10 comparisons. If the keys are
    // fed in a random order, like with the second example, the tree will be more balanced, which
    // evens out the number of comparisons to approximately 1.6 log_2 n for both
  }
}
