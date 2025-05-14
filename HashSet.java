// Time Complexity : O(1) for all methods
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : None

// use double hashing and make search O(1)
class MyHashSet {

    int ARRAY_SIZE = 1000;
    boolean[][] storage;

    private int primaryHash(int key){
        return key % 1000;
    }

    private int secondaryHash(int key){
        return key / 1000;
    }

    public MyHashSet() {
        storage = new boolean[1000][];
    }

    public void add(int key) {
        int primaryIndex = primaryHash(key);
        int secondaryIndex = secondaryHash(key);

        if(storage[primaryIndex] == null){
            storage[primaryIndex] = new boolean[1001];
            storage[primaryIndex][secondaryIndex] = true;
        }else{
            storage[primaryIndex][secondaryIndex] = true;
        }

    }

    public void remove(int key) {
        int primaryIndex = primaryHash(key);
        int secondaryIndex = secondaryHash(key);

        if(storage[primaryIndex] != null && storage[primaryIndex][secondaryIndex] == true){
            storage[primaryIndex][secondaryIndex] = false;
        }
    }

    public boolean contains(int key) {
        int primaryIndex = primaryHash(key);
        int secondaryIndex = secondaryHash(key);

        if(storage[primaryIndex] != null && storage[primaryIndex][secondaryIndex] == true){
            return true;
        }
        return false;
    }
}
