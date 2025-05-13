// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :

class MyHashSet {

    int ARRAY_SIZE = 100;
    List<List<Integer>> hashList;

    public MyHashSet() {
        hashList = new ArrayList<>(ARRAY_SIZE);
        for (int i = 0; i < ARRAY_SIZE; i++) {
            hashList.add(null);
        }
    }

    public void add(int key) {
        int index = key % ARRAY_SIZE;
        List<Integer> ll = hashList.get(index);

        if( ll == null){
            ll = new LinkedList<>();
            ll.add(key);
            hashList.set(index, ll);
        }else{
            if(!ll.contains(key)){
                ll.add(key);
            }
        }
    }

    public void remove(int key) {
        int index = key % ARRAY_SIZE;
        List ll = hashList.get(index);

        if (ll != null && ll.contains(key)) {
            ll.remove(Integer.valueOf(key));
        }
    }

    public boolean contains(int key) {
        int index = key % ARRAY_SIZE;
        List ll = hashList.get(index);

        if (ll != null && ll.contains(key)) {
            return true;
        }
        return false;
    }
}
